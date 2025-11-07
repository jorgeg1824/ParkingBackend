package co.edu.uco.parking.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.parking.business.assembler.dto.DTOAssembler;
import co.edu.uco.parking.business.domain.CellTypeDomain;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.dto.CellTypeDTO;

public final class CellTypeDTOAssembler implements DTOAssembler<CellTypeDTO, CellTypeDomain> {
	
	private static final DTOAssembler<CellTypeDTO, CellTypeDomain> instance =
			new CellTypeDTOAssembler();
	
	private CellTypeDTOAssembler() {
	}
	
	public static DTOAssembler<CellTypeDTO, CellTypeDomain> getCellTypeDTOAssembler() {
		return instance;
	}

	@Override
	public CellTypeDTO toDTO(final CellTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CellTypeDomain());
		return new CellTypeDTO(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription(), domainTmp.isActive());
	}

	@Override
	public CellTypeDomain toDomain(final CellTypeDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new CellTypeDTO());
		return new CellTypeDomain(dtoTmp.getId(), dtoTmp.getName(), dtoTmp.getDescription(), dtoTmp.isActive());
	}

	@Override
	public List<CellTypeDTO> toDTO(List<CellTypeDomain> domainList) {
		var cellTypeDtoList = new ArrayList<CellTypeDTO>();
		
		for(var cellTypeDomain : domainList) {
			cellTypeDtoList.add(toDTO(cellTypeDomain));
		}
		
		return cellTypeDtoList;
	}
	

}
