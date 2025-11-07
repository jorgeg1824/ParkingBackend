package co.edu.uco.parking.data.dao.entity.postgresql.builder;

import java.util.List;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.CellVehicleEntity;

public final class CellVehicleSqlBuilder {
	
	public String buildInsert() {
		return """
			INSERT INTO public."CeldaVehiculo" (
				"id_celda_vehiculo", "tarifa", "id_celda", "id_vehiculo"
			)
			VALUES (?, ?, ?, ?)
		""";
	}
	
	public String buildUpdate() {
		return """
			UPDATE public."CeldaVehiculo"
			   SET "tarifa" = ?, 
			       "id_celda" = ?, 
			       "id_vehiculo" = ?
			 WHERE "id_celda_vehiculo" = ?
		""";
	}
	
	public String buildDelete() {
		return """
			DELETE FROM public."CeldaVehiculo"
			 WHERE "id_celda_vehiculo" = ?
		""";
	}
	
	private String buildBaseSelect() {
		return """
			SELECT 
				cv."id_celda_vehiculo",
				cv."tarifa",
				cv."id_celda",
				cv."id_vehiculo"
			  FROM public."CeldaVehiculo" AS cv
		""";
	}
	
	public String buildSelectAll() {
		return buildBaseSelect();
	}
	
	public String buildSelectById() {
		return buildBaseSelect() + " WHERE cv.\"id_celda_vehiculo\" = ?";
	}
	
	public String buildSelectByFilter(final CellVehicleEntity filter, final List<Object> params) {
	    var sql = new StringBuilder(buildBaseSelect());
	    sql.append(" WHERE 1 = 1 ");

	    if (ObjectHelper.isNull(filter)) {
	        return sql.toString();
	    }

	    // Filtrar por ID celdaVehiculo
	    if (!UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getId())) {
	        sql.append(" AND cv.\"id_celda_vehiculo\" = ? ");
	        params.add(filter.getId());
	    }

	    // Filtrar por tarifa (si viene explícita)
	    if (!ObjectHelper.isNull(filter.getRate())) {
	        sql.append(" AND cv.\"tarifa\" = ? ");
	        params.add(filter.getRate());
	    }

	    // Filtrar por celda
	    if (!ObjectHelper.isNull(filter.getCell()) &&
	        !UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getCell().getId())) {
	        
	        sql.append(" AND cv.\"id_celda\" = ? ");
	        params.add(filter.getCell().getId());
	    }

	    // Filtrar por vehículo
	    if (!ObjectHelper.isNull(filter.getVehicle()) &&
	        !UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getVehicle().getId())) {

	        sql.append(" AND cv.\"id_vehiculo\" = ? ");
	        params.add(filter.getVehicle().getId());
	    }

	    return sql.toString();
	}
	
}
