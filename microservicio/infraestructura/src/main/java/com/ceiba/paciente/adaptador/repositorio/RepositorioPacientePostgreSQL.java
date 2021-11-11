package com.ceiba.paciente.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPacientePostgreSQL implements RepositorioPaciente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "paciente", value = "crear")
    private static String sqlCrearPaciente;

    @SqlStatement(namespace = "paciente", value = "actualizar")
    private static String sqlActualizarPaciente;

    @SqlStatement(namespace = "paciente", value = "eliminar")
    private static String sqlEliminarPaciente;

    @SqlStatement(namespace = "paciente", value = "existe")
    private static String sqlExistePaciente;

    @SqlStatement(namespace = "paciente", value = "existePorId")
    private static String sqlExistePacientePorId;

    public RepositorioPacientePostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Paciente paciente) {
        return this.customNamedParameterJdbcTemplate.crear(paciente, sqlCrearPaciente);
    }

    @Override
    public void actualizar(Paciente paciente) {
        this.customNamedParameterJdbcTemplate.actualizar(paciente, sqlActualizarPaciente);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarPaciente, paramSource);
    }

    @Override
    public boolean existe(String documentoIdentificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("documentoIdentificacion", documentoIdentificacion);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePaciente, paramSource, Boolean.class));
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePacientePorId, paramSource, Boolean.class));
    }

}
