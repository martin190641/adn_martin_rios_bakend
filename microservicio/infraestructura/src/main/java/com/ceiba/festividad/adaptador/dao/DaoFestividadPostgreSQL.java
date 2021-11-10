package com.ceiba.festividad.adaptador.dao;

import com.ceiba.festividad.modelo.dto.DtoFestividad;
import com.ceiba.festividad.puerto.dao.DaoFestividad;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoFestividadPostgreSQL implements DaoFestividad {

    @SqlStatement(namespace = "festividad", value = "listar")
    private static String sqlListar;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoFestividadPostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoFestividad> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoFestividad());
    }
}
