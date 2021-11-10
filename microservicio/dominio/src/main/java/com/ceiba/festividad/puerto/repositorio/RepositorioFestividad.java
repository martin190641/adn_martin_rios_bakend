package com.ceiba.festividad.puerto.repositorio;

import java.time.LocalDate;

public interface RepositorioFestividad {
    /**
     * Permite validar si existe una fecha existe
     *
     * @param fecha: fecha a consultar
     * @return si existe o no
     */
    boolean existe(LocalDate fecha);
}
