package co.edu.uco.parking.data.dao.entity;

import java.util.UUID;

import co.edu.uco.parking.data.dao.CreateDAO;
import co.edu.uco.parking.data.dao.RetrieveDAO;
import co.edu.uco.parking.data.dao.UpdateDAO;
import co.edu.uco.parking.entity.TicketEntity;

public interface TicketDAO extends CreateDAO<TicketEntity>,
								   RetrieveDAO<TicketEntity, UUID>,
								   UpdateDAO<TicketEntity> {
	
}

