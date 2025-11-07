package co.edu.uco.parking.business.assembler.dto.impl;

import static co.edu.uco.parking.business.assembler.dto.impl.CellTypeDTOAssembler.getCellTypeDTOAssembler;
import static co.edu.uco.parking.business.assembler.dto.impl.ZoneDTOAssembler.getZoneDTOAssembler;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.parking.business.assembler.dto.DTOAssembler;
import co.edu.uco.parking.business.domain.CellDomain;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.dto.CellDTO;

public final class CellDTOAssembler implements DTOAssembler<CellDTO, CellDomain> {
	
	private static final DTOAssembler<CellDTO, CellDomain> instance =
			new CellDTOAssembler();
	
	private CellDTOAssembler() {
	}
	
	public static DTOAssembler<CellDTO, CellDomain> getCellDTOAssembler() {
		return instance;
	}

	@Override
	public CellDTO toDTO(CellDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CellDomain());
		var cellTypeDtoTmp = getCellTypeDTOAssembler().toDTO(domainTmp.getCellType());
		var zoneDtoTmp = getZoneDTOAssembler().toDTO(domainTmp.getZone());
		
		return new CellDTO(domainTmp.getId(), domainTmp.getName(), cellTypeDtoTmp, zoneDtoTmp, domainTmp.isActive());
	}

	@Override
	public CellDomain toDomain(final CellDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new CellDTO());
		var cellTypeDomainTmp = getCellTypeDTOAssembler().toDomain(dtoTmp.getCellType());
		var zoneDomainTmp = getZoneDTOAssembler().toDomain(dtoTmp.getZone());
		
		return new CellDomain(dtoTmp.getId(), dtoTmp.getName(), cellTypeDomainTmp, zoneDomainTmp, dtoTmp.isActive());
	}

	@Override
	public List<CellDTO> toDTO(List<CellDomain> domainList) {
		var cellDtoList = new ArrayList<CellDTO>();
		
		for(var cellDomain : domainList) {
			cellDtoList.add(toDTO(cellDomain));
		}
		
		return cellDtoList;
	}

}
