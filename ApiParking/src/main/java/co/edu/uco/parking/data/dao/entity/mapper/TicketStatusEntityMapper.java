package co.edu.uco.parking.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.TicketStatusEntity;

public final class TicketStatusEntityMapper {

    public TicketStatusEntityMapper() {
    }

    public static TicketStatusEntity map(final ResultSet rs) throws SQLException {

        var ticketStatus = new TicketStatusEntity();
        ticketStatus.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_estado")));
        ticketStatus.setName(rs.getString("nombre_estado"));
        ticketStatus.setDescription(rs.getString("descripcion_estado"));

        return ticketStatus;
    }
}
