package co.edu.uco.parking.business.domain;

import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class VehicleDomain extends Domain{
	
	private String licensePlate;
	private VehicleTypeDomain vehicleType;
	
	public VehicleDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setLicensePlate(TextHelper.getDefault());
		setVehicleType(new VehicleTypeDomain());
	}
	
	public VehicleDomain(final UUID id, final String licensePlate, final VehicleTypeDomain vehicleType) {
		super(id);
		setLicensePlate(licensePlate);
		setVehicleType(vehicleType);
	}

	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(final String licensePlate) {
		this.licensePlate = TextHelper.getDefaultWithTrim(licensePlate);
	}
	public VehicleTypeDomain getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(final VehicleTypeDomain vehicleType) {
		this.vehicleType = ObjectHelper.getDefault(vehicleType, new VehicleTypeDomain());
	}

}
