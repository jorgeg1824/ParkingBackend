package co.edu.uco.parking.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.CellEntity;
import co.edu.uco.parking.entity.CellVehicleEntity;
import co.edu.uco.parking.entity.VehicleEntity;

public final class CellVehicleEntityMapper {

    public CellVehicleEntityMapper() {
    }

    public static CellVehicleEntity map(final ResultSet rs) throws SQLException {

        var cell = new CellEntity();
        cell.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_celda")));

        var vehicle = new VehicleEntity();
        vehicle.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_vehiculo")));

        var cellVehicle = new CellVehicleEntity();
        cellVehicle.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_celda_vehiculo")));
        cellVehicle.setRate(rs.getInt("tarifa"));
        cellVehicle.setCell(cell);
        cellVehicle.setVehicle(vehicle);

        return cellVehicle;
    }
}
