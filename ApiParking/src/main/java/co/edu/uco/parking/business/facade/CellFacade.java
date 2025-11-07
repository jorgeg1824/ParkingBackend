package co.edu.uco.parking.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.dto.CellDTO;

public interface CellFacade {

	void registerNewCellInformation(CellDTO cellDto);
	
	void dropCellInformation(UUID id);
	
	void updateCellInformation(UUID id, CellDTO cellDto);
	
	List<CellDTO> findAllCells();
	
	List<CellDTO> findCellsByFilter(CellDTO cellFilters);
	
	CellDTO findSpecificCell(UUID id);
	
}
