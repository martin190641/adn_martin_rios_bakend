package com.ceiba.tiposervicio.modelo.dto;

import com.ceiba.tiposervicio.servicio.testdatabuilder.DtoTipoServicioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DtoTipoServicioTest {
    @Test
    @DisplayName("Deberia crear correctamente el dto tipo de servicio")
    void deberiaCrearCorrectamenteElDtoTipoServcio() {
        // Preparación

        // Ejecución
        DtoTipoServicio DtoTipoServicio = new DtoTipoServicioTestDataBuilder()
                .build();
        // Assert
        assertEquals(1L, DtoTipoServicio.getId());
        assertEquals("Test", DtoTipoServicio.getNombre());
        assertEquals("Test Descripcion", DtoTipoServicio.getDescripcion());
        assertEquals(10000.0, DtoTipoServicio.getValor());
    }

}