package co.edu.uco.parking.business.domain;

import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.BooleanHelper;
import co.edu.uco.parking.crosscuting.helper.NumericHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class VehicleTypeDomain extends Domain{
	
	private String name;
	private String description;
	private int rateApplied;
	private boolean isActive;
	
	public VehicleTypeDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setDescription(TextHelper.getDefault());
		setRateApplied(NumericHelper.getDefault());
		setActive(BooleanHelper.getDefault());
	}
	
	public VehicleTypeDomain(final UUID id, final String name, final String description, final int rateApplied, final boolean isActive) {
		super(id);
		setName(name);
		setDescription(description);
		setRateApplied(rateApplied);
		setActive(isActive);
	}

	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(final String description) {
		this.description = TextHelper.getDefault(description);
	}
	public int getRateApplied() {
		return rateApplied;
	}
	public void setRateApplied(final int rateApplied) {
		this.rateApplied = NumericHelper.getDefault(rateApplied);
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(final boolean isActive) {
		this.isActive = BooleanHelper.getDefault(isActive);
	}

}
