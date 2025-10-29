package co.edu.uco.parking.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public final class TicketDTO {

    private UUID id;
    private int ticketNumber;
    private LocalDateTime entryDate;
    private CellVehicleDTO cellVehicle;
    private TicketStatusDTO ticketStatus;

    public TicketDTO() {
        super();
    }

    public TicketDTO(final UUID id, final int ticketNumber, final LocalDateTime entryDate,
                     final CellVehicleDTO cellVehicle, final TicketStatusDTO ticketStatus) {
        super();
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.entryDate = entryDate;
        this.cellVehicle = cellVehicle;
        this.ticketStatus = ticketStatus;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
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

    public CellVehicleDTO getCellVehicle() {
        return cellVehicle;
    }

    public void setCellVehicle(final CellVehicleDTO cellVehicle) {
        this.cellVehicle = cellVehicle;
    }

    public TicketStatusDTO getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(final TicketStatusDTO ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
