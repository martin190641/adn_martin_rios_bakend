package com.ceiba.terapia_detalle.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.terapia_detalle.modelo.entidad.TerapiaDetalle;
import com.ceiba.terapia_detalle.puerto.repositorio.RepositorioTerapiaDetalle;
import org.springframework.stereotype.Component;

@Component
public class RepositorioTerapiaDetallePostgreSQL implements RepositorioTerapiaDetalle {
    @SqlStatement(namespace = "terapia_detalle", value = "crear")
    private static String sqlCrear;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioTerapiaDetallePostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(TerapiaDetalle terapiaDetalle) {

        return this.customNamedParameterJdbcTemplate.crear(terapiaDetalle, sqlCrear);
    }
}
