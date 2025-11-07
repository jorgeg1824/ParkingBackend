package co.edu.uco.parking.data.dao.entity.postgresql.builder;

import java.util.List;

import co.edu.uco.parking.crosscuting.helper.ObjectHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.entity.ManagerEntity;

public final class ManagerSqlBuilder {

    public String buildInsert() {
        return """
            INSERT INTO public."Administrador"(
                "id_administrador", "numero_documento", "nombre_administrador",
                "primer_apellido", "segundo_apellido", "correo",
                "telefono", "confirmacion_correo", "confirmacion_telefono", "es_activo"
            )
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;
    }

    public String buildUpdate() {
        return """
            UPDATE public."Administrador"
               SET "numero_documento" = ?, "nombre_administrador" = ?,
                   "primer_apellido" = ?, "segundo_apellido" = ?, "correo" = ?,
                   "telefono" = ?, "confirmacion_correo" = ?, "confirmacion_telefono" = ?, "es_activo" = ?
             WHERE "id_administrador" = ?
        """;
    }

    public String buildDelete() {
        return "DELETE FROM public.\"Administrador\" WHERE \"id_administrador\" = ?";
    }

    private String buildBaseSelect() {
        return """
            SELECT  a."id_administrador",
                    a."numero_documento",
                    a."nombre_administrador",
                    a."primer_apellido",
                    a."segundo_apellido",
                    a."correo",
                    a."telefono",
                    a."confirmacion_correo",
                    a."confirmacion_telefono",
                    a."es_activo"
              FROM public."Administrador" AS a
        """;
    }

    public String buildSelectAll() {
        return buildBaseSelect();
    }

    public String buildSelectById() {
        return buildBaseSelect() + " WHERE a.\"id_administrador\" = ?";
    }

    public String buildSelectByFilter(final ManagerEntity filter, final List<Object> params) {
        var sql = new StringBuilder(buildBaseSelect());
        sql.append(" WHERE 1 = 1 ");

        if (ObjectHelper.isNull(filter)) {
            return sql.toString();
        }

        // ID filter
        if (!UUIDHelper.getUUIDHelper().isDefaultUUID(filter.getId())) {
            sql.append(" AND a.\"id_administrador\" = ? ");
            params.add(filter.getId());
        }

        // Filters by strings
        if (!TextHelper.isEmpty(filter.getDocumentNumber())) {
            sql.append(" AND a.\"numero_documento\" = ? ");
            params.add(filter.getDocumentNumber());
        }
        if (!TextHelper.isEmpty(filter.getName())) {
            sql.append(" AND LOWER(a.\"nombre_administrador\") LIKE LOWER(?) ");
            params.add("%" + filter.getName() + "%");
        }
        if (!TextHelper.isEmpty(filter.getFirstSurname())) {
            sql.append(" AND LOWER(a.\"primer_apellido\") LIKE LOWER(?) ");
            params.add("%" + filter.getFirstSurname() + "%");
        }
        if (!TextHelper.isEmpty(filter.getEmail())) {
            sql.append(" AND LOWER(a.\"correo\") LIKE LOWER(?) ");
            params.add("%" + filter.getEmail() + "%");
        }

        return sql.toString();
    }
}
