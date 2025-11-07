package co.edu.uco.parking.business.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.business.assembler.dto.impl.CellDTOAssembler;
import co.edu.uco.parking.business.business.impl.CellBusinessImpl;
import co.edu.uco.parking.business.domain.CellDomain;
import co.edu.uco.parking.business.facade.CellFacade;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.factory.DAOFactory;
import co.edu.uco.parking.dto.CellDTO;

public class CellFacadeImpl implements CellFacade {

	@Override
	public void registerNewCellInformation(final CellDTO cellDto) {
		var daoFactory = DAOFactory.getDAOFactory();
		var business = new CellBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			
			var domain = CellDTOAssembler.getCellDTOAssembler().toDomain(cellDto);
			business.registerNewCellInformation(domain);
			
			daoFactory.commitTransaction();
		} catch(final ParkingException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = MessagesEnum.USER_ERROR_FACADE_REGISTER_CELL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_REGISTER_CELL.getContent();
			throw ParkingException.create(exception, technicalMessage, userMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void dropCellInformation(final UUID id) {
		var daoFactory = DAOFactory.getDAOFactory();
		var business = new CellBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			business.dropCellInformation(id);
			daoFactory.commitTransaction();
		} catch(final ParkingException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = MessagesEnum.USER_ERROR_FACADE_DROP_CELL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_DROP_CELL.getContent();
			throw ParkingException.create(exception, technicalMessage, userMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void updateCellInformation(final UUID id, final CellDTO cellDto) {
		var daoFactory = DAOFactory.getDAOFactory();
		var business = new CellBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			
			var domain = CellDTOAssembler.getCellDTOAssembler().toDomain(cellDto);
			business.updateCellInformation(id, domain);
			
			daoFactory.commitTransaction();
		} catch(final ParkingException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = MessagesEnum.USER_ERROR_FACADE_UPDATE_CELL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_UPDATE_CELL.getContent();
			throw ParkingException.create(exception, technicalMessage, userMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<CellDTO> findAllCells() {
		var daoFactory = DAOFactory.getDAOFactory();
		var business = new CellBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			var domains = business.findAllCells();
			daoFactory.commitTransaction();
			
			var dtos = new ArrayList<CellDTO>();
			var assembler = CellDTOAssembler.getCellDTOAssembler();
			if (domains != null) {
				for (var d : domains) {
					dtos.add(assembler.toDTO(d));
				}
			}
			
			return dtos;
			
		} catch(final ParkingException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = MessagesEnum.USER_ERROR_FACADE_FIND_ALL_CELLS.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_FIND_ALL_CELLS.getContent();
			throw ParkingException.create(exception, technicalMessage, userMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<CellDTO> findCellsByFilter(final CellDTO cellFilters) {
		var daoFactory = DAOFactory.getDAOFactory();
		var business = new CellBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			
			var filterDomain = CellDTOAssembler.getCellDTOAssembler().toDomain(cellFilters);
			var domains = business.findCellsByFilter(filterDomain);
			
			daoFactory.commitTransaction();
			
			var dtos = new ArrayList<CellDTO>();
			var assembler = CellDTOAssembler.getCellDTOAssembler();
			if (domains != null) {
				for (var d : domains) {
					dtos.add(assembler.toDTO(d));
				}
			}
			
			return dtos;
			
		} catch(final ParkingException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = MessagesEnum.USER_ERROR_FACADE_FIND_CELLS_BY_FILTER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_FIND_CELLS_BY_FILTER.getContent();
			throw ParkingException.create(exception, technicalMessage, userMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public CellDTO findSpecificCell(final UUID id) {
		var daoFactory = DAOFactory.getDAOFactory();
		var business = new CellBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			var filterDomain = new CellDomain();
			filterDomain.setId(id);
			var results = business.findCellsByFilter(filterDomain);
			
			daoFactory.commitTransaction();
			
			if (results == null || results.isEmpty()) {
				return null;
			}
			
			return CellDTOAssembler.getCellDTOAssembler().toDTO(results.get(0));
			
		} catch(final ParkingException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = MessagesEnum.USER_ERROR_FACADE_FIND_SPECIFIC_CELL.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_FIND_SPECIFIC_CELL.getContent();
			throw ParkingException.create(exception, technicalMessage, userMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

}
