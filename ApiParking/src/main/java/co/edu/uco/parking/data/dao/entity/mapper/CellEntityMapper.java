package co.edu.uco.parking.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.CellEntity;
import co.edu.uco.parking.entity.CellTypeEntity;
import co.edu.uco.parking.entity.ZoneEntity;

public final class CellEntityMapper {

    public CellEntityMapper() {
        super();
    }

    public static CellEntity map(final ResultSet rs) throws SQLException {

        var entity = new CellEntity();

        entity.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_celda")));
        entity.setName(rs.getString("nombre_celda"));
        entity.setActive(rs.getBoolean("es_activo"));

        var zone = new ZoneEntity();
        zone.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_zona")));
        entity.setZone(zone);

        var cellType = new CellTypeEntity();
        cellType.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_tipo_celda")));
        entity.setCellType(cellType);

        return entity;
    }
}
