package co.edu.uco.parking.business.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.DateHelper;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class ManagerZoneDomain extends Domain{
	
	private LocalDateTime administrationDate;
	private ManagerDomain manager;
	private ZoneDomain zone;
	
	public ManagerZoneDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setAdministrationDate(DateHelper.getDefault());
		setManager(new ManagerDomain());
		setZone(new ZoneDomain());
	}
	
	public ManagerZoneDomain(final UUID id, final LocalDateTime administrationDate, final ManagerDomain manager, final ZoneDomain zone) {
		super(id);
		setAdministrationDate(administrationDate);
		setManager(manager);
		setZone(zone);
	}

	public LocalDateTime getAdministrationDate() {
		return administrationDate;
	}
	public void setAdministrationDate(final LocalDateTime administrationDate) {
		this.administrationDate = DateHelper.getDefault(administrationDate);
	}
	public ManagerDomain getManager() {
		return manager;
	}
	public void setManager(final ManagerDomain manager) {
		this.manager = ObjectHelper.getDefault(manager, new ManagerDomain());
	}
	public ZoneDomain getZone() {
		return zone;
	}
	public void setZone(final ZoneDomain zone) {
		this.zone = ObjectHelper.getDefault(zone, new ZoneDomain());
	}

}
