package co.edu.uco.parking.business.assembler.dto.impl;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.parking.business.assembler.dto.DTOAssembler;
import co.edu.uco.parking.business.domain.ZoneDomain;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.dto.ZoneDTO;

public final class ZoneDTOAssembler implements DTOAssembler<ZoneDTO, ZoneDomain> {
	
	private static final DTOAssembler<ZoneDTO, ZoneDomain> instance =
			new ZoneDTOAssembler();
	
	private ZoneDTOAssembler() {
	}
	
	public static DTOAssembler<ZoneDTO, ZoneDomain> getZoneDTOAssembler(){
		return instance;
	}
	
	@Override
	public ZoneDTO toDTO(final ZoneDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new ZoneDomain());
		return new ZoneDTO(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription(), domainTmp.isActive());
	}

	@Override
	public ZoneDomain toDomain(final ZoneDTO dto) {
		var dtoTmp = ObjectHelper.getDefault(dto, new ZoneDTO());
		return new ZoneDomain(dtoTmp.getId(), dtoTmp.getName(), dtoTmp.getDescription(), dtoTmp.isActive());
	}

	@Override
	public List<ZoneDTO> toDTO(List<ZoneDomain> domainList) {
		var zoneDtoList = new ArrayList<ZoneDTO>();
		
		for (var zoneDomain : domainList) {
			zoneDtoList.add(toDTO(zoneDomain));
		}
		
		return zoneDtoList;
	}

}
