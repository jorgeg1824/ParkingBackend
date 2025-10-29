package co.edu.uco.parking.dto;

import java.util.UUID;

public final class VehicleDTO {

    private UUID id;
    private String licensePlate;
    private VehicleTypeDTO vehicleType;

    public VehicleDTO() {
        super();
        this.id = null;
        this.licensePlate = "";
        this.vehicleType = new VehicleTypeDTO();
    }

    public VehicleDTO(final UUID id, final String licensePlate, final VehicleTypeDTO vehicleType) {
        super();
        this.id = id;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(final String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleTypeDTO getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(final VehicleTypeDTO vehicleType) {
        this.vehicleType = vehicleType;
    }
}
