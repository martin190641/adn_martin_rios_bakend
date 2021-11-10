package com.ceiba.terapia_detalle.servicio.testdatabuilder;

import com.ceiba.terapia_detalle.modelo.entidad.TerapiaDetalle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TerapiaDetalleTestDataBuilder {
    private Long id;
    private Long terapiaId;
    private LocalDateTime fechaHora;

    public TerapiaDetalleTestDataBuilder() {
        this.id = 1L;
        this.terapiaId = 1L;
        this.fechaHora = LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 30, 00));
    }

    public TerapiaDetalleTestDataBuilder conFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
        return this;
    }

    public TerapiaDetalle build() {
        return new TerapiaDetalle(id, terapiaId, fechaHora);
    }
}
