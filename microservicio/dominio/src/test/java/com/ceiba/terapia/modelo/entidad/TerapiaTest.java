package com.ceiba.terapia.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.terapia.servicio.testdatabuilder.TerapiaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TerapiaTest {
    private static final String SE_DEBE_INGRESAR_EL_PACIENTE = "Se deben ingresar el paciente";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_SERVICIO = "Se deben ingresar el tipo de servicio";
    private static final String SE_DEBE_INGRESAR_EL_ESPECIALISTA = "Se deben ingresar el especialista";

    @Test
    @DisplayName("Deberia crear correctamente una terapia")
    void deberiaCrearCorrectamenteLaTerapia() {
        //Preparación -Ejecución
        LocalDate fechaActual = LocalDate.now();
        Terapia terapia = new TerapiaTestDataBuilder()
                .conId(1L)
                .conPacienteId(1L)
                .conTipoServicioId(1L)
                .conEspecialistaId(1L)
                .conFechaTerapia(fechaActual)
                .conDescuento(0)
                .conValorNeto(1000D)
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
    }

    @Test
    @DisplayName("Deberia lanzar una excepción de que debe ingresar el paciente")
    void deberiaFallarSinPacienteDeLaTerapia() {
        //Preparación
        TerapiaTestDataBuilder terapiaTestDataBuilder = new TerapiaTestDataBuilder()
                .conId(1L)
                .conPacienteId(null);

        // Ejecución - Assert
        BasePrueba.assertThrows((BasePrueba.Thunk) terapiaTestDataBuilder::build,
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_PACIENTE);

    }

    @Test
    @DisplayName("Deberia lanzar una excepción de que debe ingresar el tipo de servicio")
    void deberiaFallarSinTipoDeServicioDeLaTerapia() {
        //Preparación
        TerapiaTestDataBuilder terapiaTestDataBuilder = new TerapiaTestDataBuilder()
                .conId(1L)
                .conTipoServicioId(null);

        // Ejecución - Assert
        BasePrueba.assertThrows((BasePrueba.Thunk) terapiaTestDataBuilder::build,
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_TIPO_DE_SERVICIO);

    }

    @Test
    @DisplayName("Deberia lanzar una excepción de que debe ingresar el especialista")
    void deberiaFallarSinEspecialistaDeLaTerapia() {
        //Preparación

        TerapiaTestDataBuilder terapiaTestDataBuilder = new TerapiaTestDataBuilder()
                .conId(1L)
                .conEspecialistaId(null);

        //Ejecución - Assert
        BasePrueba.assertThrows((BasePrueba.Thunk) terapiaTestDataBuilder::build,
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_ESPECIALISTA);

    }

    @Test
    @DisplayName("Deberia reasignar el valor total de la terapia")
    void deberiaReasignarValorTotalDeLaTerapia() {
        //Preparación
        Terapia terapia = new TerapiaTestDataBuilder().build();

        //Ejecución
        terapia.reasignarValorTotal(2000);

        // Assert
        assertEquals(2000, terapia.getValorTotal());
    }

    @Test
    @DisplayName("Deberia asignar el valor del descuento de la terapia")
    void deberiaAsignarUnDescuentoDeLaTerapia() {
        //Preparación
        Terapia terapia = new TerapiaTestDataBuilder().build();

        //Ejecución
        terapia.asignarDescuento(20.0);

        // Assert
        assertEquals(20.0, terapia.getDescuento());
    }
}
