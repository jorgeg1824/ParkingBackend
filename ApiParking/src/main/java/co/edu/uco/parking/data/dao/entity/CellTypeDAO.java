package co.edu.uco.parking.data.dao.entity;

import java.util.UUID;

import co.edu.uco.parking.data.dao.CreateDAO;
import co.edu.uco.parking.data.dao.DeleteDAO;
import co.edu.uco.parking.data.dao.RetrieveDAO;
import co.edu.uco.parking.data.dao.UpdateDAO;
import co.edu.uco.parking.entity.CellTypeEntity;

public interface CellTypeDAO extends CreateDAO<CellTypeEntity>,
									 RetrieveDAO<CellTypeEntity, UUID>,
									 UpdateDAO<CellTypeEntity>,
									 DeleteDAO<UUID> {
	
}

