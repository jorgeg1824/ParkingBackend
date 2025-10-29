package co.edu.uco.parking.dto;

import java.util.UUID;

public final class CellTypeDTO {

    private UUID id;
    private String name;
    private String description;
    private boolean isActive;

    public CellTypeDTO() {
        this.id = null;
        this.name = "";
        this.description = "";
        this.isActive = false;
    }

    public CellTypeDTO(final UUID id, final String name, final String description, final boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isActive = isActive;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(final boolean isActive) {
        this.isActive = isActive;
    }
}
