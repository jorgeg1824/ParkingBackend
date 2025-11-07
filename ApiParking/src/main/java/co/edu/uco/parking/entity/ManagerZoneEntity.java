package co.edu.uco.parking.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class ManagerZoneEntity {

    private UUID id;
    private LocalDateTime administrationDate;
    private ManagerEntity manager;
    private ZoneEntity zone;

    public ManagerZoneEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setAdministrationDate(null);
        setManager(new ManagerEntity());
        setZone(new ZoneEntity());
    }

    public ManagerZoneEntity(final UUID id, final LocalDateTime administrationDate, final ManagerEntity manager, final ZoneEntity zone) {
        setId(id);
        setAdministrationDate(administrationDate);
        setManager(manager);
        setZone(zone);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public LocalDateTime getAdministrationDate() {
        return administrationDate;
    }

    public void setAdministrationDate(final LocalDateTime administrationDate) {
        this.administrationDate = administrationDate;
    }

    public ManagerEntity getManager() {
        return manager;
    }

    public void setManager(final ManagerEntity manager) {
        this.manager = ObjectHelper.getDefault(manager, new ManagerEntity());
    }

    public ZoneEntity getZone() {
        return zone;
    }

    public void setZone(final ZoneEntity zone) {
        this.zone = ObjectHelper.getDefault(zone, new ZoneEntity());
    }
}
