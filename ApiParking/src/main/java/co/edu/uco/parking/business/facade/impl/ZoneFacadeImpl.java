package co.edu.uco.parking.business.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.business.assembler.dto.impl.ZoneDTOAssembler;
import co.edu.uco.parking.business.business.impl.ZoneBusinessImpl;
import co.edu.uco.parking.business.facade.ZoneFacade;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.factory.DAOFactory;
import co.edu.uco.parking.dto.ZoneDTO;

public class ZoneFacadeImpl implements ZoneFacade {

	@Override
	public void registerNewZoneInformation(ZoneDTO zoneDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropZoneInformation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateZoneInformation(UUID id, ZoneDTO zoneDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ZoneDTO> findAllZones() {
		var daoFactory = DAOFactory.getDAOFactory();
		var business = new ZoneBusinessImpl(daoFactory);
		
		try {
			daoFactory.initTransaction();
			
			var domains = business.findAllZones();
			
			daoFactory.commitTransaction();
			
			var dtos = new ArrayList<ZoneDTO>();
			var assembler = ZoneDTOAssembler.getZoneDTOAssembler();
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
			
			var userMessage = MessagesEnum.USER_ERROR_FACADE_LIST_ZONES.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FACADE_LIST_ZONES.getContent();
			
			throw ParkingException.create(exception, technicalMessage, userMessage);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public List<ZoneDTO> findZonesByFilter(ZoneDTO zoneFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZoneDTO findSpecificZone(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
