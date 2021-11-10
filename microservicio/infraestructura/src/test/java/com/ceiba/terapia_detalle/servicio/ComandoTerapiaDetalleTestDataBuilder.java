package com.ceiba.terapia_detalle.servicio;

import com.ceiba.terapia_detalle.comando.ComandoTerapiaDetalle;

import java.time.LocalDateTime;

public class ComandoTerapiaDetalleTestDataBuilder {
    private Long id;
    private Long terapiaId;
    private LocalDateTime fechaHora;

    public ComandoTerapiaDetalleTestDataBuilder() {
        id = 1L;
        terapiaId = 1L;
        fechaHora = LocalDateTime.now();
    }

    public ComandoTerapiaDetalleTestDataBuilder conFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
        return this;
    }


    public ComandoTerapiaDetalle build() {
        return new ComandoTerapiaDetalle(id, terapiaId, fechaHora);
    }
}
