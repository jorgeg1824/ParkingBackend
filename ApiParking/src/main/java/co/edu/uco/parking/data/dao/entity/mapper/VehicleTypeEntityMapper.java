package co.edu.uco.parking.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.VehicleTypeEntity;

public final class VehicleTypeEntityMapper {

    public VehicleTypeEntityMapper() {
    }

    public static VehicleTypeEntity map(final ResultSet rs) throws SQLException {

        var entity = new VehicleTypeEntity();

        entity.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_tipo_vehiculo")));
        entity.setName(rs.getString("nombre_tipo_vehiculo"));
        entity.setDescription(rs.getString("descripcion"));
        entity.setRateApplied(rs.getInt("tarifa_aplicada"));
        entity.setActive(rs.getBoolean("es_activo"));

        return entity;
    }
}
