package com.ceiba.paciente.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import com.ceiba.paciente.puerto.dao.DaoPaciente;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPacientePostgreSQL implements DaoPaciente {

    @SqlStatement(namespace = "paciente", value = "listar")
    private static String sqlListarPaciente;

    @SqlStatement(namespace = "paciente", value = "listarPorId")
    private static String sqlListarPacientePorId;

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoPacientePostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPaciente> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPaciente, new MapeoPaciente());
    }

    @Override
    public DtoPaciente listarPorId(long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPacientePorId, paramSource, new MapeoPaciente()).get(0);
    }
}
