package co.edu.uco.parking.data.dao.entity.postgresql.builder;

import java.util.List;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.ManagerZoneEntity;

public final class ManagerZoneSqlBuilder {
	
	public String buildInsert() {
		return """
			INSERT INTO public."AdministradorZona" (
				"id_admin_zona", "fecha_administracion", "id_administrador", "id_zona"
			)
			VALUES (?, ?, ?, ?)
		""";
	}
	
	public String buildUpdate() {
		return """
			UPDATE public."AdministradorZona"
			   SET "fecha_administracion" = ?, 
			       "id_administrador" = ?, 
			       "id_zona" = ?
			 WHERE "id_admin_zona" = ?
		""";
	}
	
	public String buildDelete() {
		return """
			DELETE FROM public."AdministradorZona"
			 WHERE "id_admin_zona" = ?
		""";
	}
	
	private String buildBaseSelect() {
		return """
			SELECT 
				az."id_admin_zona",
				az."fecha_administracion",
				az."id_administrador",
				az."id_zona"
			  FROM public."AdministradorZona" AS az
		""";
	}
	
	public String buildSelectAll() {
		return buildBaseSelect();
	}
	
	public String buildSelectById() {
		return buildBaseSelect() + " WHERE az.\"id_admin_zona\" = ?";
	}
	
	public String buildSelectByFilter(final ManagerZoneEntity filter, final List<Object> params) {
	    var sql = new StringBuilder(buildBaseSelect());
	    sql.append(" WHERE 1 = 1 ");

	    if (ObjectHelper.isNull(filter)) {
	        return sql.toString();
	    }

	    // Filtrar por id_admin_zona
	    if (!UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getId())) {
	        sql.append(" AND az.\"id_admin_zona\" = ? ");
	        params.add(filter.getId());
	    }

	    // Filtrar por id_administrador
	    if (!ObjectHelper.isNull(filter.getManager()) 
	        && !UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getManager().getId())) {
	        sql.append(" AND az.\"id_administrador\" = ? ");
	        params.add(filter.getManager().getId());
	    }

	    // Filtrar por id_zona
	    if (!ObjectHelper.isNull(filter.getZone()) 
	        && !UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getZone().getId())) {
	        sql.append(" AND az.\"id_zona\" = ? ");
	        params.add(filter.getZone().getId());
	    }

	    // Filtrar por fecha_administracion
	    if (!ObjectHelper.isNull(filter.getAdministrationDate())) {
	        sql.append(" AND az.\"fecha_administracion\" = ? ");
	        params.add(filter.getAdministrationDate());
	    }

	    return sql.toString();
	}

}
