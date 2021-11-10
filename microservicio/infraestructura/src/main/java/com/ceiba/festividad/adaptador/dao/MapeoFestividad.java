package com.ceiba.festividad.adaptador.dao;

import com.ceiba.festividad.modelo.dto.DtoFestividad;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoFestividad implements RowMapper<DtoFestividad>, MapperResult {

    @Override
    public DtoFestividad mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        LocalDate fechaFestiva = extraerLocalDate(resultSet, "fecha_festiva");
        ;
        String descripcion = resultSet.getString("descripcion");

        return new DtoFestividad(fechaFestiva, descripcion);
    }
}
