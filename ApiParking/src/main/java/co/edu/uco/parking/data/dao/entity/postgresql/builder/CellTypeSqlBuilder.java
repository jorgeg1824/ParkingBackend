package co.edu.uco.parking.data.dao.entity.postgresql.builder;

import java.util.List;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.CellTypeEntity;

public final class CellTypeSqlBuilder {
	
	public String buildInsert() {
		return """
			INSERT INTO public."TipoCelda" (
				"id_tipo_celda", "nombre_tipo_celda", "descripcion", "es_activo"
			)
			VALUES (?, ?, ?, ?)
		""";
	}
	
	public String buildUpdate() {
		return """
			UPDATE public."TipoCelda"
			   SET "nombre_tipo_celda" = ?, 
			       "descripcion" = ?, 
			       "es_activo" = ?
			 WHERE "id_tipo_celda" = ?
		""";
	}
	
	public String buildDelete() {
		return """
			DELETE FROM public."TipoCelda"
			 WHERE "id_tipo_celda" = ?
		""";
	}
	
	private String buildBaseSelect() {
		return """
			SELECT 
				tc."id_tipo_celda",
				tc."nombre_tipo_celda",
				tc."descripcion",
				tc."es_activo"
			  FROM public."TipoCelda" AS tc
		""";
	}
	
	public String buildSelectAll() {
		return buildBaseSelect();
	}
	
	public String buildSelectById() {
		return buildBaseSelect() + " WHERE tc.\"id_tipo_celda\" = ?";
	}
	
	public String buildSelectByFilter(final CellTypeEntity filter, final List<Object> params) {
	    var sql = new StringBuilder(buildBaseSelect());
	    sql.append(" WHERE 1 = 1 ");

	    if (ObjectHelper.isNull(filter)) {
	        return sql.toString();
	    }

	    // Filtrar por id_tipo_celda
	    if (!UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getId())) {
	        sql.append(" AND tc.\"id_tipo_celda\" = ? ");
	        params.add(filter.getId());
	    }

	    // Filtrar por nombre_tipo_celda (LIKE para búsqueda parcial)
	    if (!TextHelper.isEmpty(filter.getName())) {
	        sql.append(" AND LOWER(tc.\"nombre_tipo_celda\") LIKE LOWER(?) ");
	        params.add("%" + filter.getName() + "%");
	    }

	    // Filtrar por descripcion (LIKE)
	    if (!TextHelper.isEmpty(filter.getDescription())) {
	        sql.append(" AND LOWER(tc.\"descripcion\") LIKE LOWER(?) ");
	        params.add("%" + filter.getDescription() + "%");
	    }

	    // Filtrar por es_activo
	    if (!ObjectHelper.isNull(filter.isActive())) {
	        sql.append(" AND tc.\"es_activo\" = ? ");
	        params.add(filter.isActive());
	    }

	    return sql.toString();
	}

}
