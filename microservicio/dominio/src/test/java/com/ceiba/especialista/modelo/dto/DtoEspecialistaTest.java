package com.ceiba.especialista.modelo.dto;

import com.ceiba.especialista.servico.testdatabuilder.DtoEspecialistaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DtoEspecialistaTest {
    @Test
    @DisplayName("Deberia crear correctamente el Dto especialista")
    void deberiaCrearCorrectamenteElDtoEspecialista() {
        // Preparación
        LocalDate fechaNacimiento = LocalDate.now();

        // Ejecución
        DtoEspecialista dtoEspecialista = new DtoEspecialistaTestDataBuilder()
                .conId(1L)
                .conDocumentoIdentificacion("987654321")
                .conNombres("Test")
                .conApellidos("Test")
                .conFechaNacimiento(fechaNacimiento)
                .conEstado(true)
                .build();
        // Assert
        assertEquals(1L, dtoEspecialista.getId());
        assertEquals("987654321", dtoEspecialista.getDocumentoIdentificacion());
        assertEquals("Test", dtoEspecialista.getNombres());
        assertEquals("Test", dtoEspecialista.getApellidos());
        assertEquals(fechaNacimiento, dtoEspecialista.getFechaNacimiento());
        assertTrue(dtoEspecialista.isEstado());
    }

}