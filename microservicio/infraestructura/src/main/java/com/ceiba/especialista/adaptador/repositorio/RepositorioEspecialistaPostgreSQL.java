package com.ceiba.especialista.adaptador.repositorio;

import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEspecialistaPostgreSQL implements RepositorioEspecialista {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "especialista", value = "crear")
    private String sqlCrear;

    @SqlStatement(namespace = "especialista", value = "actualizar")
    private String sqlActualizar;

    @SqlStatement(namespace = "especialista", value = "eliminar")
    private String sqlEliminar;

    @SqlStatement(namespace = "especialista", value = "existe")
    private String sqlExiste;

    @SqlStatement(namespace = "especialista", value = "existePorId")
    private String sqlExistePorId;

    public RepositorioEspecialistaPostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Especialista especialista) {
        return this.customNamedParameterJdbcTemplate.crear(especialista, this.sqlCrear);
    }

    @Override
    public void actualizar(Especialista especialista) {
        this.customNamedParameterJdbcTemplate.actualizar(especialista, this.sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);

    }

    @Override
    public boolean existe(String documentoIdentificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("documentoIdentificacion", documentoIdentificacion);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class));

    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return Boolean.TRUE.equals(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class));
    }

}
