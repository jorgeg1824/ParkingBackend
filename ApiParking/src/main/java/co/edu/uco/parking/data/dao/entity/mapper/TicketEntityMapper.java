package co.edu.uco.parking.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.CellVehicleEntity;
import co.edu.uco.parking.entity.TicketEntity;
import co.edu.uco.parking.entity.TicketStatusEntity;

public final class TicketEntityMapper {

    public TicketEntityMapper() {
    }

    public static TicketEntity map(final ResultSet rs) throws SQLException {

        var cellVehicle = new CellVehicleEntity();
        cellVehicle.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_celda_vehiculo")));

        var status = new TicketStatusEntity();
        status.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_estado_ticket")));

        var ticket = new TicketEntity();
        ticket.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_ticket")));
        ticket.setTicketNumber(rs.getInt("numero_ticket"));
        ticket.setEntryDate(rs.getObject("fecha_entrada", LocalDateTime.class));
        ticket.setCellVehicle(cellVehicle);
        ticket.setTicketStatus(status);

        return ticket;
    }
}
