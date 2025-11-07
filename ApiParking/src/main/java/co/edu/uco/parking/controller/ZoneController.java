package co.edu.uco.parking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.parking.business.facade.impl.ZoneFacadeImpl;
import co.edu.uco.parking.controller.dto.Response;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.dto.ZoneDTO;

@RestController
@RequestMapping("/api/v1/zones")
public class ZoneController {
	
	@GetMapping("/dummy")
	public ZoneDTO getZoneDTODummy() {
		return new ZoneDTO();
	}
	
	@GetMapping
	public ResponseEntity<Response<ZoneDTO>> findAllZones(){
		
		Response<ZoneDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			var facade = new ZoneFacadeImpl();
			responseObjectData.setData(facade.findAllZones());
			responseObjectData.addMessage("Zones found successfully");
			
		} catch (final ParkingException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		} catch (Exception exception) {
			var userMessage = MessagesEnum.USER_ZONE_ERROR_DAO_FINDING_ALL_ZONES.getContent();
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage.toString());
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}

}
