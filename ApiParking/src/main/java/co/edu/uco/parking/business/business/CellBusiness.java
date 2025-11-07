package co.edu.uco.parking.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.business.domain.CellDomain;

public interface CellBusiness {

	void registerNewCellInformation(CellDomain cellDomain);
	
	void dropCellInformation(UUID id);
	
	void updateCellInformation(UUID id, CellDomain cellDomain);
	
	List<CellDomain> findAllCells();
	
	List<CellDomain> findCellsByFilter(CellDomain cellFilters);
	
	CellDomain findSpecificCell(UUID id);
	
}
