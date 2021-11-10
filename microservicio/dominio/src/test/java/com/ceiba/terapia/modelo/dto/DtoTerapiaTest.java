package com.ceiba.terapia.modelo.dto;

import com.ceiba.terapia.servicio.testdatabuilder.DtoTerapiaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DtoTerapiaTest {
    @Test
    @DisplayName("Deberia crear correctamente el dto terapia")
    void deberiaCrearCorrectamenteElDtoTerapia() {
        //Preparación
        LocalDate fechaActual = LocalDate.now();

        // Ejecución
        DtoTerapia terapia = new DtoTerapiaTestDataBuilder()
                .conId(1L)
                .conPacienteId(1L)
                .conTipoServicioId(1L)
                .conEspecialistaId(1L)
                .conFechaTerapia(fechaActual)
                .conDescuento(0)
                .conValorNeto(1000)
                .conValorTotal(1000)
                .build();

        // Assert
        assertEquals(1L, terapia.getId());
        assertEquals(1L, terapia.getPacienteId());
        assertEquals(1L, terapia.getTipoServicioId());
        assertEquals(1L, terapia.getEspecialistaId());
        assertEquals(fechaActual, terapia.getFechaTerapia());
        assertEquals(0, terapia.getDescuento());
        assertEquals(1000, terapia.getValorNeto());
        assertEquals(1000, terapia.getValorTotal());
        assertNull(terapia.getTerapiaDetalles());
    }

}