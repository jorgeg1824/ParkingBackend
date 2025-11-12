package co.edu.uco.parking.business.business.rule.celltype;

import java.util.UUID;

import co.edu.uco.parking.business.business.rule.Rule;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.factory.DAOFactory;

public final class CellTypeExistByIdRule implements Rule {
	
	private static final Rule instance = new CellTypeExistByIdRule();
	
	private CellTypeExistByIdRule() {
	}
	
	public static void executeRule(final Object...data) {
		instance.execute(data);
	}

	@Override
	public void execute(final Object... data) {
		
		if(ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_RULE_CELLTYPE_EXIST_BY_ID_DATA_NULL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_CELLTYPE_EXIST_BY_ID_DATA_NULL.getContent();
			throw ParkingException.create(userMessage, technicalMessage);
		}

		if(data.length < 2) {
			var userMessage = MessagesEnum.USER_ERROR_RULE_CELLTYPE_EXIST_BY_ID_INSUFFICIENT_DATA.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_CELLTYPE_EXIST_BY_ID_INSUFFICIENT_DATA.getContent();
			throw ParkingException.create(userMessage, technicalMessage);
		}
		
		var id = (UUID) data[0];
		var daoFactory = (DAOFactory) data[1];
		
		if(UUIDHelper.getUUIDHelper().isDefaultUUID(id)) {
			var userMessage = MessagesEnum.USER_ERROR_RULE_CELLTYPE_EXIST_BY_ID_INVALID_ID.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_CELLTYPE_EXIST_BY_ID_INVALID_ID.getContent();
			throw ParkingException.create(userMessage, technicalMessage);
		}
		
		var cellType = daoFactory.getCellTypeDAO().findById(id);
		
		if(ObjectHelper.isNull(cellType) || UUIDHelper.getUUIDHelper().isDefaultUUID(cellType.getId())) {
			var userMessage = MessagesEnum.USER_ERROR_RULE_CELLTYPE_EXIST_BY_ID_NOT_FOUND.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_RULE_CELLTYPE_EXIST_BY_ID_NOT_FOUND.getContent();
			throw ParkingException.create(userMessage, technicalMessage);
		}
	}
}
