package co.edu.uco.parking.data.dao.entity;

import java.util.UUID;

import co.edu.uco.parking.data.dao.CreateDAO;
import co.edu.uco.parking.data.dao.DeleteDAO;
import co.edu.uco.parking.data.dao.RetrieveDAO;
import co.edu.uco.parking.data.dao.UpdateDAO;
import co.edu.uco.parking.entity.CellVehicleEntity;

public interface CellVehicleDAO extends CreateDAO<CellVehicleEntity>,
										RetrieveDAO<CellVehicleEntity, UUID>,
										UpdateDAO<CellVehicleEntity>,
										DeleteDAO<UUID> {
	
}

