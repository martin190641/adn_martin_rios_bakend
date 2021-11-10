package com.ceiba.especialista.servico;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;

public class ServicioActualizarEspecialista {
    private static final String EL_ESPECIALISTA_NO_EXISTE_EN_EL_SISTEMA = "El especialista no existe en el sistema";

    private final RepositorioEspecialista repositorioEspecialista;

    public ServicioActualizarEspecialista(RepositorioEspecialista repositorioEspecialista) {
        this.repositorioEspecialista = repositorioEspecialista;
    }

    public void ejecutar(Especialista especialista) {
        validarExistenciaPrevia(especialista);
        this.repositorioEspecialista.actualizar(especialista);
    }

    private void validarExistenciaPrevia(Especialista especialista) {
        boolean existe = this.repositorioEspecialista.existePorId(especialista.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_ESPECIALISTA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
