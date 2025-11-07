package co.edu.uco.parking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.parking.business.facade.impl.CellTypeFacadeImpl;
import co.edu.uco.parking.controller.dto.Response;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.dto.CellTypeDTO;

@RestController
@RequestMapping("/api/v1/cell-types")
public class CellTypeController {
	
	@GetMapping("/dummy")
	public CellTypeDTO getCellTypeDTODummy() {
		return new CellTypeDTO();
	}
	
	@GetMapping
	public ResponseEntity<Response<CellTypeDTO>> findAllCellTypes(){
		
		Response<CellTypeDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			var facade = new CellTypeFacadeImpl();
			responseObjectData.setData(facade.findAllCellTypes());
			responseObjectData.addMessage("Cell types found successfully");
			
		} catch (final ParkingException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		} catch (Exception exception) {
			var userMessage = MessagesEnum.USER_CELL_TYPE_ERROR_DAO_FINDING_ALL_CELL_TYPES.getContent();
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage.toString());
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}

}
