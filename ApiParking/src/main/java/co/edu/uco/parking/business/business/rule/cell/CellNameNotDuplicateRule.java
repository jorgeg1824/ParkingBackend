package co.edu.uco.parking.business.business.rule.cell;

import java.util.ArrayList;

import co.edu.uco.parking.business.business.rule.Rule;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.factory.DAOFactory;
import co.edu.uco.parking.entity.CellEntity;

public final class CellNameNotDuplicateRule implements Rule {
	
	private static final Rule instance = new CellNameNotDuplicateRule();
	
	private CellNameNotDuplicateRule() {
	}
	
	public static void executeRule(final Object...data) {
		instance.execute(data);
	}

    @Override
    public void execute(final Object... data) {
        
        if (ObjectHelper.isNull(data)) {
        	var userMessage = MessagesEnum.USER_ERROR_RULE_CELLNAME_DUPLICATE_DATA_NULL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_CELLNAME_DUPLICATE_DATA_NULL.getContent();
			throw ParkingException.create(userMessage, technicalMessage);
        }

        if (data.length < 2) {
        	var userMessage = MessagesEnum.USER_ERROR_RULE_CELLNAME_DUPLICATE_INSUFFICIENT_DATA.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_CELLNAME_DUPLICATE_INSUFFICIENT_DATA.getContent();
			throw ParkingException.create(userMessage, technicalMessage);
        }

        var name = TextHelper.getDefaultWithTrim((String) data[0]);
        var daoFactory = (DAOFactory) data[1];

        if (TextHelper.isEmpty(name)) {
        	var userMessage = MessagesEnum.USER_ERROR_RULE_CELLNAME_DUPLICATE_EMPTY_NAME.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_CELLNAME_DUPLICATE_EMPTY_NAME.getContent();
			throw ParkingException.create(userMessage, technicalMessage);
        }

        var cellDao = daoFactory.getCellDAO();
        var filter = new CellEntity();
        filter.setName(name);

        var found = ObjectHelper.getDefault(cellDao.findByFilter(filter), new ArrayList<>());

        if (!found.isEmpty()) {
        	var userMessage = MessagesEnum.USER_ERROR_RULE_CELLNAME_DUPLICATE_FOUND.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_CELLNAME_DUPLICATE_FOUND.getContent();
			throw ParkingException.create(userMessage, technicalMessage);
        }

    }
}
