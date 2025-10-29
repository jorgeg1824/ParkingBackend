package co.edu.uco.parking.business.domain;

import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.BooleanHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class CellTypeDomain extends Domain{
	
	private String name;
	private String description;
	private boolean isActive;
	
	public CellTypeDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setActive(BooleanHelper.getDefault());
	}
	
	public CellTypeDomain(final UUID id, final String name, final String description, final boolean isActive) {
		super(id);
		setName(name);
		setDescription(description);
		setActive(isActive);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = TextHelper.getDefault(description);
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = BooleanHelper.getDefault(isActive);
	}

}
