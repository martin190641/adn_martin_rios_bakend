package com.ceiba.paciente.puerto.dao;

import com.ceiba.paciente.modelo.dto.DtoPaciente;

import java.util.List;
import java.util.Optional;

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

    /**
     * Permite consultar un paciente
     *
     * @param documentoIdentificacion : Documento de identificación del paciente
     * @return DtoEspecialista: retorna un paciente correspondiente al documento de identificación
     */
    DtoPaciente listarPorDocumentoIdentificacion(String documentoIdentificacion);
}
