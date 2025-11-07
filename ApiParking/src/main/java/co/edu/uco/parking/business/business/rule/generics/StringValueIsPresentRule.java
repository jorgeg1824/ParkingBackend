package co.edu.uco.parking.business.business.rule.generics;

import co.edu.uco.parking.business.business.rule.Rule;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;

public final class StringValueIsPresentRule implements Rule {

	@Override
	public void execute(final Object... data) {
		if(ObjectHelper.isNull(data)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar la operación deseada.";
			var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla StringValueIsPresentRule.";
			throw ParkingException.create(userMessage, technicalMessage);
		}
		
		if(data.length < 3) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar la operación deseada.";
			var technicalMessage = "Se requerian tres parametros y llego una cantidad menor a esta requeridos para ejecutar la regla StringValueIsPresentRule.";
			throw ParkingException.create(userMessage, technicalMessage);
		}
		
		var stringData = (String) data[0];
		var dataName = (String) data[1];
		boolean mustApplyTrim = (Boolean) data[2];
		
		if((mustApplyTrim) ? TextHelper.isEmptyWithTrim(stringData) : TextHelper.isEmpty(stringData)) {
			var userMessage = "El dato [".concat(dataName).concat("] es requerido para llevar a cabo la operación...");
			var technicalMessage = "La regla StringValueIsPresentRule falló porque el dato [".concat(dataName).concat("] requerido para llevar a cabo la operación está vacío...");
			throw ParkingException.create(userMessage, technicalMessage);
		}
	}

}
