package co.edu.uco.parking.data.dao.entity.postgresql.builder;

import java.util.List;

import co.edu.uco.parking.crosscuting.helper.NumericHelper;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.TicketEntity;

public final class TicketSqlBuilder {
	
	public String buildInsert() {
		return """
			INSERT INTO public."Ticket"(
				"id_ticket", "numero_ticket", "fecha_entrada", "id_celda_vehiculo", "id_estado_ticket"
			)
			VALUES (?, ?, ?, ?, ?)
		""";
	}
	
	public String buildUpdate() {
		return """
			UPDATE public."Ticket"
			   SET "numero_ticket" = ?, 
			       "fecha_entrada" = ?, 
			       "id_celda_vehiculo" = ?, 
			       "id_estado_ticket" = ?
			 WHERE "id_ticket" = ?
		""";
	}
	
	public String buildDelete() {
		return """
			DELETE FROM public."Ticket"
			 WHERE "id_ticket" = ?
		""";
	}
	
	private String buildBaseSelect() {
		return """
			SELECT 
				t."id_ticket",
				t."numero_ticket",
				t."fecha_entrada",
				t."id_celda_vehiculo",
				t."id_estado_ticket"
			  FROM public."Ticket" AS t
		""";
	}
	
	public String buildSelectAll() {
		return buildBaseSelect();
	}
	
	public String buildSelectById() {
		return buildBaseSelect() + " WHERE t.\"id_ticket\" = ?";
	}
	
	public String buildSelectByFilter(final TicketEntity filter, final List<Object> params) {
	    var sql = new StringBuilder(buildBaseSelect());
	    sql.append(" WHERE 1 = 1 ");

	    if (ObjectHelper.isNull(filter)) {
	        return sql.toString();
	    }

	    // Filtrar por ID Ticket
	    if (!UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getId())) {
	        sql.append(" AND t.\"id_ticket\" = ? ");
	        params.add(filter.getId());
	    }

	    // Filtrar por número de ticket
	    if (!NumericHelper.isZero(filter.getTicketNumber())) {
	        sql.append(" AND LOWER(t.\"numero_ticket\") LIKE LOWER(?) ");
	        params.add("%" + filter.getTicketNumber() + "%");
	    }

	    // Filtrar por fecha de entrada (exacta, opcional)
	    if (!ObjectHelper.isNull(filter.getEntryDate())) {
	        sql.append(" AND t.\"fecha_entrada\" = ? ");
	        params.add(filter.getEntryDate());
	    }

	    // Filtrar por celda de vehículo
	    if (!ObjectHelper.isNull(filter.getCellVehicle())
	        && !UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getCellVehicle().getId())) {

	        sql.append(" AND t.\"id_celda_vehiculo\" = ? ");
	        params.add(filter.getCellVehicle().getId());
	    }

	    // Filtrar por estado del ticket
	    if (!ObjectHelper.isNull(filter.getTicketStatus())
	        && !UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getTicketStatus().getId())) {

	        sql.append(" AND t.\"id_estado_ticket\" = ? ");
	        params.add(filter.getTicketStatus().getId());
	    }

	    return sql.toString();
	}
	
}
