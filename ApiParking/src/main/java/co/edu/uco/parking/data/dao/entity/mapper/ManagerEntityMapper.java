package co.edu.uco.parking.data.dao.entity.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.edu.uco.parking.crosscuting.helper.UUIDHelper;
import co.edu.uco.parking.crosscuting.helper.TextHelper;
import co.edu.uco.parking.crosscuting.helper.BooleanHelper;
import co.edu.uco.parking.entity.ManagerEntity;

public final class ManagerEntityMapper {

    public ManagerEntityMapper() {
    }

    public static ManagerEntity map(final ResultSet rs) throws SQLException {
        var manager = new ManagerEntity();
        
        manager.setId(UUIDHelper.getUUIDHelper().getFromString(rs.getString("id_administrador")));
        manager.setDocumentNumber(rs.getString("numero_documento"));
        manager.setName(TextHelper.getDefaultWithTrim(rs.getString("nombre_administrador")));
        manager.setFirstSurname(TextHelper.getDefaultWithTrim(rs.getString("primer_apellido")));
        manager.setSecondSurname(TextHelper.getDefaultWithTrim(rs.getString("segundo_apellido")));
        manager.setEmail(TextHelper.getDefaultWithTrim(rs.getString("correo")));
        manager.setPhoneNumber(rs.getString("telefono")); 
        manager.setEmailConfirmed(BooleanHelper.getDefault(rs.getBoolean("confirmacion_correo")));
        manager.setPhoneConfirmed(BooleanHelper.getDefault(rs.getBoolean("confirmacion_telefono")));
        manager.setActive(BooleanHelper.getDefault(rs.getBoolean("es_activo")));

        return manager;
    }
}
