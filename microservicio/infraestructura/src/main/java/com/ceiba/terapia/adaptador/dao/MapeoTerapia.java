package com.ceiba.terapia.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.terapia.modelo.dto.DtoTerapia;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoTerapia implements RowMapper<DtoTerapia>, MapperResult {


    @Override
    public DtoTerapia mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        Long pacienteId = resultSet.getLong("paciente_id");
        Long tipoServicioId = resultSet.getLong("tipo_servicio_id");
        Long especialistaId = resultSet.getLong("especialista_id");
        LocalDate fechaTerapia = extraerLocalDate(resultSet, "fecha_terapia");
        double descuento = resultSet.getDouble("descuento");
        double valorNeto = resultSet.getDouble("valor_neto");
        double valorTotal = resultSet.getDouble("valor_total");

        return new DtoTerapia(id, pacienteId, tipoServicioId, especialistaId, fechaTerapia, descuento, valorNeto, valorTotal, null);
    }
}
