package com.ceiba.especialista.puerto.dao;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;

import java.util.List;

public interface DaoEspecialista {

    /**
     * Permite listar los especialistas
     *
     * @return retorna un listado de especialistas
     */
    List<DtoEspecialista> listar();

    /**
     * Permite listar un especialista
     *
     * @param id: identificador del especialista
     * @return DtoEspecialista: retorna un especialista correspondiente al id
     */
    DtoEspecialista listarPorId(long id);
}
