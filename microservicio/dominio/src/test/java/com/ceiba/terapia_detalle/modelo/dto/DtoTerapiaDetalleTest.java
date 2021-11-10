package com.ceiba.terapia_detalle.modelo.dto;

import com.ceiba.terapia_detalle.servicio.testdatabuilder.DtoTerapiaDetalleTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DtoTerapiaDetalleTest {
    @Test
    @DisplayName("Deberia crear correctamente el terapia detalle")
    void deberiaCrearCorrectamenteElTerapiaDetalle() {
        //Preparación
        LocalDateTime fechaHora = LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 30, 00));

        // Ejecución
        DtoTerapiaDetalle dtoTerapiaDetalle = new DtoTerapiaDetalleTestDataBuilder()
                .build();

        // Assert
        assertEquals(1L, dtoTerapiaDetalle.getId());
        assertEquals(1L, dtoTerapiaDetalle.getTerapiaId());
        assertEquals(fechaHora, dtoTerapiaDetalle.getFechaHora());
    }

}