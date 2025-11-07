package co.edu.uco.parking.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.business.domain.ZoneDomain;

public interface ZoneBusiness {

	void registerNewZoneInformation(ZoneDomain zoneDomain);
	
	void dropZoneInformation(UUID id);
	
	void updateZoneInformation(UUID id, ZoneDomain zoneDomain);
	
	List<ZoneDomain> findAllZones();
	
	List<ZoneDomain> findZonesByFilter(ZoneDomain zoneFilters);
	
	ZoneDomain findSpecificZone(UUID id);
	
}
