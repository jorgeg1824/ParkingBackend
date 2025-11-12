package co.edu.uco.parking.business.business.rule.cell;

import java.util.UUID;

import co.edu.uco.parking.business.business.rule.Rule;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.factory.DAOFactory;

public final class CellIdNotDuplicateRule implements Rule {
	
	private static final Rule instance = new CellIdNotDuplicateRule();
	
	private CellIdNotDuplicateRule() {
	}
	
	public static void executeRule(final Object...data) {
		instance.execute(data);
	}

    @Override
    public void execute(final Object... data) {

        if (ObjectHelper.isNull(data)) {
            var userMessage = MessagesEnum.USER_ERROR_RULE_NULL_DATA_CELL_ID.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_NULL_DATA_CELL_ID.getContent();
            throw ParkingException.create(userMessage, technicalMessage);
        }

        if (data.length < 2) {
        	var userMessage = MessagesEnum.USER_ERROR_RULE_INSUFFICIENT_DATA_CELL_ID.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_INSUFFICIENT_DATA_CELL_ID.getContent();
            throw ParkingException.create(userMessage, technicalMessage);
        }

        var id = (UUID) data[0];
        var daoFactory = (DAOFactory) data[1];

        if (UUIDHelper.getUUIDHelper().isDefaultUUID(id)) {
        	var userMessage = MessagesEnum.USER_ERROR_RULE_DEFAULT_UUID_CELL_ID.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_DEFAULT_UUID_CELL_ID.getContent();
            throw ParkingException.create(userMessage, technicalMessage);
        }

        var found = daoFactory.getCellDAO().findById(id);

        if (!ObjectHelper.isNull(found) && !UUIDHelper.getUUIDHelper().isDefaultUUID(found.getId())) {
        	var userMessage = MessagesEnum.USER_ERROR_RULE_DUPLICATE_CELL_ID.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_DUPLICATE_CELL_ID.getContent();
            throw ParkingException.create(userMessage, technicalMessage);
        }
    }
}
