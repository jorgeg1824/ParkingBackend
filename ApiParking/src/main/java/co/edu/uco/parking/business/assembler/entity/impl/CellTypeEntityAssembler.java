package co.edu.uco.parking.business.assembler.entity.impl;

import co.edu.uco.parking.business.assembler.entity.EntityAssembler;
import co.edu.uco.parking.business.domain.CellTypeDomain;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.entity.CellTypeEntity;

public final class CellTypeEntityAssembler implements EntityAssembler<CellTypeEntity, CellTypeDomain> {
	
	private static final EntityAssembler<CellTypeEntity, CellTypeDomain> instance =
			new CellTypeEntityAssembler();
	
	private CellTypeEntityAssembler() {
	}
	
	public static EntityAssembler<CellTypeEntity, CellTypeDomain> getCellTypeEntityAssembler(){
		return instance;
	}
	
	@Override
	public CellTypeEntity toEntity(final CellTypeDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new CellTypeDomain());
		return new CellTypeEntity(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription(), domainTmp.isActive());
	}

	@Override
	public CellTypeDomain toDomain(CellTypeEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new CellTypeEntity());
		return new CellTypeDomain(entityTmp.getId(), entityTmp.getName(), entityTmp.getDescription(), entityTmp.isActive());
	}

}
