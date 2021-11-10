package com.ceiba.terapia_detalle.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.terapia_detalle.servicio.testdatabuilder.TerapiaDetalleTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TerapiaDetalleTest {
    private final String DEBE_INGRESAR_LA_FECHA_Y_HORA = "Debe ingresar la fecha y hora de la sesion";

    @Test
    @DisplayName("Deberia crear correctamente el terapia detalle")
    void deberiaCrearCorrectamenteElTerapiaDetalle() {
        //Preparación
        LocalDateTime fechaHora = LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 30, 00));

        // Ejecución
        TerapiaDetalle terapiaDetalle = new TerapiaDetalleTestDataBuilder()
                .build();

        // Assert
        assertEquals(1L, terapiaDetalle.getId());
        assertEquals(1L, terapiaDetalle.getTerapiaId());
        assertEquals(fechaHora, terapiaDetalle.getFechaHora());
    }

    @Test
    @DisplayName("Deberia lanzar una excepción al validar la fecha hora")
    void deberiaFallarSinFechaHoraElTerapiaDetalle() {
        //Preparación
        TerapiaDetalleTestDataBuilder terapiaDetalleTestDataBuilder = new TerapiaDetalleTestDataBuilder()
                .conFechaHora(null);

        //Ejecución - Assert
        BasePrueba.assertThrows((BasePrueba.Thunk) terapiaDetalleTestDataBuilder::build,
                ExcepcionValorObligatorio.class, DEBE_INGRESAR_LA_FECHA_Y_HORA);
    }

}