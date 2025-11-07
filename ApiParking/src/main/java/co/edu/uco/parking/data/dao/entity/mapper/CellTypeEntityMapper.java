package co.edu.uco.parking.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.CellTypeEntity;

public final class CellTypeEntityMapper {
    
    public CellTypeEntityMapper() {
        super();
    }

    public static CellTypeEntity map(final ResultSet rs) throws SQLException {
        var entity = new CellTypeEntity();

        entity.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_tipo_celda")));
        entity.setName(rs.getString("nombre_tipo_celda"));
        entity.setDescription(rs.getString("descripcion"));
        entity.setActive(rs.getBoolean("es_activo"));

        return entity;
    }
}
