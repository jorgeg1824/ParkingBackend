package co.edu.uco.parking.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public final class ManagerZoneDTO {

    private UUID id;
    private LocalDateTime administrationDate;
    private ManagerDTO manager;
    private ZoneDTO zone;

    public ManagerZoneDTO() {
        this.id = UUID.randomUUID(); // puedes dejarlo en null si prefieres asignarlo fuera
        this.administrationDate = null;
        this.manager = new ManagerDTO();
        this.zone = new ZoneDTO();
    }

    public ManagerZoneDTO(final UUID id, final LocalDateTime administrationDate, final ManagerDTO manager, final ZoneDTO zone) {
        this.id = id;
        this.administrationDate = administrationDate;
        this.manager = manager;
        this.zone = zone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public LocalDateTime getAdministrationDate() {
        return administrationDate;
    }

    public void setAdministrationDate(final LocalDateTime administrationDate) {
        this.administrationDate = administrationDate;
    }

    public ManagerDTO getManager() {
        return manager;
    }

    public void setManager(final ManagerDTO manager) {
        this.manager = manager;
    }

    public ZoneDTO getZone() {
        return zone;
    }

    public void setZone(final ZoneDTO zone) {
        this.zone = zone;
    }
}
