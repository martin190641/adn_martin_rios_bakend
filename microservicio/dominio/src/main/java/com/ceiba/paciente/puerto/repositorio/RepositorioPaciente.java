package com.ceiba.paciente.puerto.repositorio;

import com.ceiba.paciente.modelo.entidad.Paciente;

public interface RepositorioPaciente {
    /**
     * Permite crear un paciente
     *
     * @param paciente
     * @return el id generado para el paciente creado
     */
    Long crear(Paciente paciente);

    /**
     * Permite actualizar un paciente
     *
     * @param paciente
     */
    void actualizar(Paciente paciente);

    /**
     * Permite eliminar un paciente por id
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un paciente con un número de identificación
     *
     * @param documentoIdentificacion
     * @return si existe o no
     */
    boolean existe(String documentoIdentificacion);

    /**
     * Permite validar si existe un paciente con el id recibido
     *
     * @param id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
