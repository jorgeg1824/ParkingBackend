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
import co.edu.uco.parking.data.dao.entity.ManagerZoneDAO;
import co.edu.uco.parking.data.dao.entity.SqlConnection;
import co.edu.uco.parking.data.dao.entity.mapper.ManagerZoneEntityMapper;
import co.edu.uco.parking.data.dao.entity.postgresql.builder.ManagerZoneSqlBuilder;
import co.edu.uco.parking.entity.ManagerZoneEntity;

public final class ManagerZonePostgresqlDAO extends SqlConnection implements ManagerZoneDAO {

    private final ManagerZoneSqlBuilder sqlBuilder;

    public ManagerZonePostgresqlDAO(final Connection connection) {
        super(connection);
        this.sqlBuilder = new ManagerZoneSqlBuilder();
        new ManagerZoneEntityMapper();
    }

    @Override
    public void create(final ManagerZoneEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildInsert();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setManagerZoneParametersForInsert(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_MANAGER_ZONE_ERROR_DAO_CREATING_MANAGER_ZONE,
                    MessagesEnum.TECHNICAL_ERROR_DAO_CREATING_MANAGER_ZONE
            );
        }
    }

    @Override
    public List<ManagerZoneEntity> findAll() {
        final var sql = sqlBuilder.buildSelectAll();
        final var managerZones = new ArrayList<ManagerZoneEntity>();

        try (var ps = getConnection().prepareStatement(sql);
             var rs = ps.executeQuery()) {

            while (rs.next()) {
                managerZones.add(ManagerZoneEntityMapper.map(rs));
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_MANAGER_ZONE_ERROR_DAO_FINDING_ALL_MANAGER_ZONES,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_ALL_MANAGER_ZONES
            );
        }

        return managerZones;
    }

    @Override
    public List<ManagerZoneEntity> findByFilter(final ManagerZoneEntity filter) {
        final var params = new ArrayList<Object>();
        final var sql = sqlBuilder.buildSelectByFilter(filter, params);
        final var managerZones = new ArrayList<ManagerZoneEntity>();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setParameters(ps, params);

            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    managerZones.add(ManagerZoneEntityMapper.map(rs));
                }
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_MANAGER_ZONE_ERROR_DAO_FINDING_MANAGER_ZONE_BY_FILTER,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_MANAGER_ZONE_BY_FILTER
            );
        }

        return managerZones;
    }

    @Override
    public ManagerZoneEntity findById(final UUID id) {
        final var sql = sqlBuilder.buildSelectById();
        ManagerZoneEntity managerZone = null;

        try (var ps = getConnection().prepareStatement(sql)) {
            ps.setObject(1, id);

            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    managerZone = ManagerZoneEntityMapper.map(rs);
                }
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_MANAGER_ZONE_ERROR_DAO_FINDING_MANAGER_ZONE_BY_ID,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_MANAGER_ZONE_BY_ID
            );
        }

        return managerZone;
    }

    @Override
    public void update(final ManagerZoneEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildUpdate();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setManagerZoneParametersForUpdate(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_MANAGER_ZONE_ERROR_DAO_UPDATING_MANAGER_ZONE,
                    MessagesEnum.TECHNICAL_ERROR_DAO_UPDATING_MANAGER_ZONE
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
                    MessagesEnum.USER_MANAGER_ZONE_ERROR_DAO_DELETING_MANAGER_ZONE,
                    MessagesEnum.TECHNICAL_ERROR_DAO_DELETING_MANAGER_ZONE
            );
        }
    }
}
