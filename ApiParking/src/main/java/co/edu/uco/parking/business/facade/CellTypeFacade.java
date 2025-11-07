package co.edu.uco.parking.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.dto.CellTypeDTO;

public interface CellTypeFacade {

	void registerNewCellTypeInformation(CellTypeDTO cellTypeDto);
	
	void dropCellTypeInformation(UUID id);
	
	void updateCellTypeInformation(UUID id, CellTypeDTO cellTypeDto);
	
	List<CellTypeDTO> findAllCellTypes();
	
	List<CellTypeDTO> findCellTypesByFilter(CellTypeDTO cellTypeFilters);
	
	CellTypeDTO findSpecificCellType(UUID id);
	
}
