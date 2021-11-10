package com.ceiba.terapia_detalle.servicio.testdatabuilder;

import com.ceiba.terapia_detalle.modelo.dto.DtoTerapiaDetalle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DtoTerapiaDetalleTestDataBuilder {
    private Long id;
    private Long terapiaId;
    private LocalDateTime fechaHora;

    public DtoTerapiaDetalleTestDataBuilder() {
        this.id = 1L;
        this.terapiaId = 1L;
        this.fechaHora = LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 30, 00));
    }

    public DtoTerapiaDetalle build() {
        return new DtoTerapiaDetalle(id, terapiaId, fechaHora);
    }
}
