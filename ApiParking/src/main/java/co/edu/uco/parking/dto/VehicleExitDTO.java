package co.edu.uco.parking.dto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public final class VehicleExitDTO {

    private UUID id;
    private LocalDateTime exitDate;
    private Duration stayDuration;
    private int totalAmount;
    private TicketDTO ticket;

    public VehicleExitDTO() {
        super();
        this.id = null;
        this.exitDate = null;
        this.stayDuration = null;
        this.totalAmount = 0;
        this.ticket = new TicketDTO();
    }

    public VehicleExitDTO(final UUID id, final LocalDateTime exitDate, final Duration stayDuration,
                          final int totalAmount, final TicketDTO ticket) {
        super();
        this.id = id;
        this.exitDate = exitDate;
        this.stayDuration = stayDuration;
        this.totalAmount = totalAmount;
        this.ticket = ticket;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(final LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public Duration getStayDuration() {
        return stayDuration;
    }

    public void setStayDuration(final Duration stayDuration) {
        this.stayDuration = stayDuration;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(final int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public TicketDTO getTicket() {
        return ticket;
    }

    public void setTicket(final TicketDTO ticket) {
        this.ticket = ticket;
    }
}
