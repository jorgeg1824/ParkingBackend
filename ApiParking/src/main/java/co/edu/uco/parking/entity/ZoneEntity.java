package co.edu.uco.parking.entity;

import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.BooleanHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class ZoneEntity {

    private UUID id;
    private String name;
    private String description;
    private boolean active;

    public ZoneEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setDescription(TextHelper.getDefault());
        setActive(false);
    }

    public ZoneEntity(final UUID id, final String name, final String description, final boolean active) {
        setId(id);
        setName(name);
        setDescription(description);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = TextHelper.getDefaultWithTrim(description);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = BooleanHelper.getDefault(active);
    }
}
