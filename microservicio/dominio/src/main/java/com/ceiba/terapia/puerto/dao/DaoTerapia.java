package com.ceiba.terapia.puerto.dao;

import com.ceiba.terapia.modelo.dto.DtoTerapia;

import java.time.LocalDate;
import java.util.List;

public interface DaoTerapia {
    /**
     * Permite listar las terapias por paciente
     *
     * @return retorna un listado de terapias del paciente
     */
    List<DtoTerapia> listarPorPaciente(Long pacienteId);

    /**
     * Permite listar cantidad de las terapias por paciente para un rango de fehcas
     *
     * @return retorna la cantida de terapias del paciente para un rango de fechas
     */
    Integer cantidadTepariasMes(Long pacienteId, LocalDate fechaIncial, LocalDate fehcaFinal);
}
