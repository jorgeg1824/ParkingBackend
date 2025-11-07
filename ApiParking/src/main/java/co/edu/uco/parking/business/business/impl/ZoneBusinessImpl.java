package co.edu.uco.parking.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.business.assembler.entity.impl.ZoneEntityAssembler;
import co.edu.uco.parking.business.business.ZoneBusiness;
import co.edu.uco.parking.business.domain.ZoneDomain;
import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.factory.DAOFactory;

public final class ZoneBusinessImpl implements ZoneBusiness {
	
	private DAOFactory daoFactory; 
	
	public ZoneBusinessImpl(final DAOFactory daoFactory) { 
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void registerNewZoneInformation(ZoneDomain zoneDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropZoneInformation(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateZoneInformation(UUID id, ZoneDomain zoneDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ZoneDomain> findAllZones() {
		try {
            var zoneEntities = daoFactory.getZoneDAO().findAll();

            return zoneEntities.stream()
                    .map(ZoneEntityAssembler.getZoneEntityAssembler()::toDomain)
                    .toList();

        } catch (Exception e) {
            var userMessage = MessagesEnum.USER_ZONE_ERROR_DAO_FINDING_ALL_ZONES.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_ALL_ZONES.getContent();
            throw ParkingException.create(e, userMessage, technicalMessage);
        }
	}

	@Override
	public List<ZoneDomain> findZonesByFilter(final ZoneDomain zoneFilters) {
	    try {
	        var entityFilter = ZoneEntityAssembler.getZoneEntityAssembler().toEntity(zoneFilters);
	        
	        var entityList = daoFactory.getZoneDAO().findByFilter(entityFilter);

	        return entityList.stream()
	                .map(ZoneEntityAssembler.getZoneEntityAssembler()::toDomain)
	                .toList();

	    } catch (ParkingException e) {
	        throw e;
	    } catch (Exception e) {
	        var userMessage = MessagesEnum.USER_ZONE_UNEXPECTED_ERROR_DAO_FINDING_ZONE_BY_FILTER.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_DAO_FINDING_ZONE_BY_FILTER.getContent();
	        throw ParkingException.create(e, userMessage, technicalMessage);
	    }
	}


	@Override
	public ZoneDomain findSpecificZone(final UUID id) {
	    try {
	        var entity = daoFactory.getZoneDAO().findById(id);

	        if (entity == null) {
	            var userMessage = MessagesEnum.USER_ZONE_ERROR_DAO_FINDING_ZONE_BY_ID.getContent();
	            var techMessage = MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_ZONE_BY_ID.getContent();
	            throw ParkingException.create(userMessage, techMessage);
	        }

	        return ZoneEntityAssembler.getZoneEntityAssembler().toDomain(entity);

	    } catch (ParkingException exception) {
	        throw exception;
	    } catch (Exception exception) {
	        var userMessage = MessagesEnum.USER_ZONE_UNEXPECTED_ERROR_DAO_FINDING_ZONE_BY_ID.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_DAO_FINDING_ZONE_BY_ID.getContent();
	        throw ParkingException.create(exception, userMessage, technicalMessage);
	    }
	}


}
