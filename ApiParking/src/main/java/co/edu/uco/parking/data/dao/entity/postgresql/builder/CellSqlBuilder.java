package co.edu.uco.parking.data.dao.entity.postgresql.builder;

import java.util.List;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.CellEntity;

public final class CellSqlBuilder {
	
	public String buildInsert() {
		return """
			INSERT INTO "Celda" (
				"id_celda", "nombre_celda", "es_activo", "id_zona", "id_tipo_celda"
			)
			VALUES (?, ?, ?, ?, ?)
		""";
	}
	
	public String buildUpdate() {
		return """
			UPDATE public."Celda"
			   SET "nombre_celda" = ?, 
			       "es_activo" = ?, 
			       "id_zona" = ?, 
			       "id_tipo_celda" = ?
			 WHERE "id_celda" = ?
		""";
	}
	
	public String buildDelete() {
		return """
			DELETE FROM public."Celda"
			 WHERE "id_celda" = ?
		""";
	}
	
	private String buildBaseSelect() {
		return """
			SELECT 
				c."id_celda",
				c."nombre_celda",
				c."es_activo",
				c."id_zona",
				c."id_tipo_celda"
			  FROM public."Celda" AS c
		""";
	}
	
	public String buildSelectAll() {
		return buildBaseSelect();
	}
	
	public String buildSelectById() {
		return buildBaseSelect() + " WHERE c.\"id_celda\" = ?";
	}
	
	public String buildSelectByFilter(final CellEntity filter, final List<Object> params) {
	    var sql = new StringBuilder(buildBaseSelect());
	    sql.append(" WHERE 1 = 1 ");

	    if (ObjectHelper.isNull(filter)) {
	        return sql.toString();
	    }

	    // Filtrar por id_celda
	    if (!UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getId())) {
	        sql.append(" AND c.\"id_celda\" = ? ");
	        params.add(filter.getId());
	    }

	    // Filtrar por nombre_celda
	    if (!TextHelper.isEmpty(filter.getName())) {
	        sql.append(" AND LOWER(c.\"nombre_celda\") LIKE LOWER(?) ");
	        params.add("%" + filter.getName() + "%");
	    }

	    // Filtrar por es_activo
	    if (!ObjectHelper.isNull(filter.isActive())) {
	        sql.append(" AND c.\"es_activo\" = ? ");
	        params.add(filter.isActive());
	    }

	    // Filtrar por id_zona (si viene un ZoneEntity dentro del CellEntity)
	    if (!ObjectHelper.isNull(filter.getZone()) &&
	        !UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getZone().getId())) {
	        
	        sql.append(" AND c.\"id_zona\" = ? ");
	        params.add(filter.getZone().getId());
	    }

	    // Filtrar por id_tipo_celda (si viene un CellTypeEntity)
	    if (!ObjectHelper.isNull(filter.getCellType()) &&
	        !UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getCellType().getId())) {
	        
	        sql.append(" AND c.\"id_tipo_celda\" = ? ");
	        params.add(filter.getCellType().getId());
	    }

	    return sql.toString();
	}

	
}
