package co.edu.uco.parking.business.business.rule.cell;

import co.edu.uco.parking.business.business.rule.Rule;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;

public final class CellNameFormatRule implements Rule {
	
	private static final Rule instance = new CellNameFormatRule();
	
	private CellNameFormatRule() {
	}
	
	public static void executeRule(final Object...data) {
		instance.execute(data);
	}

    @Override
    public void execute(final Object... data) {

        if (ObjectHelper.isNull(data) || data.length < 1) {
        	var userMessage = MessagesEnum.USER_ERROR_RULE_NULL_OR_INSUFFICIENT_DATA_CELL_NAME.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_NULL_OR_INSUFFICIENT_DATA_CELL_NAME.getContent();
            throw ParkingException.create(userMessage, technicalMessage);
        }

        var name = TextHelper.getDefaultWithTrim((String) data[0]);

        if (!TextHelper.matchesPattern(name, "^[A-Z]-\\d+$")) {
        	var userMessage = MessagesEnum.USER_ERROR_RULE_INVALID_FORMAT_CELL_NAME.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_INVALID_FORMAT_CELL_NAME.getContent();
            throw ParkingException.create(userMessage, technicalMessage);
        }
    }
}
