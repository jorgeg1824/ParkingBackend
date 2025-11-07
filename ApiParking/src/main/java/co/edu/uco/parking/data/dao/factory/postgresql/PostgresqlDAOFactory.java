package co.edu.uco.parking.data.dao.factory.postgresql;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.entity.CellDAO;
import co.edu.uco.parking.data.dao.entity.CellTypeDAO;
import co.edu.uco.parking.data.dao.entity.CellVehicleDAO;
import co.edu.uco.parking.data.dao.entity.ManagerDAO;
import co.edu.uco.parking.data.dao.entity.ManagerZoneDAO;
import co.edu.uco.parking.data.dao.entity.TicketDAO;
import co.edu.uco.parking.data.dao.entity.TicketStatusDAO;
import co.edu.uco.parking.data.dao.entity.VehicleDAO;
import co.edu.uco.parking.data.dao.entity.VehicleExitDAO;
import co.edu.uco.parking.data.dao.entity.VehicleTypeDAO;
import co.edu.uco.parking.data.dao.entity.ZoneDAO;
import co.edu.uco.parking.data.dao.entity.postgresql.CellPostgresqlDAO;
import co.edu.uco.parking.data.dao.entity.postgresql.CellTypePostgresqlDAO;
import co.edu.uco.parking.data.dao.entity.postgresql.CellVehiclePostgresqlDAO;
import co.edu.uco.parking.data.dao.entity.postgresql.ManagerPostgresqlDAO;
import co.edu.uco.parking.data.dao.entity.postgresql.ManagerZonePostgresqlDAO;
import co.edu.uco.parking.data.dao.entity.postgresql.VehiclePostgresqlDAO;
import co.edu.uco.parking.data.dao.entity.postgresql.VehicleTypePostgresqlDAO;
import co.edu.uco.parking.data.dao.entity.postgresql.ZonePostgresqlDAO;
import co.edu.uco.parking.data.dao.factory.DAOFactory;

public final class PostgresqlDAOFactory extends DAOFactory{
	
	public PostgresqlDAOFactory() {
		openConnection();
	}
	
	protected void openConnection() {
	    try {
	        String url = "jdbc:postgresql://localhost:5432/ParKing"; 
	        String user = "postgres";
	        String password = "jorgealpidio1442"; 

	        Class.forName("org.postgresql.Driver");

	        this.connection = DriverManager.getConnection(url, user, password);

	    } catch (final SQLException exception) {
	        var userMessage = MessagesEnum.USER_ERROR_OPENING_CONNECTION.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_OPENING_CONNECTION.getContent();
	        throw ParkingException.create(exception, userMessage, technicalMessage);

	    } catch (final Exception exception) {
	        var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_OPENING_CONNECTION.getContent();
	        var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_OPENING_CONNECTION.getContent();
	        throw ParkingException.create(exception, userMessage, technicalMessage);
	    }
	}
	
	@Override
	public ManagerDAO getManagerDAO() {
		return new ManagerPostgresqlDAO(connection);
	}
	
	@Override
	public ZoneDAO getZoneDAO() {
		return new ZonePostgresqlDAO(connection);
	}
	
	@Override
	public ManagerZoneDAO getManagerZoneDAO() {
		return new ManagerZonePostgresqlDAO(connection);
	}
	
	@Override
	public CellTypeDAO getCellTypeDAO() {
		return new CellTypePostgresqlDAO(connection);
	}
	
	@Override
	public CellDAO getCellDAO() {
		return new CellPostgresqlDAO(connection);
	}
	
	@Override
	public VehicleTypeDAO getVehicleTypeDAO() {
		return new VehicleTypePostgresqlDAO(connection);
	}
	
	@Override
	public VehicleDAO getVehicleDAO() {
		return new VehiclePostgresqlDAO(connection);
	}
	
	@Override
	public CellVehicleDAO getCellVehicleDAO() {
		return new CellVehiclePostgresqlDAO(connection);
	}

	@Override
	public TicketStatusDAO getTicketStatusDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketDAO getTicketDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleExitDAO getVehicleExitDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
