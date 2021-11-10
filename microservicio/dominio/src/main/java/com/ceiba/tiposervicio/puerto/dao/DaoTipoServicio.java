package com.ceiba.tiposervicio.puerto.dao;

import com.ceiba.tiposervicio.modelo.dto.DtoTipoServicio;

import java.util.List;

public interface DaoTipoServicio {

    /**
     * @return retorna el listado de los tipos de servicio
     */
    List<DtoTipoServicio> listar();

    /**
     * Permite consultar un especialista por id
     *
     * @param id: identificador del tipo de servicio
     * @return retorna el tipo de servicio correspondiente al id
     */
    DtoTipoServicio listarPorId(Long id);
}
