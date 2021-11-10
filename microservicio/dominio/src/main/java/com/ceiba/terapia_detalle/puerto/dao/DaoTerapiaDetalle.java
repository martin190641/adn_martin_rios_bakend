package com.ceiba.terapia_detalle.puerto.dao;

import com.ceiba.terapia_detalle.modelo.dto.DtoTerapiaDetalle;

import java.util.List;

public interface DaoTerapiaDetalle {
    /**
     * Permite listar las sesiones de la terapias por paciente
     *
     * @param terapiaId: identificador de la terapia
     * @return retorna un listado de terapias del paciente
     */
    List<DtoTerapiaDetalle> listarPorTerapiaId(Long terapiaId);

}
