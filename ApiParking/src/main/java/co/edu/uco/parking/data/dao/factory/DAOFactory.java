package co.edu.uco.parking.data.dao.factory;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.helper.SqlConnectionHelper;
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
import co.edu.uco.parking.data.dao.factory.postgresql.PostgresqlDAOFactory;

public abstract class DAOFactory {
	
	protected Connection connection;
	protected static FactoryEnum factory = FactoryEnum.POSTGRESQL;
	
	public static DAOFactory getDAOFactory() {
		if (FactoryEnum.POSTGRESQL.equals(factory)) {
			return new PostgresqlDAOFactory();
		} else {
			var userMessage = MessagesEnum.USER_ERROR_DAOFACTORY_NO_VALID_FACTORY.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAOFACTORY_NO_VALID_FACTORY.getContent();
			throw ParkingException.create(userMessage, technicalMessage);
		}
	}
	
	public abstract ManagerDAO getManagerDAO();
	
	public abstract ZoneDAO getZoneDAO();
	
	public abstract ManagerZoneDAO getManagerZoneDAO();
	
	public abstract CellTypeDAO getCellTypeDAO();
	
	public abstract CellDAO getCellDAO();
	
	public abstract VehicleTypeDAO getVehicleTypeDAO();
	
	public abstract VehicleDAO getVehicleDAO();
	
	public abstract CellVehicleDAO getCellVehicleDAO();
	
	public abstract TicketStatusDAO getTicketStatusDAO();
	
	public abstract TicketDAO getTicketDAO();
	
	public abstract VehicleExitDAO getVehicleExitDAO();
	
	public final void initTransaction() {
		SqlConnectionHelper.ensureTransactionIsNotStarted(connection);
		
		try {
			connection.setAutoCommit(false);
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_INITIALIZING_TRANSACTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_INITIALIZING_TRANSACTION.getContent();
			throw ParkingException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_INITIALIZING_TRANSACTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_INITIALIZING_TRANSACTION.getContent();
			throw ParkingException.create(exception, userMessage, technicalMessage);
		}
	}
	
	public final void commitTransaction() {
		SqlConnectionHelper.ensureTransactionIsStarted(connection);
		
		try {
			connection.commit();
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_COMMITING_TRANSACTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_COMMITING_TRANSACTION.getContent();
			throw ParkingException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_COMMITING_TRANSACTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_COMMITING_TRANSACTION.getContent();
			throw ParkingException.create(exception, userMessage, technicalMessage);
		}
	}
	
	public final void rollbackTransaction() {
		SqlConnectionHelper.ensureTransactionIsStarted(connection);
		
		try {
			connection.rollback();
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_ROLLING_BACK_TRANSACTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_ROLLING_BACK_TRANSACTION.getContent();
			throw ParkingException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_ROLLING_BACK_TRANSACTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_ROLLING_BACK_TRANSACTION.getContent();
			throw ParkingException.create(exception, userMessage, technicalMessage);
		}
	}
	
	public final void closeConnection() {
		SqlConnectionHelper.ensureConnectionIsOpen(connection);
		
		try {
			connection.close();
		} catch (final SQLException exception) {
			var userMessage = MessagesEnum.USER_ERROR_CLOSING_CONNECTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_CLOSING_CONNECTION.getContent();
			throw ParkingException.create(exception, userMessage, technicalMessage);
		} catch (final Exception exception) {
			var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_CLOSING_CONNECTION.getContent();
			var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQLCONNECTION_UNEXPECTED_ERROR_CLOSING_CONNECTION.getContent();
			throw ParkingException.create(exception, userMessage, technicalMessage);
		}
	}

}
