package com.ceiba.paciente.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;

public class ServicioCrearPaciente {
    private static final String EL_PACIENTE_YA_EXISTE_EN_EL_SISTEMA = "El paciente ya existe en el sistema";

    private final RepositorioPaciente repositorioPaciente;

    public ServicioCrearPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    public Long ejecutar(Paciente paciente) {
        validarExistenciaPrevia(paciente);
        return this.repositorioPaciente.crear(paciente);
    }

    private void validarExistenciaPrevia(Paciente paciente) {
        boolean existe = this.repositorioPaciente.existe(paciente.getDocumentoIdentificacion());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_PACIENTE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
