package com.ceiba.paciente.puerto.dao;

import com.ceiba.paciente.modelo.dto.DtoPaciente;

import java.util.List;

public interface DaoPaciente {

    /**
     * Permite listar los pacientes
     *
     * @return retorna un listado de pacientes
     */
    List<DtoPaciente> listar();

    /**
     * Permite consultar un paciente
     *
     * @param id: identificador del paciente
     * @return DtoEspecialista: retorna un paciente correspondiente al id
     */
    DtoPaciente listarPorId(long id);
}
