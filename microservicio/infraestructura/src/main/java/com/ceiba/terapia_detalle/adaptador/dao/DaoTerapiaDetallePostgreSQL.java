package com.ceiba.terapia_detalle.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.terapia_detalle.modelo.dto.DtoTerapiaDetalle;
import com.ceiba.terapia_detalle.puerto.dao.DaoTerapiaDetalle;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoTerapiaDetallePostgreSQL implements DaoTerapiaDetalle {
    @SqlStatement(namespace = "terapia_detalle", value = "listarPorTerapiaId")
    private static String sqlListarPorTerapiaId;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoTerapiaDetallePostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTerapiaDetalle> listarPorTerapiaId(Long terapiaId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("terapiaId", terapiaId);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorTerapiaId, paramSource, new MapeoTerapiaDetalle());

    }
}
