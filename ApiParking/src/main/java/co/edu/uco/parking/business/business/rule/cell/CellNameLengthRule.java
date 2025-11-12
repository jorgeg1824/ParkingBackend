package co.edu.uco.parking.business.business.rule.cell;

import co.edu.uco.parking.business.business.rule.Rule;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;

public final class CellNameLengthRule implements Rule {
	
	private static final Rule instance = new CellNameLengthRule();
	
	private CellNameLengthRule() {
	}
	
	public static void executeRule(final Object...data) {
		instance.execute(data);
	}

    @Override
    public void execute(final Object... data) {

        if (ObjectHelper.isNull(data) || data.length < 1) {
        	var userMessage = MessagesEnum.USER_ERROR_RULE_NULL_OR_INSUFFICIENT_DATA_CELL_NAME_LENGTH.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_NULL_OR_INSUFFICIENT_DATA_CELL_NAME_LENGTH.getContent();
            throw ParkingException.create(userMessage, technicalMessage);
        }

        var name = TextHelper.getDefaultWithTrim((String) data[0]);

        if (!TextHelper.lengthIsValid(name, 1, 50, true)) {
        	var userMessage = MessagesEnum.USER_ERROR_RULE_INVALID_LENGTH_CELL_NAME.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_INVALID_LENGTH_CELL_NAME.getContent();
            throw ParkingException.create(userMessage, technicalMessage);
        }
    }
}
