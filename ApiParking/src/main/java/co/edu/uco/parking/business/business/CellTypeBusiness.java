package co.edu.uco.parking.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.business.domain.CellTypeDomain;

public interface CellTypeBusiness {
	
	void registerNewCellTypeInformation(CellTypeDomain cellTypeDomain);
	
	void dropCellTypeInformation(UUID id);
	
	void updateCellTypeInformation(UUID id, CellTypeDomain cellTypeDomain);
	
	List<CellTypeDomain> findAllCellTypes();
	
	List<CellTypeDomain> findCellTypesByFilter(CellTypeDomain cellTypeFilters);
	
	CellTypeDomain findSpecificCellType(UUID id);

}
