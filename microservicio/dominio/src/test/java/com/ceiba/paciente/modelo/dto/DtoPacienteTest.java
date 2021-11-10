package com.ceiba.paciente.modelo.dto;

import com.ceiba.paciente.servicio.testdatabuilder.DtoPacienteTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DtoPacienteTest {
    @Test
    @DisplayName("Deberia crear correctamente el Dto paciente")
    void deberiaCrearCorrectamenteElDtoPaciente() {
        //Preparación
        LocalDate fechaNacimiento = LocalDate.of(1990, 8, 4);

        // Ejecución
        DtoPaciente dtoPaciente = new DtoPacienteTestDataBuilder()
                .conId(1L)
                .conDocumentoIdentificacion("12345678")
                .conNombres("Test")
                .conApellidos("Test")
                .conFechaNacimiento(fechaNacimiento)
                .build();

        // Assert
        assertEquals(1L, dtoPaciente.getId());
        assertEquals("12345678", dtoPaciente.getDocumentoIdentificacion());
        assertEquals("Test", dtoPaciente.getNombres());
        assertEquals("Test", dtoPaciente.getApellidos());
        assertEquals(fechaNacimiento, dtoPaciente.getFechaNacimiento());
    }

}