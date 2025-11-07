package co.edu.uco.parking.data.dao.entity.postgresql.builder;

import java.util.List;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.ZoneEntity;

public final class ZoneSqlBuilder {

    public String buildInsert() {
        return """
            INSERT INTO public."Zona" (
                "id_zona", "nombre_zona", "descripcion", "es_activo"
            )
            VALUES (?, ?, ?, ?)
        """;
    }

    public String buildUpdate() {
        return """
            UPDATE public."Zona"
               SET "nombre_zona" = ?, 
                   "descripcion" = ?, 
                   "es_activo" = ?
             WHERE "id_zona" = ?
        """;
    }

    public String buildDelete() {
        return """
            DELETE FROM public."Zona"
             WHERE "id_zona" = ?
        """;
    }

    private String buildBaseSelect() {
        return """
            SELECT 
                z."id_zona",
                z."nombre_zona",
                z."descripcion",
                z."es_activo"
              FROM public."Zona" AS z
        """;
    }

    public String buildSelectAll() {
        return buildBaseSelect();
    }

    public String buildSelectById() {
        return buildBaseSelect() + " WHERE z.\"id_zona\" = ?";
    }

    public String buildSelectByFilter(final ZoneEntity filter, final List<Object> params) {
        var sql = new StringBuilder(buildBaseSelect());
        sql.append(" WHERE 1 = 1 ");

        if (ObjectHelper.isNull(filter)) {
            return sql.toString();
        }

        if (!UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getId())) {
            sql.append(" AND z.\"id_zona\" = ? ");
            params.add(filter.getId());
        }

        if (!TextHelper.isEmpty(filter.getName())) {
            sql.append(" AND LOWER(z.\"nombre_zona\") LIKE LOWER(?) ");
            params.add("%" + filter.getName() + "%");
        }

        if (!TextHelper.isEmpty(filter.getDescription())) {
            sql.append(" AND LOWER(z.\"descripcion\") LIKE LOWER(?) ");
            params.add("%" + filter.getDescription() + "%");
        }

        // Filtrar por estado activo si se especifica (true/false explícitamente)
        if (!ObjectHelper.isNull(filter.isActive())) {
            sql.append(" AND z.\"es_activo\" = ? ");
            params.add(filter.isActive());
        }

        return sql.toString();
    }
}
