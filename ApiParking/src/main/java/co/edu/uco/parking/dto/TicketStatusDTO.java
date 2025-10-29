package co.edu.uco.parking.dto;

import java.util.UUID;

public final class TicketStatusDTO {

    private UUID id;
    private String name;
    private String description;

    public TicketStatusDTO() {
        super();
    }

    public TicketStatusDTO(final UUID id, final String name, final String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
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
}
