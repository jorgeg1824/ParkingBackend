package co.edu.uco.parking.dto;

import java.util.UUID;

public final class CellVehicleDTO {

    private UUID id;
    private int rate;
    private CellDTO cell;
    private VehicleDTO vehicle;

    public CellVehicleDTO() {
        this.id = UUID.randomUUID(); // o null, si prefieres asignarlo luego
        this.rate = 0;
        this.cell = new CellDTO();
        this.vehicle = new VehicleDTO();
    }

    public CellVehicleDTO(final UUID id, final int rate, final CellDTO cell, final VehicleDTO vehicle) {
        this.id = id;
        this.rate = rate;
        this.cell = cell;
        this.vehicle = vehicle;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(final int rate) {
        this.rate = rate;
    }

    public CellDTO getCell() {
        return cell;
    }

    public void setCell(final CellDTO cell) {
        this.cell = cell;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(final VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }
}
