package com.ceiba.terapia_detalle.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.terapia_detalle.modelo.dto.DtoTerapiaDetalle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoTerapiaDetalle implements RowMapper<DtoTerapiaDetalle>, MapperResult {

    @Override
    public DtoTerapiaDetalle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        Long terapiaId = resultSet.getLong("terapia_id");
        LocalDateTime fechaHora = extraerLocalDateTime(resultSet, "fecha_hora");
        return new DtoTerapiaDetalle(id, terapiaId, fechaHora);
    }
}
