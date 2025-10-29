package co.edu.uco.parking.dto;

import java.util.UUID;

public class VehicleTypeDTO {

    private UUID id;
    private String name;
    private String description;
    private int rateApplied;
    private boolean isActive;

    public VehicleTypeDTO() {
        super();
    }

    public VehicleTypeDTO(UUID id, String name, String description, int rateApplied, boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rateApplied = rateApplied;
        this.isActive = isActive;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(int rateApplied) {
        this.rateApplied = rateApplied;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
