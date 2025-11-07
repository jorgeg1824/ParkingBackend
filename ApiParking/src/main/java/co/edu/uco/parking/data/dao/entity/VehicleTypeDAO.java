package co.edu.uco.parking.data.dao.entity;

import java.util.UUID;

import co.edu.uco.parking.data.dao.CreateDAO;
import co.edu.uco.parking.data.dao.DeleteDAO;
import co.edu.uco.parking.data.dao.RetrieveDAO;
import co.edu.uco.parking.data.dao.UpdateDAO;
import co.edu.uco.parking.entity.VehicleTypeEntity;

public interface VehicleTypeDAO extends CreateDAO<VehicleTypeEntity>,
										RetrieveDAO<VehicleTypeEntity, UUID>,
										UpdateDAO<VehicleTypeEntity>,
										DeleteDAO<UUID> {
	
}

