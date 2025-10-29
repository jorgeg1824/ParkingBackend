package co.edu.uco.parking.business.domain;

import java.util.UUID;

import co.edu.uco.parking.crosscuting.helper.NumericHelper;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;

public final class CellVehicleDomain extends Domain{
	
	private int rate;
	private CellDomain cell;
	private VehicleDomain vehicle;
	
	public CellVehicleDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setRate(NumericHelper.getDefault());
		setCell(new CellDomain());
		setVehicle(new VehicleDomain());
	}
			
	public CellVehicleDomain(final UUID id, final int rate, final CellDomain cell, final VehicleDomain vehicle) {
		super(id);
		setRate(rate);
		setCell(cell);
		setVehicle(vehicle);
	}

	public int getRate() {
		return rate;
	}
	public void setRate(final int rate) {
		this.rate = NumericHelper.getDefault(rate);
	}
	public CellDomain getCell() {
		return cell;
	}
	public void setCell(final CellDomain cell) {
		this.cell = ObjectHelper.getDefault(cell, new CellDomain());
	}
	public VehicleDomain getVehicle() {
		return vehicle;
	}
	public void setVehicle(final VehicleDomain vehicle) {
		this.vehicle = ObjectHelper.getDefault(vehicle, new VehicleDomain());
	}

}
