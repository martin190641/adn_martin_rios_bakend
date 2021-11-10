package com.ceiba.festividad.puerto.dao;

import com.ceiba.festividad.modelo.dto.DtoFestividad;

import java.util.List;

public interface DaoFestividad {

    /**
     * @return retorna el listado de los dias festivos
     */
    List<DtoFestividad> listar();
}
