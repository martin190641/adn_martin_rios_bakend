package com.ceiba.terapia_detalle.puerto.repositorio;

import com.ceiba.terapia_detalle.modelo.entidad.TerapiaDetalle;

public interface RepositorioTerapiaDetalle {
    /**
     * Permite crear una terapia
     *
     * @param terapiaDetalle
     * @return el id generado para la terapia creada
     */
    Long crear(TerapiaDetalle terapiaDetalle);
}
