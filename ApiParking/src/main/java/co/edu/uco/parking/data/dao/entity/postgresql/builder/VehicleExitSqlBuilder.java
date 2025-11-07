package co.edu.uco.parking.data.dao.entity.postgresql.builder;

import java.math.BigDecimal;
import java.util.List;

import co.edu.uco.parking.crosscuting.helper.DurationHelper;
import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.VehicleExitEntity;

public final class VehicleExitSqlBuilder {
	
	public String buildInsert() {
		return """
			INSERT INTO public."SalidaVehiculo" (
				"id_salida_vehiculo", "fecha_salida", "tiempo_estadia", "valor_pagar", "id_ticket"
			)
			VALUES (?, ?, ?, ?, ?)
		""";
	}
	
	public String buildUpdate() {
		return """
			UPDATE public."SalidaVehiculo"
			   SET "fecha_salida" = ?, 
			       "tiempo_estadia" = ?, 
			       "valor_pagar" = ?, 
			       "id_ticket" = ?
			 WHERE "id_salida_vehiculo" = ?
		""";
	}
	
	public String buildDelete() {
		return """
			DELETE FROM public."SalidaVehiculo"
			 WHERE "id_salida_vehiculo" = ?
		""";
	}
	
	public String buildBaseSelect() {
		return """
			SELECT 
				sv."id_salida_vehiculo",
				sv."fecha_salida",
				sv."tiempo_estadia",
				sv."valor_pagar",
				sv."id_ticket"
			  FROM public."SalidaVehiculo" AS sv
		""";
	}
	
	public String buildSelectAll() {
		return buildBaseSelect();
	}
	
	public String buildSelectById() {
		return buildBaseSelect() + " WHERE sv.\"id_salida_vehiculo\" = ?";
	}
	
	public String buildSelectByFilter(final VehicleExitEntity filter, final List<Object> params) {
	    var sql = new StringBuilder(buildBaseSelect());
	    sql.append(" WHERE 1 = 1 ");

	    if (ObjectHelper.isNull(filter)) {
	        return sql.toString();
	    }

	    // Filtrar por ID salida de vehículo
	    if (!UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getId())) {
	        sql.append(" AND sv.\"id_salida_vehiculo\" = ? ");
	        params.add(filter.getId());
	    }

	    // Filtrar por fecha de salida
	    if (!ObjectHelper.isNull(filter.getExitDate())) {
	        sql.append(" AND sv.\"fecha_salida\" = ? ");
	        params.add(filter.getExitDate());
	    }

	    if (!ObjectHelper.isNull(filter.getStayDuration()) && DurationHelper.toMinutes(filter.getStayDuration()) > 0) {
	        sql.append(" AND sv.\"tiempo_estadia\" = ? ");
	        params.add(filter.getStayDuration());
	    }

	    // Filtrar por valor a pagar (BigDecimal) — validamos que no sea nulo y mayor que cero
	    if (!ObjectHelper.isNull(filter.getTotalAmount()) && filter.getTotalAmount().compareTo(BigDecimal.ZERO) > 0) {
	        sql.append(" AND sv.\"valor_pagar\" = ? ");
	        params.add(filter.getTotalAmount());
	    }

	    // Filtrar por ID ticket
	    if (!ObjectHelper.isNull(filter.getTicket()) 
	        && !UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getTicket().getId())) {
	        
	        sql.append(" AND sv.\"id_ticket\" = ? ");
	        params.add(filter.getTicket().getId());
	    }

	    return sql.toString();
	}

}
