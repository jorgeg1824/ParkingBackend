package co.edu.uco.parking.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class TicketEntity {

    private UUID id;
    private int ticketNumber;
    private LocalDateTime entryDate;
    private CellVehicleEntity cellVehicle;
    private TicketStatusEntity ticketStatus;

    public TicketEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setTicketNumber(0);
        setEntryDate(null);
        setCellVehicle(new CellVehicleEntity());
        setTicketStatus(new TicketStatusEntity());
    }

    public TicketEntity(final UUID id, final int ticketNumber, final LocalDateTime entryDate,
                        final CellVehicleEntity cellVehicle, final TicketStatusEntity ticketStatus) {
        setId(id);
        setTicketNumber(ticketNumber);
        setEntryDate(entryDate);
        setCellVehicle(cellVehicle);
        setTicketStatus(ticketStatus);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(final int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(final LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public CellVehicleEntity getCellVehicle() {
        return cellVehicle;
    }

    public void setCellVehicle(final CellVehicleEntity cellVehicle) {
        this.cellVehicle = ObjectHelper.getDefault(cellVehicle, new CellVehicleEntity());
    }

    public TicketStatusEntity getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(final TicketStatusEntity ticketStatus) {
        this.ticketStatus = ObjectHelper.getDefault(ticketStatus, new TicketStatusEntity());
    }
}
