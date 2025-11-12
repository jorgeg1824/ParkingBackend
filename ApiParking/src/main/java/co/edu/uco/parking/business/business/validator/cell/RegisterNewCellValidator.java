package co.edu.uco.parking.business.business.validator.cell;

import co.edu.uco.parking.business.business.rule.cell.CellIdNotDuplicateRule;
import co.edu.uco.parking.business.business.rule.cell.CellNameFormatRule;
import co.edu.uco.parking.business.business.rule.cell.CellNameLengthRule;
import co.edu.uco.parking.business.business.rule.cell.CellNameNotDuplicateRule;
import co.edu.uco.parking.business.business.rule.celltype.CellTypeExistByIdRule;
import co.edu.uco.parking.business.business.rule.zone.ZoneExistByIdRule;
import co.edu.uco.parking.business.business.validator.Validator;
import co.edu.uco.parking.business.domain.CellDomain;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.factory.DAOFactory;

public final class RegisterNewCellValidator implements Validator<CellDomain> {
	
	private final DAOFactory daoFactory;

	public RegisterNewCellValidator(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void validate(final CellDomain data) {
		if (ObjectHelper.isNull(data)) {
			var userMessage = MessagesEnum.USER_ERROR_VALIDATING_NULL_CELL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_VALIDATING_NULL_CELL.getContent();
			throw ParkingException.create(userMessage, technicalMessage);
		}

		validateNameRules(data);
		validateDatabaseRules(data);
	}

	private void validateNameRules(final CellDomain data) {
		CellNameFormatRule.executeRule(data.getName());
		CellNameLengthRule.executeRule(data.getName());
	}
	
	private void validateDatabaseRules(final CellDomain data) {
	    if (ObjectHelper.isNull(data.getCellType()) || ObjectHelper.isNull(data.getCellType().getId())) {
	    	var userMessage = MessagesEnum.USER_ERROR_VALIDATING_CELLTYPE_NULL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_VALIDATING_CELLTYPE_NULL.getContent();
			throw ParkingException.create(userMessage, technicalMessage);
	    }

	    if (ObjectHelper.isNull(data.getZone()) || ObjectHelper.isNull(data.getZone().getId())) {
	    	var userMessage = MessagesEnum.USER_ERROR_VALIDATING_ZONE_NULL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_VALIDATING_ZONE_NULL.getContent();
			throw ParkingException.create(userMessage, technicalMessage);
	    }

	    CellIdNotDuplicateRule.executeRule(data.getId(), daoFactory);
	    CellNameNotDuplicateRule.executeRule(data.getName(), daoFactory);
	    CellTypeExistByIdRule.executeRule(data.getCellType().getId(), daoFactory);
	    ZoneExistByIdRule.executeRule(data.getZone().getId(), daoFactory);
	}

}
