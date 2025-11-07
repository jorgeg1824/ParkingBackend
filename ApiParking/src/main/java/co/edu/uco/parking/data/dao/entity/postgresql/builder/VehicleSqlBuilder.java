package co.edu.uco.parking.data.dao.entity.postgresql.builder;

import java.util.List;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.VehicleEntity;

public final class VehicleSqlBuilder {
	
	public String buildInsert() {
		return """
			INSERT INTO public."Vehiculo"(
				"id_vehiculo", "placa", "id_tipo_vehiculo"
			)
			VALUES (?, ?, ?)
		""";
	}
	
	public String buildUpdate() {
		return """
			UPDATE public."Vehiculo"
			   SET "placa" = ?, 
			       "id_tipo_vehiculo" = ?
			 WHERE "id_vehiculo" = ?
		""";
	}
	
	public String buildDelete() {
		return """
			DELETE FROM public."Vehiculo"
			 WHERE "id_vehiculo" = ?
		""";
	}
	
	private String buildBaseSelect() {
		return """
			SELECT 
				v."id_vehiculo",
				v."placa",
				v."id_tipo_vehiculo"
			  FROM public."Vehiculo" AS v
		""";
	}
	
	public String buildSelectAll() {
		return buildBaseSelect();
	}
	
	public String buildSelectById() {
		return buildBaseSelect() + " WHERE v.\"id_vehiculo\" = ?";
	}
	
	public String buildSelectByFilter(final VehicleEntity filter, final List<Object> params) {
	    var sql = new StringBuilder(buildBaseSelect());
	    sql.append(" WHERE 1 = 1 ");

	    if (ObjectHelper.isNull(filter)) {
	        return sql.toString();
	    }

	    // Filtrar por ID del vehículo
	    if (!UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getId())) {
	        sql.append(" AND v.\"id_vehiculo\" = ? ");
	        params.add(filter.getId());
	    }

	    // Filtrar por placa
	    if (!TextHelper.isEmpty(filter.getLicensePlate())) {
	        sql.append(" AND LOWER(v.\"placa\") LIKE LOWER(?) ");
	        params.add("%" + filter.getLicensePlate() + "%");
	    }

	    // Filtrar por tipo de vehículo (si viene el objeto dentro del filtro)
	    if (!ObjectHelper.isNull(filter.getVehicleType()) &&
	        !UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getVehicleType().getId())) {

	        sql.append(" AND v.\"id_tipo_vehiculo\" = ? ");
	        params.add(filter.getVehicleType().getId());
	    }

	    return sql.toString();
	}
	
}
