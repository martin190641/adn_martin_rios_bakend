package com.ceiba.especialista.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.especialista.servico.testdatabuilder.EspecialistaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EspecialistaTest {
    private static final String SE_DEBE_INGRESAR_EL_DOCUMENTO_IDENTIFICACION = "Se deben ingresar el documento de identificación";
    private static final String SE_DEBE_INGRESAR_LOS_NOMBRES = "Se deben ingresar los nombres";
    private static final String SE_DEBE_INGRESAR_LOS_APELLIDOS = "Se deben ingresar los apellidos";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO = "Se debe ingresar la fecha de nacimiento";

    @Test
    @DisplayName("Deberia crear correctamente el especialista")
    void deberiaCrearCorrectamenteElEspecialista() {
        // Preparación
        LocalDate fechaNacimiento = LocalDate.of(1990, 8, 4);

        // Ejecución
        Especialista especialista = new EspecialistaTestDataBuilder()
                .conId(1L)
                .conDocumentoIdentificacion("987654321")
                .conNombres("Test")
                .conApellidos("Test")
                .conFechaNacimiento(fechaNacimiento)
                .conEstado(true)
                .build();
        // Assert
        assertEquals(1L, especialista.getId());
        assertEquals("987654321", especialista.getDocumentoIdentificacion());
        assertEquals("Test", especialista.getNombres());
        assertEquals("Test", especialista.getApellidos());
        assertEquals(fechaNacimiento, especialista.getFechaNacimiento());
        assertTrue(especialista.isEstado());
    }

    @Test
    @DisplayName("Deberia lanzar una excepción de que debe ingresar el documento de identidad del especialista")
    void deberiaFallarSinDocumentoIdentidadDelEspecialista() {
        //Preparación
        LocalDate fechaNacimiento = LocalDate.of(1990, 8, 4);

        // Ejecución
        EspecialistaTestDataBuilder especialistaTestDataBuilder = new EspecialistaTestDataBuilder()
                .conId(1L)
                .conDocumentoIdentificacion(null);

        // Assert
        BasePrueba.assertThrows((BasePrueba.Thunk) especialistaTestDataBuilder::build,
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_DOCUMENTO_IDENTIFICACION);

    }

    @Test
    @DisplayName("Deberia lanzar una excepción de que debe ingresar los nombres del especialista")
    void deberiaFallarSinNombresDelEspecialista() {
        //Preparación
        LocalDate fechaNacimiento = LocalDate.of(1990, 8, 4);

        // Ejecución
        EspecialistaTestDataBuilder especialistaTestDataBuilder = new EspecialistaTestDataBuilder()
                .conId(1L)
                .conDocumentoIdentificacion("12345678")
                .conNombres(null);

        // Assert
        BasePrueba.assertThrows((BasePrueba.Thunk) especialistaTestDataBuilder::build,
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LOS_NOMBRES);

    }

    @Test
    @DisplayName("Deberia lanzar una excepción de que debe ingresar los apellidos del especialista")
    void deberiaFallarSinApellidosDelEspecialista() {
        //Preparación
        LocalDate fechaNacimiento = LocalDate.of(1990, 8, 4);

        // Ejecución
        EspecialistaTestDataBuilder especialistaTestDataBuilder = new EspecialistaTestDataBuilder()
                .conId(1L)
                .conDocumentoIdentificacion("12345678")
                .conNombres("Test")
                .conApellidos(null);

        // Assert
        BasePrueba.assertThrows((BasePrueba.Thunk) especialistaTestDataBuilder::build,
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LOS_APELLIDOS);

    }

    @Test
    @DisplayName("Deberia lanzar una excepción de que debe ingresar la fecha de nacimiento del especialista")
    void deberiaFallarSinFechaDeNacimientoDelEspecialista() {
        //Preparación

        // Ejecución
        EspecialistaTestDataBuilder especialistaTestDataBuilder = new EspecialistaTestDataBuilder()
                .conId(1L)
                .conDocumentoIdentificacion("12345678")
                .conNombres("Test")
                .conApellidos("Test")
                .conFechaNacimiento(null);

        // Assert
        BasePrueba.assertThrows((BasePrueba.Thunk) especialistaTestDataBuilder::build,
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO);

    }

}