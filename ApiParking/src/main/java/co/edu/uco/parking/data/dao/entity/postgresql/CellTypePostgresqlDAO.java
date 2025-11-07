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
import co.edu.uco.parking.data.dao.entity.CellTypeDAO;
import co.edu.uco.parking.data.dao.entity.SqlConnection;
import co.edu.uco.parking.data.dao.entity.mapper.CellTypeEntityMapper;
import co.edu.uco.parking.data.dao.entity.postgresql.builder.CellTypeSqlBuilder;
import co.edu.uco.parking.entity.CellTypeEntity;

public final class CellTypePostgresqlDAO extends SqlConnection implements CellTypeDAO {

    private final CellTypeSqlBuilder sqlBuilder;

    public CellTypePostgresqlDAO(final Connection connection) {
        super(connection);
        this.sqlBuilder = new CellTypeSqlBuilder();
        new CellTypeEntityMapper();
    }

    @Override
    public void create(final CellTypeEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildInsert();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setCellTypeParametersForInsert(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_CELL_TYPE_ERROR_DAO_CREATING_CELL_TYPE,
                    MessagesEnum.TECHNICAL_ERROR_DAO_CREATING_CELL_TYPE
            );
        }
    }

    @Override
    public List<CellTypeEntity> findAll() {
        final var sql = sqlBuilder.buildSelectAll();
        final var cellTypes = new ArrayList<CellTypeEntity>();

        try (var ps = getConnection().prepareStatement(sql);
             var rs = ps.executeQuery()) {

            while (rs.next()) {
                cellTypes.add(CellTypeEntityMapper.map(rs));
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_CELL_TYPE_ERROR_DAO_FINDING_ALL_CELL_TYPES,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_ALL_CELL_TYPES
            );
        }

        return cellTypes;
    }

    @Override
    public List<CellTypeEntity> findByFilter(final CellTypeEntity filter) {
        final var params = new ArrayList<Object>();
        final var sql = sqlBuilder.buildSelectByFilter(filter, params);
        final var cellTypes = new ArrayList<CellTypeEntity>();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setParameters(ps, params);

            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    cellTypes.add(CellTypeEntityMapper.map(rs));
                }
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_CELL_TYPE_ERROR_DAO_FINDING_CELL_TYPE_BY_FILTER,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_CELL_TYPE_BY_FILTER
            );
        }

        return cellTypes;
    }

    @Override
    public CellTypeEntity findById(final UUID id) {
        final var sql = sqlBuilder.buildSelectById();
        CellTypeEntity cellType = null;

        try (var ps = getConnection().prepareStatement(sql)) {
            ps.setObject(1, id);

            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    cellType = CellTypeEntityMapper.map(rs);
                }
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_CELL_TYPE_ERROR_DAO_FINDING_CELL_TYPE_BY_ID,
                    MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_CELL_TYPE_BY_ID
            );
        }

        return cellType;
    }

    @Override
    public void update(final CellTypeEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildUpdate();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setCellTypeParametersForUpdate(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                    e,
                    MessagesEnum.USER_CELL_TYPE_ERROR_DAO_UPDATING_CELL_TYPE,
                    MessagesEnum.TECHNICAL_ERROR_DAO_UPDATING_CELL_TYPE
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
                    MessagesEnum.USER_CELL_TYPE_ERROR_DAO_DELETING_CELL_TYPE,
                    MessagesEnum.TECHNICAL_ERROR_DAO_DELETING_CELL_TYPE
            );
        }
    }
}
