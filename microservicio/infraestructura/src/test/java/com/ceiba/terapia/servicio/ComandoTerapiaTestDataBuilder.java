package com.ceiba.terapia.servicio;

import com.ceiba.terapia.comando.ComandoTerapia;
import com.ceiba.terapia_detalle.comando.ComandoTerapiaDetalle;
import java.time.LocalDate;
import java.util.List;


public class ComandoTerapiaTestDataBuilder {
    private Long id;
    private Long pacienteId;
    private Long tipoServicioId;
    private Long especialistaId;
    private LocalDate fechaTerapia;
    private double descuento;
    private double valorNeto;
    private double valorTotal;
    private List<ComandoTerapiaDetalle> terapiaDetalles;

    public ComandoTerapiaTestDataBuilder() {
        this.id = 1L;
        this.pacienteId = 1L;
        this.tipoServicioId = 1L;
        this.especialistaId = 1L;
        fechaTerapia = LocalDate.now();
        this.descuento = 0;
        this.valorNeto = 150000;
        this.valorTotal = 150000;
        this.terapiaDetalles = null;
    }

    public ComandoTerapiaTestDataBuilder conTerapiaDetalle(List<ComandoTerapiaDetalle> comandoTerapiaDetalles) {
        this.terapiaDetalles = comandoTerapiaDetalles;
        return this;
    }

    public ComandoTerapia build() {
        return new ComandoTerapia(id, pacienteId, tipoServicioId, especialistaId, fechaTerapia, descuento, valorNeto, valorTotal,
                terapiaDetalles);
    }
}
