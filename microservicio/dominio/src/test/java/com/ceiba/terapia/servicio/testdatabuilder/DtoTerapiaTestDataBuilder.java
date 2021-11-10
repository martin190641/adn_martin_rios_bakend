package com.ceiba.terapia.servicio.testdatabuilder;

import com.ceiba.terapia.modelo.dto.DtoTerapia;

import java.time.LocalDate;

public class DtoTerapiaTestDataBuilder {
    private long id;
    private long pacienteId;
    private long tipoServicioId;
    private long especialistaId;
    private LocalDate fechaTerapia;
    private double descuento;
    private double valorNeto;
    private double valorTotal;

    public DtoTerapiaTestDataBuilder() {
        id = 1L;
        pacienteId = 1L;
        tipoServicioId = 1L;
        especialistaId = 1L;
        fechaTerapia = LocalDate.now();
        descuento = 0;
        valorNeto = 100;
        valorTotal = 100;
    }

    public DtoTerapiaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DtoTerapiaTestDataBuilder conPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
        return this;
    }

    public DtoTerapiaTestDataBuilder conTipoServicioId(Long tipoServicioId) {
        this.tipoServicioId = tipoServicioId;
        return this;
    }

    public DtoTerapiaTestDataBuilder conEspecialistaId(long especialistaId) {
        this.especialistaId = especialistaId;
        return this;
    }

    public DtoTerapiaTestDataBuilder conFechaTerapia(LocalDate fechaTerapia) {
        this.fechaTerapia = fechaTerapia;
        return this;
    }

    public DtoTerapiaTestDataBuilder conDescuento(double descuento) {
        this.descuento = descuento;
        return this;
    }

    public DtoTerapiaTestDataBuilder conValorNeto(double valorNeto) {
        this.valorNeto = valorNeto;
        return this;
    }

    public DtoTerapiaTestDataBuilder conValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public DtoTerapia build() {
        return new DtoTerapia(id, pacienteId, tipoServicioId, especialistaId, fechaTerapia, descuento, valorNeto, valorTotal, null);
    }
}
