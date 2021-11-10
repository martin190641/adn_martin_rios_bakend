package com.ceiba.terapia.modelo.dto;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.especialista.servico.testdatabuilder.DtoEspecialistaTestDataBuilder;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import com.ceiba.paciente.servicio.testdatabuilder.DtoPacienteTestDataBuilder;
import com.ceiba.terapia.servicio.testdatabuilder.DtoTerapiaPorPacienteTestDataBuilder;
import com.ceiba.tiposervicio.modelo.dto.DtoTipoServicio;
import com.ceiba.tiposervicio.servicio.testdatabuilder.DtoTipoServicioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DtoTerapiaPorTerapiaTest {
    @Test
    @DisplayName("Deberia crear correctamente el dto terapia por paciente")
    void deberiaCrearCorrectamenteElDtoTerapia() {
        //Preparación
        LocalDate fechaActual = LocalDate.now();
        DtoPaciente dtoPaciente = new DtoPacienteTestDataBuilder().build();
        DtoTipoServicio dtoTipoServicio = new DtoTipoServicioTestDataBuilder().build();
        DtoEspecialista dtoEspecialista = new DtoEspecialistaTestDataBuilder().build();

        // Ejecución
        DtoTerapiaPorPaciente terapia = new DtoTerapiaPorPacienteTestDataBuilder()
                .conId(1L)
                .conPacienteId(dtoPaciente)
                .conTipoServicioId(dtoTipoServicio)
                .conEspecialistaId(dtoEspecialista)
                .conFechaTerapia(fechaActual)
                .conDescuento(0)
                .conValorNeto(1000)
                .conValorTotal(1000)
                .build();

        // Assert
        assertEquals(1L, terapia.getId());
        assertEquals(dtoPaciente, terapia.getPaciente());
        assertEquals(dtoTipoServicio, terapia.getTipoServicio());
        assertEquals(dtoEspecialista, terapia.getEspecialista());
        assertEquals(fechaActual, terapia.getFechaTerapia());
        assertEquals(0, terapia.getDescuento());
        assertEquals(1000, terapia.getValorNeto());
        assertEquals(1000, terapia.getValorTotal());
        assertNull(terapia.getTerapiaDetalles());
    }
}
