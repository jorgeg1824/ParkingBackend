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
import co.edu.uco.parking.data.dao.entity.CellDAO;
import co.edu.uco.parking.data.dao.entity.SqlConnection;
import co.edu.uco.parking.data.dao.entity.mapper.CellEntityMapper;
import co.edu.uco.parking.data.dao.entity.postgresql.builder.CellSqlBuilder;
import co.edu.uco.parking.entity.CellEntity;

public final class CellPostgresqlDAO extends SqlConnection implements CellDAO {

    private final CellSqlBuilder sqlBuilder;

    public CellPostgresqlDAO(final Connection connection) {
        super(connection);
        this.sqlBuilder = new CellSqlBuilder();
    }

    @Override
    public void create(final CellEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildInsert();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setCellParametersForInsert(ps, entity);
            ps.executeUpdate();
        } catch (final SQLException e) {
        	
            if (e.getSQLState() != null && e.getSQLState().equals("23505")) {
            	var userMessage = MessagesEnum.USER_CELL_ERROR_DAO_CREATING_CELL_DUPLICATE.getContent();
            	var technicalMessage = MessagesEnum.TECHNICAL_ERROR_DAO_CREATING_CELL_DUPLICATE.getContent();
            	throw ParkingException.create(e, userMessage, technicalMessage);
            }

            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_CELL_ERROR_DAO_CREATING_CELL,
                MessagesEnum.TECHNICAL_ERROR_DAO_CREATING_CELL
            );
        } catch(final Exception exception) {
        	var userMessage = MessagesEnum.USER_CELL_UNEXPECTED_ERROR_DAO_CREATING_CELL.getContent();
        	var technicalMessage = MessagesEnum.TECHNICAL_UNEXPECTED_ERROR_DAO_CREATING_CELL.getContent();
        	throw ParkingException.create(exception, userMessage, technicalMessage);
        }

    }

    @Override
    public CellEntity findById(final UUID id) {
        final var sql = sqlBuilder.buildSelectById();
        CellEntity cell = null;

        try (var ps = getConnection().prepareStatement(sql)) {
            ps.setObject(1, id);
            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    cell = CellEntityMapper.map(rs);
                }
            }
        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_CELL_ERROR_DAO_FINDING_CELL_BY_ID,
                MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_CELL_BY_ID
            );
        }
        return cell;
    }

    @Override
    public List<CellEntity> findAll() {
        final var sql = sqlBuilder.buildSelectAll();
        final var cells = new ArrayList<CellEntity>();

        try (var ps = getConnection().prepareStatement(sql);
             var rs = ps.executeQuery()) {

            while (rs.next()) {
                cells.add(CellEntityMapper.map(rs));
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_CELL_ERROR_DAO_FINDING_ALL_CELLS,
                MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_ALL_CELLS
            );
        }
        return cells;
    }

    @Override
    public List<CellEntity> findByFilter(final CellEntity filter) {
        final var params = new ArrayList<Object>();
        final var sql = sqlBuilder.buildSelectByFilter(filter, params);
        final var cells = new ArrayList<CellEntity>();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setParameters(ps, params);

            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    cells.add(CellEntityMapper.map(rs));
                }
            }

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_CELL_ERROR_DAO_FINDING_CELL_BY_FILTER,
                MessagesEnum.TECHNICAL_ERROR_DAO_FINDING_CELL_BY_FILTER
            );
        }
        return cells;
    }

    @Override
    public void update(final CellEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = sqlBuilder.buildUpdate();

        try (var ps = getConnection().prepareStatement(sql)) {
            PreparedStatementHelper.setCellParametersForUpdate(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw ParkingException.createDaoException(
                e,
                MessagesEnum.USER_CELL_ERROR_DAO_UPDATING_CELL,
                MessagesEnum.TECHNICAL_ERROR_DAO_UPDATING_CELL
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
                MessagesEnum.USER_CELL_ERROR_DAO_DELETING_CELL,
                MessagesEnum.TECHNICAL_ERROR_DAO_DELETING_CELL
            );
        }
    }
}
