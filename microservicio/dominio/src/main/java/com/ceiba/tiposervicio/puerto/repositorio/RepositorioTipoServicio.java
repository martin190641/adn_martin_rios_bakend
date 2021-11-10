package com.ceiba.tiposervicio.puerto.repositorio;

public interface RepositorioTipoServicio {
    /**
     * Permite validar si existe un tipo de servicio con el id recibido
     *
     * @param id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
