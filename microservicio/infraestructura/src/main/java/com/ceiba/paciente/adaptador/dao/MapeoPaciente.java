package com.ceiba.paciente.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoPaciente implements RowMapper<DtoPaciente>, MapperResult {

    @Override
    public DtoPaciente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        ;
        String documentoIdentificacion = resultSet.getString("documento_identificacion");
        String nombres = resultSet.getString("nombres");
        String apellidos = resultSet.getString("apellidos");
        LocalDate fechaNacimiento = extraerLocalDate(resultSet, "fecha_nacimiento");

        return new DtoPaciente(id, documentoIdentificacion, nombres, apellidos, fechaNacimiento);
    }
}
