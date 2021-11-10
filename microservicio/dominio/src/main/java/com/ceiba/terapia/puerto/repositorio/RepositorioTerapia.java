package com.ceiba.terapia.puerto.repositorio;

import com.ceiba.terapia.modelo.entidad.Terapia;

public interface RepositorioTerapia {
    /**
     * Permite crear una terapia
     *
     * @param terapia
     * @return el id generado para la terapia creada
     */
    Long crear(Terapia terapia);

}
