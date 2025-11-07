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
import co.edu.uco.parking.data.dao.entity.SqlConnection;
import co.edu.uco.parking.data.dao.entity.ZoneDAO;
import co.edu.uco.parking.data.dao.entity.mapper.ZoneEntityMapper;
import co.edu.uco.parking.data.dao.entity.postgresql.builder.ZoneSqlBuilder;
import co.edu.uco.parking.entity.ZoneEntity;

public final class ZonePostgresqlDAO extends SqlConnection implements ZoneDAO {

    private final ZoneSqlBuilder sqlBuilder;

    public ZonePostgresqlDAO(final Connection connection) {
        super(connection);
        this.sqlBuilder = new ZoneSqlBuilder();
        new ZoneEntityMapper();
    }

    @Override
    public void create(final ZoneEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildInsert();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setZoneParametersForInsert(ps, entity);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_ZONE_ERROR_DAO_CREATING_ZONE,
                    MessagesEnum.TECHNICAL_ERROR_DAO_CREATING_ZONE
            );
        }
    }

    @Override
    public List<ZoneEntity> findAll() {
        final var sql = sqlBuilder.buildSelectAll();
        final var zones = new ArrayList<ZoneEntity>();

        try (var ps = getConnection().prepareStatement(sql);
             var rs = ps.executeQuery()) {

            while (rs.next()) {
                zones.add(ZoneEntityMapper.map(rs));
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_ZONE_ERROR_DAO_FINDING_ALL_ZONES,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_ALL_ZONES
            );
        }

        return zones;
    }

    @Override
    public List<ZoneEntity> findByFilter(final ZoneEntity filter) {
        final var params = new ArrayList<Object>();
        final var sql = sqlBuilder.buildSelectByFilter(filter, params);

        final var zones = new ArrayList<ZoneEntity>();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setParameters(ps, params);

            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    zones.add(ZoneEntityMapper.map(rs));
                }
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_ZONE_ERROR_DAO_FINDING_ZONE_BY_FILTER,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_ZONE_BY_FILTER
            );
        }

        return zones;
    }

    @Override
    public ZoneEntity findById(final UUID id) {
        final var sql = sqlBuilder.buildSelectById();
        ZoneEntity zone = null;

        try (var ps = getConnection().prepareStatement(sql)) {
            ps.setObject(1, id);

            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    zone = ZoneEntityMapper.map(rs);
                }
            }

        } catch (final SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_ZONE_ERROR_DAO_FINDING_ZONE_BY_ID,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_ZONE_BY_ID
            );
        }

        return zone;
    }

    @Override
    public void update(final ZoneEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildUpdate();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setZoneParametersForUpdate(ps, entity);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_ZONE_ERROR_DAO_UPDATING_ZONE,
                    MessagesEnum.TECHNICAL_ERROR_DAO_UPDATING_ZONE
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
                    MessagesEnum.USER_ZONE_ERROR_DAO_DELETING_ZONE,
                    MessagesEnum.TECHNICAL_ERROR_DAO_DELETING_ZONE
            );
        }
    }
}
