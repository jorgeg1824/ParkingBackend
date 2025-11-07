package co.edu.uco.parking.data.dao.entity;

import java.util.UUID;

import co.edu.uco.parking.data.dao.CreateDAO;
import co.edu.uco.parking.data.dao.DeleteDAO;
import co.edu.uco.parking.data.dao.RetrieveDAO;
import co.edu.uco.parking.data.dao.UpdateDAO;
import co.edu.uco.parking.entity.ManagerZoneEntity;

public interface ManagerZoneDAO extends CreateDAO<ManagerZoneEntity>,
										RetrieveDAO<ManagerZoneEntity, UUID>,
										UpdateDAO<ManagerZoneEntity>,
										DeleteDAO<UUID> {
	
}

