package com.ceiba.tiposervicio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tiposervicio.modelo.dto.DtoTipoServicio;
import com.ceiba.tiposervicio.puerto.dao.DaoTipoServicio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoTipoServicioPostgreSQL implements DaoTipoServicio {

    @SqlStatement(namespace = "tipo_servicio", value = "listar")
    private static String sqlListarTipoServicio;
    @SqlStatement(namespace = "tipo_servicio", value = "listarPorId")
    private static String sqlListarTipoServicioPorId;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoTipoServicioPostgreSQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoTipoServicio> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarTipoServicio, new MapeoTipoServicio());
    }

    @Override
    public DtoTipoServicio listarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarTipoServicioPorId, paramSource, new MapeoTipoServicio()).get(0);
    }
}
