package co.edu.uco.parking.data.dao.entity.postgresql.builder;

import java.util.List;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.TicketStatusEntity;

public final class TicketStatusSqlBuilder {
	
	public String buildInsert() {
		return """
			INSERT INTO public."EstadoTicket"(
				"id_estado_ticket", "nombre_estado", "descripcion_estado"
			)
			VALUES (?, ?, ?)
		""";
	}
	
	public String buildUpdate() {
		return """
			UPDATE public."EstadoTicket"
			   SET "nombre_estado" = ?, 
			       "descripcion_estado" = ?
			 WHERE "id_estado_ticket" = ?
		""";
	}
	
	public String buildDelete() {
		return """
			DELETE FROM public."EstadoTicket"
			 WHERE "id_estado_ticket" = ?
		""";
	}
	
	private String buildBaseSelect() {
		return """
			SELECT 
				et."id_estado_ticket",
				et."nombre_estado",
				et."descripcion_estado"
			  FROM public."EstadoTicket" AS et
		""";
	}
	
	public String buildSelectAll() {
		return buildBaseSelect();
	}
	
	public String buildSelectById() {
		return buildBaseSelect() + " WHERE et.\"id_estado_ticket\" = ?";
	}
	
	public String buildSelectByFilter(final TicketStatusEntity filter, final List<Object> params) {
	    var sql = new StringBuilder(buildBaseSelect());
	    sql.append(" WHERE 1 = 1 ");

	    if (ObjectHelper.isNull(filter)) {
	        return sql.toString();
	    }

	    // Filtrar por ID
	    if (!UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getId())) {
	        sql.append(" AND et.\"id_estado_ticket\" = ? ");
	        params.add(filter.getId());
	    }

	    // Filtrar por nombre
	    if (!TextHelper.isEmpty(filter.getName())) {
	        sql.append(" AND LOWER(et.\"nombre_estado\") LIKE LOWER(?) ");
	        params.add("%" + filter.getName() + "%");
	    }

	    // Filtrar por descripcion
	    if (!TextHelper.isEmpty(filter.getDescription())) {
	        sql.append(" AND LOWER(et.\"descripcion_estado\") LIKE LOWER(?) ");
	        params.add("%" + filter.getDescription() + "%");
	    }

	    return sql.toString();
	}
	
}
