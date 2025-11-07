package co.edu.uco.parking.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.dto.ZoneDTO;

public interface ZoneFacade {
	
	void registerNewZoneInformation(ZoneDTO zoneDto);
	
	void dropZoneInformation(UUID id);
	
	void updateZoneInformation(UUID id, ZoneDTO zoneDto);
	
	List<ZoneDTO> findAllZones();
	
	List<ZoneDTO> findZonesByFilter(ZoneDTO zoneFilters);
	
	ZoneDTO findSpecificZone(UUID id);

}
