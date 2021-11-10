package com.ceiba.especialista.servico;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;

public class ServicioCrearEspecialista {
    private static final String EL_ESPECIALISTA_YA_EXISTE_EN_EL_SISTEMA = "El especialista ya existe en el sistema";

    private final RepositorioEspecialista repositorioEspecialista;

    public ServicioCrearEspecialista(RepositorioEspecialista repositorioEspecialista) {
        this.repositorioEspecialista = repositorioEspecialista;
    }

    public Long ejecutar(Especialista especialista) {
        validarExistenciaPrevia(especialista);
        return this.repositorioEspecialista.crear(especialista);
    }

    private void validarExistenciaPrevia(Especialista especialista) {
        boolean existe = this.repositorioEspecialista.existe(especialista.getDocumentoIdentificacion());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_ESPECIALISTA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
