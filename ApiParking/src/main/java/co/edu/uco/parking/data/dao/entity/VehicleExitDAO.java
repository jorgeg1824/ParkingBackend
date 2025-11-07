package co.edu.uco.parking.data.dao.entity;

import java.util.UUID;

import co.edu.uco.parking.data.dao.CreateDAO;
import co.edu.uco.parking.data.dao.RetrieveDAO;
import co.edu.uco.parking.entity.VehicleExitEntity;

public interface VehicleExitDAO extends CreateDAO<VehicleExitEntity>,
										RetrieveDAO<VehicleExitEntity, UUID> {
	
}

