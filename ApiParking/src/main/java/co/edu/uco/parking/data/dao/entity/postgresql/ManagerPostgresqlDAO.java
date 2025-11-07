package co.edu.uco.parking.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.parking.crosscuting.exception.ParkingException;
import co.edu.uco.parking.data.dao.entity.postgresql.builder.ManagerSqlBuilder;

import co.edu.uco.parking.crosscuting.helper.PreparedStatementHelper;
import co.edu.uco.parking.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.parking.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.parking.data.dao.entity.ManagerDAO;
import co.edu.uco.parking.data.dao.entity.SqlConnection;
import co.edu.uco.parking.data.dao.entity.mapper.ManagerEntityMapper;
import co.edu.uco.parking.entity.ManagerEntity;

public final class ManagerPostgresqlDAO extends SqlConnection implements ManagerDAO {

    private final ManagerSqlBuilder sqlBuilder;

    public ManagerPostgresqlDAO(final Connection connection) {
        super(connection);
        this.sqlBuilder = new ManagerSqlBuilder();
        new ManagerEntityMapper(); 
    }

    @Override
    public void create(final ManagerEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildInsert();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setManagerParametersForInsert(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_MANAGER_ERROR_DAO_CREATING_MANAGER,
                    MessagesEnum.TECHNICAL_ERROR_DAO_CREATING_MANAGER
            );
        }
    }

    @Override
    public List<ManagerEntity> findAll() {
        final var sql = sqlBuilder.buildSelectAll();
        final var managers = new ArrayList<ManagerEntity>();

        try (var ps = getConnection().prepareStatement(sql);
             var rs = ps.executeQuery()) {

            while (rs.next()) {
                managers.add(ManagerEntityMapper.map(rs));
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_MANAGER_ERROR_DAO_FINDING_ALL_MANAGERS,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_ALL_MANAGERS
            );
        }

        return managers;
    }

    @Override
    public List<ManagerEntity> findByFilter(final ManagerEntity filter) {
        final var params = new ArrayList<Object>();
        final var sql = sqlBuilder.buildSelectByFilter(filter, params);

        final var managers = new ArrayList<ManagerEntity>();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setParameters(ps, params);

            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    managers.add(ManagerEntityMapper.map(rs));
                }
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_MANAGER_ERROR_DAO_FINDING_MANAGER_BY_FILTER,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_MANAGER_BY_FILTER
            );
        }

        return managers;
    }

    @Override
    public ManagerEntity findById(final UUID id) {
        final var sql = sqlBuilder.buildSelectById();
        ManagerEntity manager = null;

        try (var ps = getConnection().prepareStatement(sql)) {
            ps.setObject(1, id);

            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    manager = ManagerEntityMapper.map(rs);
                }
            }

        } catch (final SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_MANAGER_ERROR_DAO_FINDING_MANAGER_BY_ID,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_MANAGER_BY_ID
            );
        }

        return manager;
    }

    @Override
    public void update(final ManagerEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildUpdate();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setManagerParametersForUpdate(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_MANAGER_ERROR_DAO_UPDATING_MANAGER,
                    MessagesEnum.TECHNICAL_ERROR_DAO_UPDATING_MANAGER
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
                    MessagesEnum.USER_MANAGER_ERROR_DAO_DELETING_MANAGER,
                    MessagesEnum.TECHNICAL_ERROR_DAO_DELETING_MANAGER
            );
        }
    }
}
