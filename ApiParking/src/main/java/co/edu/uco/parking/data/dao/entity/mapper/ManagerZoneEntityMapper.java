package co.edu.uco.parking.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.ManagerEntity;
import co.edu.uco.parking.entity.ManagerZoneEntity;
import co.edu.uco.parking.entity.ZoneEntity;

public final class ManagerZoneEntityMapper {

    public ManagerZoneEntityMapper() {
    }

    public static ManagerZoneEntity map(final ResultSet rs) throws SQLException {
        
        var manager = new ManagerEntity();
        manager.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_administrador")));
        
        var zone = new ZoneEntity();
        zone.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_zona")));
        
        var managerZone = new ManagerZoneEntity();
        managerZone.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_admin_zona")));
        managerZone.setAdministrationDate(rs.getObject("fecha_administracion", LocalDateTime.class));
        managerZone.setManager(manager);
        managerZone.setZone(zone);

        return managerZone;
    }
}
