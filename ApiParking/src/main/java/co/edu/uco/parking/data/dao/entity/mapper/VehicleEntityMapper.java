package co.edu.uco.parking.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.VehicleEntity;
import co.edu.uco.parking.entity.VehicleTypeEntity;

public final class VehicleEntityMapper {

    public VehicleEntityMapper() {
    }

    public static VehicleEntity map(final ResultSet rs) throws SQLException {

        var vehicleType = new VehicleTypeEntity();
        vehicleType.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_tipo_vehiculo")));

        var vehicle = new VehicleEntity();
        vehicle.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_vehiculo")));
        vehicle.setLicensePlate(rs.getString("placa"));
        vehicle.setVehicleType(vehicleType);

        return vehicle;
    }
}
