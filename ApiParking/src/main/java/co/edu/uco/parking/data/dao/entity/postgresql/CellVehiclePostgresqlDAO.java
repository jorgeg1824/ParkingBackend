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
import co.edu.uco.parking.data.dao.entity.CellVehicleDAO;
import co.edu.uco.parking.data.dao.entity.SqlConnection;
import co.edu.uco.parking.data.dao.entity.mapper.CellVehicleEntityMapper;
import co.edu.uco.parking.data.dao.entity.postgresql.builder.CellVehicleSqlBuilder;
import co.edu.uco.parking.entity.CellVehicleEntity;

public final class CellVehiclePostgresqlDAO extends SqlConnection implements CellVehicleDAO {

    private final CellVehicleSqlBuilder sqlBuilder;

    public CellVehiclePostgresqlDAO(final Connection connection) {
        super(connection);
        this.sqlBuilder = new CellVehicleSqlBuilder();
        new CellVehicleEntityMapper();
    }

    @Override
    public void create(final CellVehicleEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildInsert();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setCellVehicleParametersForInsert(ps, entity);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_CELL_VEHICLE_ERROR_DAO_CREATING_CELL_VEHICLE,
                MessagesEnum.TECHNICAL_ERROR_DAO_CREATING_CELL_VEHICLE
            );
        }
    }

    @Override
    public List<CellVehicleEntity> findAll() {
        final var sql = sqlBuilder.buildSelectAll();
        final var cellVehicles = new ArrayList<CellVehicleEntity>();

        try (var ps = getConnection().prepareStatement(sql);
             var rs = ps.executeQuery()) {
            while (rs.next()) {
                cellVehicles.add(CellVehicleEntityMapper.map(rs));
            }
        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_CELL_VEHICLE_ERROR_DAO_FINDING_ALL_CELL_VEHICLES,
                MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_ALL_CELL_VEHICLES
            );
        }

        return cellVehicles;
    }

    @Override
    public List<CellVehicleEntity> findByFilter(final CellVehicleEntity filter) {
        final var params = new ArrayList<Object>();
        final var sql = sqlBuilder.buildSelectByFilter(filter, params);
        final var cellVehicles = new ArrayList<CellVehicleEntity>();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setParameters(ps, params);
            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    cellVehicles.add(CellVehicleEntityMapper.map(rs));
                }
            }
        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_CELL_VEHICLE_ERROR_DAO_FINDING_CELL_VEHICLE_BY_FILTER,
                MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_CELL_VEHICLE_BY_FILTER
            );
        }

        return cellVehicles;
    }

    @Override
    public CellVehicleEntity findById(final UUID id) {
        final var sql = sqlBuilder.buildSelectById();
        CellVehicleEntity cellVehicle = null;

        try (var ps = getConnection().prepareStatement(sql)) {
            ps.setObject(1, id);
            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    cellVehicle = CellVehicleEntityMapper.map(rs);
                }
            }
        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_CELL_VEHICLE_ERROR_DAO_FINDING_CELL_VEHICLE_BY_ID,
                MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_CELL_VEHICLE_BY_ID
            );
        }

        return cellVehicle;
    }

    @Override
    public void update(final CellVehicleEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildUpdate();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setCellVehicleParametersForUpdate(ps, entity);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_CELL_VEHICLE_ERROR_DAO_UPDATING_CELL_VEHICLE,
                MessagesEnum.TECHNICAL_ERROR_DAO_UPDATING_CELL_VEHICLE
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
                MessagesEnum.USER_CELL_VEHICLE_ERROR_DAO_DELETING_CELL_VEHICLE,
                MessagesEnum.TECHNICAL_ERROR_DAO_DELETING_CELL_VEHICLE
            );
        }
    }
}
