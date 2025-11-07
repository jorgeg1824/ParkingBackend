package co.edu.uco.parking.data.dao.entity;

import java.util.UUID;

import co.edu.uco.parking.data.dao.CreateDAO;
import co.edu.uco.parking.data.dao.DeleteDAO;
import co.edu.uco.parking.data.dao.RetrieveDAO;
import co.edu.uco.parking.data.dao.UpdateDAO;
import co.edu.uco.parking.entity.VehicleEntity;

public interface VehicleDAO extends CreateDAO<VehicleEntity>,
									RetrieveDAO<VehicleEntity, UUID>,
									UpdateDAO<VehicleEntity>,
									DeleteDAO<UUID> {
	
}

