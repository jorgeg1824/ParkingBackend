package co.edu.uco.parking.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.crosscuting.helper.PreparedStatementHelper;
import co.edu.uco.parking.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.entity.VehicleDAO;
import co.edu.uco.parking.data.dao.entity.SqlConnection;
import co.edu.uco.parking.data.dao.entity.mapper.VehicleEntityMapper;
import co.edu.uco.parking.data.dao.entity.postgresql.builder.VehicleSqlBuilder;
import co.edu.uco.parking.entity.VehicleEntity;

public final class VehiclePostgresqlDAO extends SqlConnection implements VehicleDAO {

    private final VehicleSqlBuilder sqlBuilder;

    public VehiclePostgresqlDAO(final Connection connection) {
        super(connection);
        this.sqlBuilder = new VehicleSqlBuilder();
        new VehicleEntityMapper();
    }

    @Override
    public void create(final VehicleEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildInsert();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setVehicleParametersForInsert(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_VEHICLE_ERROR_DAO_CREATING_VEHICLE,
                MessagesEnum.TECHNICAL_ERROR_DAO_CREATING_VEHICLE
            );
        }
    }

    @Override
    public List<VehicleEntity> findAll() {
        final var sql = sqlBuilder.buildSelectAll();
        final var vehicles = new ArrayList<VehicleEntity>();

        try (var ps = getConnection().prepareStatement(sql);
             var rs = ps.executeQuery()) {

            while (rs.next()) {
                vehicles.add(VehicleEntityMapper.map(rs));
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_VEHICLE_ERROR_DAO_FINDING_ALL_VEHICLES,
                MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_ALL_VEHICLES
            );
        }

        return vehicles;
    }

    @Override
    public List<VehicleEntity> findByFilter(final VehicleEntity filter) {
        final var params = new ArrayList<Object>();
        final var sql = sqlBuilder.buildSelectByFilter(filter, params);
        final var vehicles = new ArrayList<VehicleEntity>();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setParameters(ps, params);

            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    vehicles.add(VehicleEntityMapper.map(rs));
                }
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_VEHICLE_ERROR_DAO_FINDING_BY_FILTER,
                MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_BY_FILTER
            );
        }

        return vehicles;
    }

    @Override
    public VehicleEntity findById(final UUID id) {
        final var sql = sqlBuilder.buildSelectById();
        VehicleEntity vehicle = null;

        try (var ps = getConnection().prepareStatement(sql)) {
            ps.setObject(1, id);

            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    vehicle = VehicleEntityMapper.map(rs);
                }
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_VEHICLE_ERROR_DAO_FINDING_BY_ID,
                MessagesEnum.TECHNICAL_VEHICLE_ERROR_DAO_FINDING_BY_ID
            );
        }

        return vehicle;
    }

    @Override
    public void update(final VehicleEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildUpdate();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setVehicleParametersForUpdate(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_VEHICLE_ERROR_DAO_UPDATING_VEHICLE,
                MessagesEnum.TECHNICAL_VEHICLE_ERROR_DAO_UPDATING_VEHICLE
            );
        }
    }

    @Override
    public void delete(final UUID id) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildDelete();

        try (var ps = getConnection().prepareStatement(sql)) {
            ps.setObject(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_VEHICLE_ERROR_DAO_DELETING_VEHICLE,
                MessagesEnum.TECHNICAL_VEHICLE_ERROR_DAO_DELETING_VEHICLE
            );
        }
    }
}
