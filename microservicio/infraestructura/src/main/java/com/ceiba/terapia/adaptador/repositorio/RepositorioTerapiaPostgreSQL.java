package com.ceiba.terapia.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.terapia.modelo.entidad.Terapia;
import com.ceiba.terapia.puerto.repositorio.RepositorioTerapia;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTerapiaPostgreSQL implements RepositorioTerapia {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "terapia", value = "crear")
    private String sqlCrear;


    public RepositorioTerapiaPostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Terapia terapia) {
        return this.customNamedParameterJdbcTemplate.crear(terapia, this.sqlCrear);
    }

}
