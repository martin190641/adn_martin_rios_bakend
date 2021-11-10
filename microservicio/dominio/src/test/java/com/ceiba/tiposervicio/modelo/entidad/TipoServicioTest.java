package com.ceiba.tiposervicio.modelo.entidad;

import com.ceiba.tiposervicio.servicio.testdatabuilder.TipoServicioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TipoServicioTest {

    @Test
    @DisplayName("Deberia crear correctamente el tipo de servicio")
    void deberiaCrearCorrectamenteElTipoServcio() {
        // Preparación

        // Ejecución
        TipoServicio tipoServicio = new TipoServicioTestDataBuilder()
                .build();
        // Assert
        assertEquals(1L, tipoServicio.getId());
        assertEquals("Test", tipoServicio.getNombre());
        assertEquals("Test Descripcion", tipoServicio.getDescripcion());
        assertEquals(10000.0, tipoServicio.getValor());
    }
}