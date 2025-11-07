package co.edu.uco.parking.business.business.rule.generics;

import co.edu.uco.parking.business.business.rule.Rule;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;

public final class StringLengthValueIsValidRule implements Rule {
	
	@Override
	public void execute(final Object... data) {
		if(ObjectHelper.isNull(data)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar la operación deseada.";
			var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla StringLengthValueIsValidRule.";
			throw ParkingException.create(userMessage, technicalMessage);
		}
		
		if(data.length < 5) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar la operación deseada.";
			var technicalMessage = "Se requerian cinco parametros y llego una cantidad menor a esta requeridos para ejecutar la regla StringLengthValueIsValidRule.";
			throw ParkingException.create(userMessage, technicalMessage);
		}
		
		var stringData = (String) data[0];
		var dataName = (String) data[1];
		var minLength = (Integer) data[2];
		var maxLength = (Integer) data[3];
		boolean mustApplyTrim = (Boolean) data[4];
		
		if(TextHelper.lengthIsValid(stringData, minLength, maxLength, mustApplyTrim)) {
			var userMessage = "El dato [".concat(dataName).concat("] no tiene una longitud entre ").concat(String.valueOf(minLength)).concat(" y ").concat(String.valueOf(maxLength)).concat("...");
			var technicalMessage = "La regla StringLengthValueIsValidRule falló porque el dato [".concat(dataName).concat("] requerido para llevar a cabo la operación no tiene una longitud entre ").concat(String.valueOf(minLength)).concat(" y ").concat(String.valueOf(maxLength)).concat("...");
			throw ParkingException.create(userMessage, technicalMessage);
		}
	}

}
