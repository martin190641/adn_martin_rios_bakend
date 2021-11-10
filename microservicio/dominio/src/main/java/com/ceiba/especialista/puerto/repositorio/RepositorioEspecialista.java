package com.ceiba.especialista.puerto.repositorio;

import com.ceiba.especialista.modelo.entidad.Especialista;

public interface RepositorioEspecialista {

    /**
     * Permite crear un especialista
     *
     * @param especialista
     * @return el id generado para el especialista creado
     */
    Long crear(Especialista especialista);

    /**
     * Permite actualizar un especialista
     *
     * @param especialista
     */
    void actualizar(Especialista especialista);

    /**
     * Permite eliminar un especialista por id
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un especialista con un número de identificación
     *
     * @param numeroIdenticacion
     * @return si existe o no
     */
    boolean existe(String numeroIdenticacion);

    /**
     * Permite validar si existe un especialista con el id recibido
     *
     * @param id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
