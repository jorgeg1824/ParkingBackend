package co.edu.uco.parking.data.dao.entity;

import java.util.UUID;

import co.edu.uco.parking.data.dao.CreateDAO;
import co.edu.uco.parking.data.dao.DeleteDAO;
import co.edu.uco.parking.data.dao.RetrieveDAO;
import co.edu.uco.parking.data.dao.UpdateDAO;
import co.edu.uco.parking.entity.ManagerEntity;

public interface ManagerDAO extends CreateDAO<ManagerEntity>,
									RetrieveDAO<ManagerEntity, UUID>,
									UpdateDAO<ManagerEntity>,
									DeleteDAO<UUID> {
		
}

