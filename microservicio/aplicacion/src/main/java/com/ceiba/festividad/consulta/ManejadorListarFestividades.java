package com.ceiba.festividad.consulta;

import com.ceiba.festividad.modelo.dto.DtoFestividad;
import com.ceiba.festividad.puerto.dao.DaoFestividad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarFestividades {

    private final DaoFestividad daoFestividad;

    public ManejadorListarFestividades(DaoFestividad daoFestividad) {
        this.daoFestividad = daoFestividad;
    }

    public List<DtoFestividad> ejecutar() {
        return daoFestividad.listar();
    }
}
