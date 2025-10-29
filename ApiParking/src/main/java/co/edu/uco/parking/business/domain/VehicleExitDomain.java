package co.edu.uco.parking.business.domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.DateHelper;
import co.edu.uco.parking.crosscuting.helper.DurationHelper;
import co.edu.uco.parking.crosscuting.helper.NumericHelper;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class VehicleExitDomain extends Domain{
	
	private LocalDateTime exitDate;
	private Duration stayDuration;
	private int totalAmount;
	private TicketDomain ticket;
	
	public VehicleExitDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setExitDate(DateHelper.getDefault());
		setStayDuration(DurationHelper.getDefault());
		setTotalAmount(NumericHelper.getDefault());
		setTicket(new TicketDomain());
	}
	
	public VehicleExitDomain(final UUID id, final LocalDateTime exitDate, final Duration stayDuration, final int totalAmount,
			final TicketDomain ticket) {
		super(id);
		setExitDate(exitDate);
		setStayDuration(stayDuration);
		setTotalAmount(totalAmount);
		setTicket(ticket);
	}

	public LocalDateTime getExitDate() {
		return exitDate;
	}
	public void setExitDate(final LocalDateTime exitDate) {
		this.exitDate = DateHelper.getDefault(exitDate);
	}
	public Duration getStayDuration() {
		return stayDuration;
	}
	public void setStayDuration(final Duration stayDuration) {
		this.stayDuration = DurationHelper.getDefault(stayDuration);
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(final int totalAmount) {
		this.totalAmount = NumericHelper.getDefault(totalAmount);
	}
	public TicketDomain getTicket() {
		return ticket;
	}
	public void setTicket(TicketDomain ticket) {
		this.ticket = ObjectHelper.getDefault(ticket, new TicketDomain());
	}

}
