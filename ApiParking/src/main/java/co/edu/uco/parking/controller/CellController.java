package co.edu.uco.parking.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.parking.business.facade.impl.CellFacadeImpl;
import co.edu.uco.parking.controller.dto.Response;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.dto.CellDTO;

@RestController
@RequestMapping("/api/v1/cells")
public class CellController {
	
	@GetMapping("/dummy")
	public CellDTO getCellDTODummy() {
		return new CellDTO();
	}
	
	@GetMapping
	public ResponseEntity<Response<CellDTO>> findAllCells() {
		
		Response<CellDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			var facade = new CellFacadeImpl();
			responseObjectData.setData(facade.findAllCells());
			responseObjectData.addMessage("Cells found successfully");
			
		}catch (final ParkingException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		}catch (Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_DAO_UNEXPECTED_ERROR_FINDING_ALL_USERS.getContent();
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage);
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<CellDTO>> findById(@PathVariable("id") final UUID id){
		
		Response<CellDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
		try {
			var facade = new CellFacadeImpl();
			var cell = facade.findSpecificCell(id);
			
			if (cell != null) {
				responseObjectData.setData(Collections.singletonList(cell));
				responseObjectData.addMessage("Cell found successfully");
			} else {
				responseObjectData.setData(new ArrayList<>());
				responseObjectData = Response.createFailedResponse();
				responseObjectData.addMessage("Cell not found");
				responseStatusCode = HttpStatus.NOT_FOUND;
			}
		} catch (final ParkingException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		} catch (Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_DAO_UNEXPECTED_ERROR_FINDING_ALL_USERS.getContent();
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage.toString());
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
		
	}
	
	@PostMapping
	public ResponseEntity<Response<CellDTO>> registerNewCellInformation(@RequestBody final CellDTO cell){
		
		Response<CellDTO> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.CREATED;
		
		try {
			var facade = new CellFacadeImpl();
			facade.registerNewCellInformation(cell);
			responseObjectData.addMessage("Cell registered successfully");
			
		} catch (final ParkingException exception) {
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(exception.getUserMessage());
			responseStatusCode = HttpStatus.BAD_REQUEST;
			exception.printStackTrace();
		} catch (Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_DAO_UNEXPECTED_ERROR_FINDING_ALL_USERS.getContent();
			responseObjectData = Response.createFailedResponse();
			responseObjectData.addMessage(userMessage.toString());
			responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);	
	}

}
