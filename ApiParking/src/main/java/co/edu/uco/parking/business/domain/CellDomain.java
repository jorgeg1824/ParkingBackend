package co.edu.uco.parking.business.domain;

import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.BooleanHelper;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class CellDomain extends Domain{
	
	private String name;
	private CellTypeDomain cellType;
	private ZoneDomain zone;
	private boolean isActive;
	
	public CellDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCellType(new CellTypeDomain());
		setZone(new ZoneDomain());
		setActive(BooleanHelper.getDefault());
	}
	
	public CellDomain(final UUID id, final String name, final CellTypeDomain cellType, final ZoneDomain zone, final boolean isActive) {
		super(id);
		setName(name);
		setCellType(cellType);
		setZone(zone);
		setActive(isActive);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	public CellTypeDomain getCellType() {
		return cellType;
	}
	
	public void setCellType(CellTypeDomain cellType) {
		this.cellType = ObjectHelper.getDefault(cellType, new CellTypeDomain());
	}
	
	public ZoneDomain getZone() {
		return zone;
	}
	
	public void setZone(ZoneDomain zone) {
		this.zone = ObjectHelper.getDefault(zone, new ZoneDomain());
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = BooleanHelper.getDefault(isActive);
	}
	
}
