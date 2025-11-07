package co.edu.uco.parking.crosscuting.helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import co.edu.uco.parking.entity.CellEntity;
import co.edu.uco.parking.entity.CellTypeEntity;
import co.edu.uco.parking.entity.CellVehicleEntity;
import co.edu.uco.parking.entity.ManagerEntity;
import co.edu.uco.parking.entity.ManagerZoneEntity;
import co.edu.uco.parking.entity.TicketEntity;
import co.edu.uco.parking.entity.TicketStatusEntity;
import co.edu.uco.parking.entity.VehicleEntity;
import co.edu.uco.parking.entity.VehicleExitEntity;
import co.edu.uco.parking.entity.VehicleTypeEntity;
import co.edu.uco.parking.entity.ZoneEntity;

public final class PreparedStatementHelper {
	
	private PreparedStatementHelper() {
	}
	
	public static void setParameters(final PreparedStatement ps, final List<Object> params) throws SQLException {
        for (int i = 0; i < params.size(); i++) {
            ps.setObject(i + 1, params.get(i));
        }
    }
	
	public static void setManagerParametersForInsert(final PreparedStatement ps, final ManagerEntity entity) throws SQLException {
		ps.setObject(1, entity.getId());
		ps.setString(2, entity.getDocumentNumber());
		ps.setString(3, entity.getName());
		ps.setString(4, entity.getFirstSurname());
		ps.setString(5, entity.getSecondSurname());
		ps.setString(6, entity.getEmail());
		ps.setString(7, entity.getPhoneNumber());
		ps.setBoolean(8, entity.isEmailConfirmed());
		ps.setBoolean(9, entity.isPhoneConfirmed());
		ps.setBoolean(10, entity.isActive());
	}

	public static void setManagerParametersForUpdate(final PreparedStatement ps, final ManagerEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setString(2, entity.getDocumentNumber());
	    ps.setString(3, entity.getName());
	    ps.setString(4, entity.getFirstSurname());
	    ps.setString(5, entity.getSecondSurname());
	    ps.setString(6, entity.getEmail());
	    ps.setString(7, entity.getPhoneNumber());
	    ps.setBoolean(8, entity.isEmailConfirmed());
	    ps.setBoolean(9, entity.isPhoneConfirmed());
	    ps.setBoolean(10, entity.isActive());
	}
	
	public static void setZoneParametersForInsert(final PreparedStatement ps, final ZoneEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setString(2, entity.getName());
	    ps.setString(3, entity.getDescription());
	    ps.setBoolean(4, entity.isActive());
	}

	public static void setZoneParametersForUpdate(final PreparedStatement ps, final ZoneEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setString(2, entity.getName());
	    ps.setString(3, entity.getDescription());
	    ps.setBoolean(4, entity.isActive());
	}
	
	public static void setManagerZoneParametersForInsert(final PreparedStatement ps, final ManagerZoneEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setObject(2, entity.getAdministrationDate());
	    ps.setObject(3, entity.getManager().getId());
	    ps.setObject(4, entity.getZone().getId());
	}

	public static void setManagerZoneParametersForUpdate(final PreparedStatement ps, final ManagerZoneEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setObject(2, entity.getAdministrationDate());
	    ps.setObject(3, entity.getManager().getId());
	    ps.setObject(4, entity.getZone().getId());
	}

	public static void setCellTypeParametersForInsert(final PreparedStatement ps, final CellTypeEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setString(2, entity.getName());
	    ps.setString(3, entity.getDescription());
	    ps.setBoolean(4, entity.isActive());
	}

	public static void setCellTypeParametersForUpdate(final PreparedStatement ps, final CellTypeEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setString(2, entity.getName());
	    ps.setString(3, entity.getDescription());
	    ps.setBoolean(4, entity.isActive());
	}

	public static void setCellParametersForInsert(final PreparedStatement ps, final CellEntity entity) throws SQLException {
		ps.setObject(1, entity.getId());
		ps.setString(2, entity.getName());
		ps.setBoolean(3, entity.isActive());
		ps.setObject(4, entity.getZone().getId());
		ps.setObject(5, entity.getCellType().getId());
	}
	
	public static void setCellParametersForUpdate(final PreparedStatement ps, final CellEntity entity) throws SQLException {
		ps.setObject(1, entity.getId());
		ps.setString(2, entity.getName());
		ps.setObject(3, entity.getCellType().getId());
		ps.setObject(4, entity.getZone().getId());
		ps.setBoolean(5, entity.isActive());
	}
	
	public static void setVehicleTypeParametersForInsert(final PreparedStatement ps, final VehicleTypeEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setString(2, entity.getName());
	    ps.setString(3, entity.getDescription());
	    ps.setInt(4, entity.getRateApplied());
	    ps.setBoolean(5, entity.isActive());
	}

	public static void setVehicleTypeParametersForUpdate(final PreparedStatement ps, final VehicleTypeEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setString(2, entity.getName());
	    ps.setString(3, entity.getDescription());
	    ps.setInt(4, entity.getRateApplied());
	    ps.setBoolean(5, entity.isActive());
	}

	public static void setVehicleParametersForInsert(final PreparedStatement ps, final VehicleEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setString(2, entity.getLicensePlate());
	    ps.setObject(3, entity.getVehicleType().getId());
	}

	public static void setVehicleParametersForUpdate(final PreparedStatement ps, final VehicleEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setString(2, entity.getLicensePlate());
	    ps.setObject(3, entity.getVehicleType().getId());
	}

	public static void setCellVehicleParametersForInsert(final PreparedStatement ps, final CellVehicleEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setInt(2, entity.getRate());
	    ps.setObject(3, entity.getCell().getId());
	    ps.setObject(4, entity.getVehicle().getId());
	}

	public static void setCellVehicleParametersForUpdate(final PreparedStatement ps, final CellVehicleEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setInt(2, entity.getRate());
	    ps.setObject(3, entity.getCell().getId());
	    ps.setObject(4, entity.getVehicle().getId());
	}

	public static void setTicketStatusParametersForInsert(final PreparedStatement ps, final TicketStatusEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setString(2, entity.getName());
	    ps.setString(3, entity.getDescription());
	}

	public static void setTicketStatusParametersForUpdate(final PreparedStatement ps, final TicketStatusEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setString(2, entity.getName());
	    ps.setString(3, entity.getDescription());
	}

	public static void setTicketParametersForInsert(final PreparedStatement ps, final TicketEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setInt(2, entity.getTicketNumber());
	    ps.setObject(3, entity.getEntryDate());
	    ps.setObject(4, entity.getCellVehicle().getId());
	    ps.setObject(5, entity.getTicketStatus().getId());
	}

	public static void setTicketParametersForUpdate(final PreparedStatement ps, final TicketEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setInt(2, entity.getTicketNumber());
	    ps.setObject(3, entity.getEntryDate());
	    ps.setObject(4, entity.getCellVehicle().getId());
	    ps.setObject(5, entity.getTicketStatus().getId());
	}

	public static void setVehicleExitParametersForInsert(final PreparedStatement ps, final VehicleExitEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setObject(2, entity.getExitDate());
	    ps.setLong(3, entity.getStayDuration().getSeconds());  
	    ps.setBigDecimal(4, entity.getTotalAmount());
	    ps.setObject(5, entity.getTicket().getId());
	}

	public static void setVehicleExitParametersForUpdate(final PreparedStatement ps, final VehicleExitEntity entity) throws SQLException {
	    ps.setObject(1, entity.getId());
	    ps.setObject(2, entity.getExitDate());
	    ps.setLong(3, entity.getStayDuration().getSeconds());
	    ps.setBigDecimal(4, entity.getTotalAmount());
	    ps.setObject(5, entity.getTicket().getId());
	}

}
