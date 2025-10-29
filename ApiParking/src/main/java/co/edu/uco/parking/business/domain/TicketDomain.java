package co.edu.uco.parking.business.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.DateHelper;
import co.edu.uco.parking.crosscuting.helper.NumericHelper;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class TicketDomain extends Domain{
	
	private int ticketNumber;
	private LocalDateTime entryDate;
	private CellVehicleDomain cellVehicle;
	private TicketStatusDomain ticketStatus;
	
	public TicketDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setTicketNumber(NumericHelper.getDefault());
		setEntryDate(DateHelper.getDefault());
		setCellVehicle(new CellVehicleDomain());
		setTicketStatus(new TicketStatusDomain());
	}
	
	public TicketDomain(final UUID id, final int ticketNumber, final LocalDateTime entryDate, final CellVehicleDomain cellVehicle,
			final TicketStatusDomain ticketStatus) {
		super(id);
		setTicketNumber(ticketNumber);
		setEntryDate(entryDate);
		setCellVehicle(cellVehicle);
		setTicketStatus(ticketStatus);
	}

	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(final int ticketNumber) {
		this.ticketNumber = NumericHelper.getDefault(ticketNumber);
	}
	public LocalDateTime getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(final LocalDateTime entryDate) {
		this.entryDate = DateHelper.getDefault(entryDate);
	}
	public CellVehicleDomain getCellVehicle() {
		return cellVehicle;
	}
	public void setCellVehicle(final CellVehicleDomain cellVehicle) {
		this.cellVehicle = ObjectHelper.getDefault(cellVehicle, new CellVehicleDomain());
	}
	public TicketStatusDomain getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(final TicketStatusDomain ticketStatus) {
		this.ticketStatus = ObjectHelper.getDefault(ticketStatus, new TicketStatusDomain());
	}

}
