package com.ceiba.paciente.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;

public class ServicioActualizarPaciente {
    private static final String EL_PACIENTE_NO_EXISTE_EN_EL_SISTEMA = "El paciente no existe en el sistema";

    private final RepositorioPaciente repositorioPaciente;

    public ServicioActualizarPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    public void ejecutar(Paciente paciente) {
        validarExistenciaPrevia(paciente);
        this.repositorioPaciente.actualizar(paciente);
    }

    private void validarExistenciaPrevia(Paciente paciente) {
        boolean existe = this.repositorioPaciente.existePorId(paciente.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_PACIENTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
