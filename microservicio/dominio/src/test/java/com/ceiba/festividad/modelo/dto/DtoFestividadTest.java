package com.ceiba.festividad.modelo.dto;

import com.ceiba.festividad.servicio.testdatabuilder.DtoFestividadTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DtoFestividadTest {
    @Test
    @DisplayName("Deberia crear correctamente el Dto festividad")
    void deberiaCrearCorrectamenteElDtoFestividad() {
        // Preparación
        LocalDate fechaFestiva = LocalDate.now();

        // Ejecución
        DtoFestividad dtoFestividad = new DtoFestividadTestDataBuilder()
                .build();
        // Assert
        assertEquals(fechaFestiva, dtoFestividad.getFechaFestiva());
        assertEquals("Dia Festivo", dtoFestividad.getDescripcion());
    }
}