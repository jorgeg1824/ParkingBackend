package co.edu.uco.parking.business.assembler.entity.impl;

import co.edu.uco.parking.business.assembler.entity.EntityAssembler;
import co.edu.uco.parking.business.domain.ZoneDomain;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.entity.ZoneEntity;

public final class ZoneEntityAssembler implements EntityAssembler<ZoneEntity, ZoneDomain>{
	
	private static final EntityAssembler<ZoneEntity, ZoneDomain> instance =
			new ZoneEntityAssembler();
	
	private ZoneEntityAssembler() {
	}
	
	public static EntityAssembler<ZoneEntity, ZoneDomain> getZoneEntityAssembler(){
		return instance;
	}
	
	@Override
	public ZoneEntity toEntity(ZoneDomain domain) {
		var domainTmp = ObjectHelper.getDefault(domain, new ZoneDomain());
		return new ZoneEntity(domainTmp.getId(), domainTmp.getName(), domainTmp.getDescription(), domainTmp.isActive());
	}

	@Override
	public ZoneDomain toDomain(ZoneEntity entity) {
		var entityTmp = ObjectHelper.getDefault(entity, new ZoneEntity());
		return new ZoneDomain(entityTmp.getId(), entityTmp.getName(), entityTmp.getDescription(), entityTmp.isActive());
	}

}
