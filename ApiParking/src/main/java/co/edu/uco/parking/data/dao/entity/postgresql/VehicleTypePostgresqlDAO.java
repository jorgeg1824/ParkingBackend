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
import co.edu.uco.parking.data.dao.entity.VehicleTypeDAO;
import co.edu.uco.parking.data.dao.entity.SqlConnection;
import co.edu.uco.parking.data.dao.entity.mapper.VehicleTypeEntityMapper;
import co.edu.uco.parking.data.dao.entity.postgresql.builder.VehicleTypeSqlBuilder;
import co.edu.uco.parking.entity.VehicleTypeEntity;

public final class VehicleTypePostgresqlDAO extends SqlConnection implements VehicleTypeDAO {

    private final VehicleTypeSqlBuilder sqlBuilder;

    public VehicleTypePostgresqlDAO(final Connection connection) {
        super(connection);
        this.sqlBuilder = new VehicleTypeSqlBuilder();
        new VehicleTypeEntityMapper();
    }

    @Override
    public void create(final VehicleTypeEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildInsert();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setVehicleTypeParametersForInsert(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_VEHICLE_TYPE_ERROR_DAO_CREATING_VEHICLE_TYPE,
                MessagesEnum.TECHNICAL_ERROR_DAO_CREATING_VEHICLE_TYPE
            );
        }
    }

    @Override
    public List<VehicleTypeEntity> findAll() {
        final var sql = sqlBuilder.buildSelectAll();
        final var vehicleTypes = new ArrayList<VehicleTypeEntity>();

        try (var ps = getConnection().prepareStatement(sql);
             var rs = ps.executeQuery()) {

            while (rs.next()) {
                vehicleTypes.add(VehicleTypeEntityMapper.map(rs));
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_VEHICLE_TYPE_ERROR_DAO_FINDING_ALL_VEHICLE_TYPES,
                MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_ALL_VEHICLE_TYPES
            );
        }

        return vehicleTypes;
    }

    @Override
    public List<VehicleTypeEntity> findByFilter(final VehicleTypeEntity filter) {
        final var params = new ArrayList<Object>();
        final var sql = sqlBuilder.buildSelectByFilter(filter, params);
        final var vehicleTypes = new ArrayList<VehicleTypeEntity>();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setParameters(ps, params);

            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    vehicleTypes.add(VehicleTypeEntityMapper.map(rs));
                }
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_VEHICLE_TYPE_ERROR_DAO_FINDING_BY_FILTER,
                MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_BY_FILTER
            );
        }

        return vehicleTypes;
    }

    @Override
    public VehicleTypeEntity findById(final UUID id) {
        final var sql = sqlBuilder.buildSelectById();
        VehicleTypeEntity vehicleType = null;

        try (var ps = getConnection().prepareStatement(sql)) {
            ps.setObject(1, id);

            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    vehicleType = VehicleTypeEntityMapper.map(rs);
                }
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_VEHICLE_TYPE_ERROR_DAO_FINDING_BY_ID,
                MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_BY_ID
            );
        }

        return vehicleType;
    }

    @Override
    public void update(final VehicleTypeEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildUpdate();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setVehicleTypeParametersForUpdate(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_VEHICLE_TYPE_ERROR_DAO_UPDATING_VEHICLE_TYPE,
                MessagesEnum.TECHNICAL_ERROR_DAO_UPDATING_VEHICLE_TYPE
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
                MessagesEnum.USER_VEHICLE_TYPE_ERROR_DAO_DELETING_VEHICLE_TYPE,
                MessagesEnum.TECHNICAL_ERROR_DAO_DELETING_VEHICLE_TYPE
            );
        }
    }
}
