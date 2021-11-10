package com.ceiba.festividad.modelo.entidad;

import com.ceiba.festividad.servicio.testdatabuilder.FestividadTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FestividadTest {

    @Test
    @DisplayName("Deberia crear correctamente la festividad")
    void deberiaCrearCorrectamenteLaFestividad() {
        // Preparación
        LocalDate fechaFestiva = LocalDate.now();

        // Ejecución
        Festividad festividad = new FestividadTestDataBuilder()
                .build();
        // Assert
        assertEquals(fechaFestiva, festividad.getFechaFestiva());
        assertEquals("Dia Festivo", festividad.getDescripcion());
    }

}