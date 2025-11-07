package co.edu.uco.parking.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;

import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.TicketEntity;
import co.edu.uco.parking.entity.VehicleExitEntity;

public final class VehicleExitEntityMapper {

    public VehicleExitEntityMapper() {
    }

    public static VehicleExitEntity map(final ResultSet rs) throws SQLException {

        var ticket = new TicketEntity();
        ticket.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_ticket")));

        var exit = new VehicleExitEntity();
        exit.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_salida_vehicul")));
        exit.setExitDate(rs.getObject("fecha_salida", LocalDateTime.class));
        exit.setStayDuration(rs.getObject("tiempo_estadia", Duration.class));
        exit.setTotalAmount(rs.getBigDecimal("valor_pagar"));
        exit.setTicket(ticket);

        return exit;
    }
}
