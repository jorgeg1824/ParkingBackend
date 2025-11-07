package co.edu.uco.parking.business.assembler.entity.impl;

import co.edu.uco.parking.business.assembler.entity.EntityAssembler;
import co.edu.uco.parking.business.domain.CellDomain;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.entity.CellEntity;

public final class CellEntityAssembler implements EntityAssembler<CellEntity, CellDomain> {
	
	private static final EntityAssembler<CellEntity, CellDomain> instance =
			new CellEntityAssembler();
	
	private CellEntityAssembler() {
	}
	
	public static EntityAssembler<CellEntity, CellDomain> getCellEntityAssembler(){
		return instance;
	}
	
	@Override
	public CellEntity toEntity(CellDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CellDomain());
		var cellTypeEntity = CellTypeEntityAssembler.getCellTypeEntityAssembler().toEntity(domainTmp.getCellType());
		var zoneEntity = ZoneEntityAssembler.getZoneEntityAssembler().toEntity(domainTmp.getZone());
		
		return new CellEntity(domainTmp.getId(), domainTmp.getName(), cellTypeEntity, zoneEntity, domainTmp.isActive());
	}

	@Override
	public CellDomain toDomain(CellEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new CellEntity());
		var cellTypeDomain = CellTypeEntityAssembler.getCellTypeEntityAssembler().toDomain(entityTmp.getCellType());
		var zoneDomain = ZoneEntityAssembler.getZoneEntityAssembler().toDomain(entityTmp.getZone());
		
		return new CellDomain(entityTmp.getId(), entityTmp.getName(), cellTypeDomain, zoneDomain,  entityTmp.isActive());
	}

}
