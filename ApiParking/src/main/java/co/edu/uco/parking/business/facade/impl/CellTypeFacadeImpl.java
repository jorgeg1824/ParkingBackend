package co.edu.uco.parking.business.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.business.assembler.dto.impl.CellTypeDTOAssembler;
import co.edu.uco.parking.business.business.impl.CellTypeBusinessImpl;
import co.edu.uco.parking.business.domain.CellTypeDomain;
import co.edu.uco.parking.business.facade.CellTypeFacade;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.factory.DAOFactory;
import co.edu.uco.parking.dto.CellTypeDTO;

public class CellTypeFacadeImpl implements CellTypeFacade {

	@Override
	public void registerNewCellTypeInformation(final CellTypeDTO cellTypeDto) {

		var daoFactory = DAOFactory.getDAOFactory();
		var business = new CellTypeBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			
			var domain = CellTypeDTOAssembler.getCellTypeDTOAssembler().toDomain(cellTypeDto);
			business.registerNewCellTypeInformation(domain);
			
			daoFactory.commitTransaction();
		} catch(final ParkingException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			
			var userMessage = MessagesEnum.USER_ERROR_FACADE_REGISTER_CELL_TYPE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_REGISTER_CELL_TYPE.getContent();
			
			throw ParkingException.create(exception, technicalMessage, userMessage);
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void dropCellTypeInformation(final UUID id) {
		var daoFactory = DAOFactory.getDAOFactory();
		var business = new CellTypeBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			business.dropCellTypeInformation(id);
			daoFactory.commitTransaction();
		} catch(final ParkingException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			
			var userMessage = MessagesEnum.USER_ERROR_FACADE_DROP_CELL_TYPE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_DROP_CELL_TYPE.getContent();
			
			throw ParkingException.create(exception, technicalMessage, userMessage);
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void updateCellTypeInformation(final UUID id, final CellTypeDTO cellTypeDto) {
		var daoFactory = DAOFactory.getDAOFactory();
		var business = new CellTypeBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			
			var domain = CellTypeDTOAssembler.getCellTypeDTOAssembler().toDomain(cellTypeDto);
			business.updateCellTypeInformation(id, domain);
			
			daoFactory.commitTransaction();
		} catch(final ParkingException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			
			var userMessage = MessagesEnum.USER_ERROR_FACADE_UPDATE_CELL_TYPE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_UPDATE_CELL_TYPE.getContent();
			
			throw ParkingException.create(exception, technicalMessage, userMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<CellTypeDTO> findAllCellTypes() {
		var daoFactory = DAOFactory.getDAOFactory();
		var business = new CellTypeBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			
			var domains = business.findAllCellTypes();
			
			daoFactory.commitTransaction();
			
			var dtos = new ArrayList<CellTypeDTO>();
			var assembler = CellTypeDTOAssembler.getCellTypeDTOAssembler();
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
			
			var userMessage = MessagesEnum.USER_ERROR_FACADE_LIST_CELL_TYPES.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_LIST_CELL_TYPES.getContent();
			
			throw ParkingException.create(exception, technicalMessage, userMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<CellTypeDTO> findCellTypesByFilter(final CellTypeDTO cellTypeFilters) {
		var daoFactory = DAOFactory.getDAOFactory();
		var business = new CellTypeBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			
			var filterDomain = CellTypeDTOAssembler.getCellTypeDTOAssembler().toDomain(cellTypeFilters);
			var domains = business.findCellTypesByFilter(filterDomain);
			
			daoFactory.commitTransaction();
			
			var dtos = new ArrayList<CellTypeDTO>();
			var assembler = CellTypeDTOAssembler.getCellTypeDTOAssembler();
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
			
			var userMessage = MessagesEnum.USER_ERROR_FACADE_FILTER_CELL_TYPES_BY_FILTER.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_FILTER_CELL_TYPES_BY_FILTER.getContent();
			
			throw ParkingException.create(exception, technicalMessage, userMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public CellTypeDTO findSpecificCellType(final UUID id) {
		var daoFactory = DAOFactory.getDAOFactory();
		var business = new CellTypeBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			
			var filerDomain = new CellTypeDomain();
			filerDomain.setId(id);
			var results = business.findCellTypesByFilter(filerDomain);
			
			daoFactory.commitTransaction();
			
			if (results == null || results.isEmpty()) {
				return null;
			}
			
			return CellTypeDTOAssembler.getCellTypeDTOAssembler().toDTO(results.get(0));
			
		} catch(final ParkingException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			
			var userMessage = MessagesEnum.USER_ERROR_FACADE_FIND_SPECIFIC_CELL_TYPE.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_FIND_SPECIFIC_CELL_TYPE.getContent();
			
			throw ParkingException.create(exception, technicalMessage, userMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

}
