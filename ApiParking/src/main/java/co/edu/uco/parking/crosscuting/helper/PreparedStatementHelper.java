package co.edu.uco.parking.crosscuting.helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public final class PreparedStatementHelper {
	
	private PreparedStatementHelper() {
	}
	
	public static void setParameters(final PreparedStatement ps, final List<Object> params) throws SQLException {
        for (int i = 0; i < params.size(); i++) {
            ps.setObject(i + 1, params.get(i));
        }
    }
	
	public static void setCellParametersForInsert(final PreparedStatement ps, final CellEntity entity) throws SQLException {
		ps.setObject(1, entity.getId());
		ps.setString(2, entity.getName);
		ps.setObject(3, entity.getCellType().getId());
		ps.setObject(4, entity.getZone().getId());
		ps.setBoolean(5, entity.isActive());
	}
	
	public static void setCellParametersForUpdate(final PreparedStatement ps, final CellEntity entity) throws SQLException {
		ps.setObject(1, entity.getId());
		ps.setString(2, entity.getName);
		ps.setObject(3, entity.getCellType().getId());
		ps.setObject(4, entity.getZone().getId());
		ps.setBoolean(5, entity.isActive());
	}

}
