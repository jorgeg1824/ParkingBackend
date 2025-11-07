package co.edu.uco.parking.entity;

import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class VehicleEntity {

    private UUID id;
    private String licensePlate;
    private VehicleTypeEntity vehicleType;

    public VehicleEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setLicensePlate(TextHelper.getDefault());
        setVehicleType(new VehicleTypeEntity());
    }

    public VehicleEntity(final UUID id, final String licensePlate, final VehicleTypeEntity vehicleType) {
        setId(id);
        setLicensePlate(licensePlate);
        setVehicleType(vehicleType);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(final String licensePlate) {
        this.licensePlate = TextHelper.getDefaultWithTrim(licensePlate);
    }

    public VehicleTypeEntity getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(final VehicleTypeEntity vehicleType) {
        this.vehicleType = ObjectHelper.getDefault(vehicleType, new VehicleTypeEntity());
    }
}
