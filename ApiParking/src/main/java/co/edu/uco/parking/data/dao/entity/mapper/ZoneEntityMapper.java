package co.edu.uco.parking.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.ZoneEntity;

public final class ZoneEntityMapper {

    public ZoneEntityMapper() {
        super();
    }

    public static ZoneEntity map(final ResultSet rs) throws SQLException {
        var zone = new ZoneEntity();

        zone.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_zona")));
        zone.setName(rs.getString("nombre_zona"));
        zone.setDescription(rs.getString("descripcion"));
        zone.setActive(rs.getBoolean("es_activo"));

        return zone;
    }
}
