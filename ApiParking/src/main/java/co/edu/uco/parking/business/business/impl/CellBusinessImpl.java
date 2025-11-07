package co.edu.uco.parking.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.business.assembler.entity.impl.CellEntityAssembler;
import co.edu.uco.parking.business.business.CellBusiness;
import co.edu.uco.parking.business.domain.CellDomain;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.factory.DAOFactory;
import co.edu.uco.parking.entity.CellEntity;

public final class CellBusinessImpl implements CellBusiness {
	
	private DAOFactory daoFactory; 
	
	public CellBusinessImpl(final DAOFactory daoFactory) { 
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void registerNewCellInformation(final CellDomain cellDomain) {
	    try {
	        var domain = ObjectHelper.getDefault(cellDomain,
	                new CellDomain());

	        if (domain.getName() == null || domain.getName().trim().isEmpty()) {
	            var userMessage = "El nombre de la celda es obligatorio.";
	            var techMessage = "El campo name en CellDomain es nulo o vacío.";
	            throw ParkingException.create(userMessage, techMessage);
	        }

	        if (domain.getName().trim().length() > 50) {
	            var userMessage = "El nombre de la celda no puede superar los 50 caracteres.";
	            var techMessage = "El campo name en CellDomain excede la longitud máxima (50).";
	            throw ParkingException.create(userMessage, techMessage);
	        }

	        if (domain.getCellType() == null ||
	            domain.getCellType().getId() == null ||
	            domain.getCellType().getId().equals(UUID.fromString("00000000-0000-0000-0000-000000000000"))) {

	            var userMessage = "El tipo de celda es obligatorio.";
	            var techMessage = "El campo cellType.id en CellDomain es nulo o tiene el UUID por defecto.";
	            throw ParkingException.create(userMessage, techMessage);
	        }

	        if (domain.getZone() == null ||
	            domain.getZone().getId() == null ||
	            domain.getZone().getId().equals(UUID.fromString("00000000-0000-0000-0000-000000000000"))) {

	            var userMessage = "La zona de la celda es obligatoria.";
	            var techMessage = "El campo zone.id en CellDomain es nulo o tiene el UUID por defecto.";
	            throw ParkingException.create(userMessage, techMessage);
	        }

	        var cellDao = daoFactory.getCellDAO();

	        var filterByName = new CellEntity();
	        filterByName.setName(domain.getName());

	        var foundByName = cellDao.findByFilter(filterByName);
	        if (foundByName != null && !foundByName.isEmpty()) {
	            for (var e : foundByName) {
	                if (e.getName().equalsIgnoreCase(domain.getName())) {
	                    var userMessage = "Ya existe una celda registrada con ese nombre.";
	                    var techMessage = "Se encontró una celda con nombre='" + domain.getName() + "'.";
	                    throw ParkingException.create(userMessage, techMessage);
	                }
	            }
	        }

	        if (domain.getId() == null || domain.getId().equals(UUID.fromString("00000000-0000-0000-0000-000000000000"))) {
	            domain.setId(UUID.randomUUID());
	        }

	        domain.setActive(true);

	        var cellEntityToCreate = CellEntityAssembler.getCellEntityAssembler().toEntity(domain);
	        cellDao.create(cellEntityToCreate);

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
