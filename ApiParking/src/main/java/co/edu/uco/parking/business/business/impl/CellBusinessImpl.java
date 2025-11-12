package co.edu.uco.parking.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.business.assembler.entity.impl.CellEntityAssembler;
import co.edu.uco.parking.business.business.CellBusiness;
import co.edu.uco.parking.business.business.validator.cell.RegisterNewCellValidator;
import co.edu.uco.parking.business.domain.CellDomain;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.factory.DAOFactory;

public final class CellBusinessImpl implements CellBusiness {
	
	private DAOFactory daoFactory; 
	
	public CellBusinessImpl(final DAOFactory daoFactory) { 
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void registerNewCellInformation(final CellDomain cellDomain) {
	    try {
	        var domain = ObjectHelper.getDefault(cellDomain, new CellDomain());
	        var daoFactory = this.daoFactory;
	        
	        new RegisterNewCellValidator(daoFactory).validate(domain);

	        if (ObjectHelper.isNull(domain.getId()) ||
	            domain.getId().equals(UUIDHelper.getUUIDHelper().getDefault())) {
	            domain.setId(UUID.randomUUID());
	        }

	        domain.setActive(true);

	        var cellEntityToCreate = CellEntityAssembler
	                .getCellEntityAssembler()
	                .toEntity(domain);
	        
	        daoFactory.getCellDAO().create(cellEntityToCreate);

	    } catch (ParkingException exception) {
	        throw exception;
	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_CELL_ERROR_DAO_CREATING_CELL.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_CREATING_CELL.getContent();
	        throw ParkingException.create(exception, userMessage, technicalMessage);
	    }
	}


	@Override
	public void dropCellInformation(final UUID id) {
	    try {
	        var entity = daoFactory.getCellDAO().findById(id);

	        if (entity == null) {
	            var userMessage = MessagesEnum.USER_CELL_ERROR_BUSINESS_CELL_NOT_FOUND.getContent();
	            var techMessage = MessagesEnum.TECHNICAL_ERROR_BUSINESS_CELL_NOT_FOUND.getContent();
	            throw ParkingException.create(userMessage, techMessage);
	        }

	        daoFactory.getCellDAO().delete(id);

	    } catch (ParkingException exception) {
	        throw exception;

	    } catch (Exception exception) {
	        var userMessage = MessagesEnum.USER_CELL_UNEXPECTED_ERROR_BUSINESS_DELETING_CELL.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_CELL_UNEXPECTED_ERROR_BUSINESS_DELETING_CELL.getContent();
	        throw ParkingException.create(exception, userMessage, technicalMessage);
	    }
	}

	@Override
	public void updateCellInformation(UUID id, CellDomain cellDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CellDomain> findAllCells() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CellDomain> findCellsByFilter(CellDomain cellFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CellDomain findSpecificCell(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
