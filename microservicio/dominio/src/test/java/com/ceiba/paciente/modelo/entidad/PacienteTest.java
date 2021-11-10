package com.ceiba.paciente.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.paciente.servicio.testdatabuilder.PacienteTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PacienteTest {
    private static final String SE_DEBE_INGRESAR_EL_DOCUMENTO_IDENTIFICACION = "Se deben ingresar el documento de identificación";
    private static final String SE_DEBE_INGRESAR_LOS_NOMBRES = "Se deben ingresar los nombres";
    private static final String SE_DEBE_INGRESAR_LOS_APELLIDOS = "Se deben ingresar los apellidos";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO = "Se debe ingresar la fecha de nacimiento";

    @Test
    @DisplayName("Deberia crear correctamente el paciente")
    void deberiaCrearCorrectamenteElPaciente() {
        //Preparación
        LocalDate fechaNacimiento = LocalDate.of(1990, 8, 4);

        // Ejecución
        Paciente paciente = new PacienteTestDataBuilder()
                .conId(1L)
                .conDocumentoIdentificacion("12345678")
                .conNombres("Test")
                .conApellidos("Test")
                .conFechaNacimiento(fechaNacimiento)
                .build();

        // Assert
        assertEquals(1L, paciente.getId());
        assertEquals("12345678", paciente.getDocumentoIdentificacion());
        assertEquals("Test", paciente.getNombres());
        assertEquals("Test", paciente.getApellidos());
        assertEquals(fechaNacimiento, paciente.getFechaNacimiento());
    }

    @Test
    @DisplayName("Deberia lanzar una excepción de que debe ingresar el documento de identidad del paciente")
    void deberiaFallarSinDocumentoIdentidadDelPaciente() {
        //Preparación
        LocalDate fechaNacimiento = LocalDate.of(1990, 8, 4);

        // Ejecución
        PacienteTestDataBuilder pacienteTestDataBuilder = new PacienteTestDataBuilder()
                .conId(1L)
                .conDocumentoIdentificacion(null);

        // Assert
        BasePrueba.assertThrows((BasePrueba.Thunk) pacienteTestDataBuilder::build,
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_DOCUMENTO_IDENTIFICACION);

    }

    @Test
    @DisplayName("Deberia lanzar una excepción de que debe ingresar los nombres del paciente")
    void deberiaFallarSinNombresDelPaciente() {
        //Preparación
        LocalDate fechaNacimiento = LocalDate.of(1990, 8, 4);

        // Ejecución
        PacienteTestDataBuilder pacienteTestDataBuilder = new PacienteTestDataBuilder()
                .conId(1L)
                .conDocumentoIdentificacion("12345678")
                .conNombres(null);

        // Assert
        BasePrueba.assertThrows((BasePrueba.Thunk) pacienteTestDataBuilder::build,
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LOS_NOMBRES);

    }

    @Test
    @DisplayName("Deberia lanzar una excepción de que debe ingresar los apellidos del paciente")
    void deberiaFallarSinApellidosDelPaciente() {
        //Preparación
        LocalDate fechaNacimiento = LocalDate.of(1990, 8, 4);

        // Ejecución
        PacienteTestDataBuilder pacienteTestDataBuilder = new PacienteTestDataBuilder()
                .conId(1L)
                .conDocumentoIdentificacion("12345678")
                .conNombres("Test")
                .conApellidos(null);

        // Assert
        BasePrueba.assertThrows((BasePrueba.Thunk) pacienteTestDataBuilder::build,
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LOS_APELLIDOS);

    }

    @Test
    @DisplayName("Deberia lanzar una excepción de que debe ingresar la fecha de nacimiento del paciente")
    void deberiaFallarSinFechaDeNacimientoDelPaciente() {
        //Preparación

        // Ejecución
        PacienteTestDataBuilder pacienteTestDataBuilder = new PacienteTestDataBuilder()
                .conId(1L)
                .conDocumentoIdentificacion("12345678")
                .conNombres("Test")
                .conApellidos("Test")
                .conFechaNacimiento(null);

        // Assert
        BasePrueba.assertThrows((BasePrueba.Thunk) pacienteTestDataBuilder::build,
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO);

    }
}