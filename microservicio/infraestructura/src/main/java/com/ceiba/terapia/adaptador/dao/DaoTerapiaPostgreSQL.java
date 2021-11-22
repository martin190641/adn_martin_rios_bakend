package com.ceiba.terapia.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.terapia.modelo.dto.DtoTerapia;
import com.ceiba.terapia.puerto.dao.DaoTerapia;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DaoTerapiaPostgreSQL implements DaoTerapia {
    @SqlStatement(namespace = "terapia", value = "listarPorPaciente")
    private static String sqlListarTerapia;

    @SqlStatement(namespace = "terapia", value = "contarTerapiasPorPacienteEntreFechas")
    private static String sqlContarTerapiasPorPacienteEntreFechas;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoTerapiaPostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTerapia> listarPorPaciente(Long pacienteId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("pacienteId", pacienteId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarTerapia, paramSource, new MapeoTerapia());

    }

    @Override
    public Integer cantidadTepariasMes(Long pacienteId, LocalDate fechaIncial, LocalDate fehcaFinal) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("pacienteId", pacienteId);
        paramSource.addValue("fechaInicial", fechaIncial);
        paramSource.addValue("fechaFinal", fehcaFinal);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlContarTerapiasPorPacienteEntreFechas, paramSource, Integer.class);
    }
}
