package com.ceiba.especialista.adaptador.dao;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoEspecialista implements RowMapper<DtoEspecialista>, MapperResult {

    @Override
    public DtoEspecialista mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String documentoIdentificacion = resultSet.getString("documento_identificacion");
        String nombres = resultSet.getString("nombres");
        String apellidos = resultSet.getString("apellidos");
        LocalDate fechaNacimiento = extraerLocalDate(resultSet, "fecha_nacimiento");
        boolean estado = resultSet.getBoolean("estado");

        return new DtoEspecialista(id, documentoIdentificacion, nombres, apellidos, fechaNacimiento, estado);
    }
}
