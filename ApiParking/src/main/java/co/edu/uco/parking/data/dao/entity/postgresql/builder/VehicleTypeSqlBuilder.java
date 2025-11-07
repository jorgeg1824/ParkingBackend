package co.edu.uco.parking.data.dao.entity.postgresql.builder;

import java.util.List;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.VehicleTypeEntity;

public final class VehicleTypeSqlBuilder {
	
	public String buildInsert() {
		return """
			INSERT INTO public."TipoVehiculo" (
				"id_tipo_vehiculo", "nombre_tipo_vehiculo", "descripcion", "tarifa_aplicada", "es_activo"
			)
			VALUES (?, ?, ?, ?, ?)
		""";
	}
	
	public String buildUpdate() {
		return """
			UPDATE public."TipoVehiculo"
			   SET "nombre_tipo_vehiculo" = ?, 
			       "descripcion" = ?, 
			       "tarifa_aplicada" = ?, 
			       "es_activo" = ?
			 WHERE "id_tipo_vehiculo" = ?
		""";
	}
	
	public String buildDelete() {
		return """
			DELETE FROM public."TipoVehiculo"
			 WHERE "id_tipo_vehiculo" = ?
		""";
	}
	
	private String buildBaseSelect() {
		return """
			SELECT 
				tv."id_tipo_vehiculo",
				tv."nombre_tipo_vehiculo",
				tv."descripcion",
				tv."tarifa_aplicada",
				tv."es_activo"
			  FROM public."TipoVehiculo" AS tv
		""";
	}
	
	public String buildSelectAll() {
		return buildBaseSelect();
	}
	
	public String buildSelectById() {
		return buildBaseSelect() + " WHERE tv.\"id_tipo_vehiculo\" = ?";
	}
	
	public String buildSelectByFilter(final VehicleTypeEntity filter, final List<Object> params) {
	    var sql = new StringBuilder(buildBaseSelect());
	    sql.append(" WHERE 1 = 1 ");

	    if (ObjectHelper.isNull(filter)) {
	        return sql.toString();
	    }

	    // Filtrar por ID
	    if (!UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getId())) {
	        sql.append(" AND tv.\"id_tipo_vehiculo\" = ? ");
	        params.add(filter.getId());
	    }

	    // Filtrar por nombre
	    if (!TextHelper.isEmpty(filter.getName())) {
	        sql.append(" AND LOWER(tv.\"nombre_tipo_vehiculo\") LIKE LOWER(?) ");
	        params.add("%" + filter.getName() + "%");
	    }

	    // Filtrar por descripcion
	    if (!TextHelper.isEmpty(filter.getDescription())) {
	        sql.append(" AND LOWER(tv.\"descripcion\") LIKE LOWER(?) ");
	        params.add("%" + filter.getDescription() + "%");
	    }

	    // Filtrar por tarifa_aplicada
	    if (!ObjectHelper.isNull(filter.getRateApplied())) {
	        sql.append(" AND tv.\"tarifa_aplicada\" = ? ");
	        params.add(filter.getRateApplied());
	    }

	    // Filtrar por es_activo
	    if (!ObjectHelper.isNull(filter.isActive())) {
	        sql.append(" AND tv.\"es_activo\" = ? ");
	        params.add(filter.isActive());
	    }

	    return sql.toString();
	}
	
}
