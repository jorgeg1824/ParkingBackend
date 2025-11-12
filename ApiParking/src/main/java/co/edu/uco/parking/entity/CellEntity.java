package co.edu.uco.parking.entity;

import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.BooleanHelper;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class CellEntity {

    private UUID id;
    private String name;
    private CellTypeEntity cellType;
    private ZoneEntity zone;
    private boolean active;

    public CellEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setCellType(new CellTypeEntity());
        setZone(new ZoneEntity());
        setActive(false);
    }

    public CellEntity(final UUID id, final String name, final CellTypeEntity cellType, final ZoneEntity zone, final boolean active) {
        setId(id);
        setName(name);
        setCellType(cellType);
        setZone(zone);
        setActive(active);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public CellTypeEntity getCellType() {
        return cellType;
    }

    public void setCellType(final CellTypeEntity cellType) {
        this.cellType = ObjectHelper.getDefault(cellType, new CellTypeEntity());
    }

    public ZoneEntity getZone() {
        return zone;
    }

    public void setZone(final ZoneEntity zone) {
        this.zone = ObjectHelper.getDefault(zone, new ZoneEntity());
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = BooleanHelper.getDefault(active);
    }

}
