package co.edu.uco.parking.entity;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class VehicleExitEntity {

    private UUID id;
    private LocalDateTime exitDate;
    private Duration stayDuration;
    private BigDecimal totalAmount;
    private TicketEntity ticket;

    public VehicleExitEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setExitDate(null);
        setStayDuration(null);
        setTotalAmount(BigDecimal.ZERO);
        setTicket(new TicketEntity());
    }

    public VehicleExitEntity(final UUID id, final LocalDateTime exitDate, final Duration stayDuration,
                             final BigDecimal totalAmount, final TicketEntity ticket) {
        setId(id);
        setExitDate(exitDate);
        setStayDuration(stayDuration);
        setTotalAmount(totalAmount);
        setTicket(ticket);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(final BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public TicketEntity getTicket() {
        return ticket;
    }

    public void setTicket(final TicketEntity ticket) {
        this.ticket = ObjectHelper.getDefault(ticket, new TicketEntity());
    }
}
