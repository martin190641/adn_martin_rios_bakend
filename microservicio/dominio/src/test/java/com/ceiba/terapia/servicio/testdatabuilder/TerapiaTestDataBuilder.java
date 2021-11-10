package com.ceiba.terapia.servicio.testdatabuilder;

import com.ceiba.terapia.modelo.entidad.Terapia;

import java.time.LocalDate;

public class TerapiaTestDataBuilder {
    private Long id;
    private Long pacienteId;
    private Long tipoServicioId;
    private Long especialistaId;
    private LocalDate fechaTerapia;
    private double descuento;
    private double valorNeto;
    private double valorTotal;

    public TerapiaTestDataBuilder() {
        id = 1L;
        pacienteId = 1L;
        tipoServicioId = 1L;
        especialistaId = 1L;
        fechaTerapia = LocalDate.now();
        descuento = 0;
        valorNeto = 100;
        valorTotal = 100;
    }

    public TerapiaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public TerapiaTestDataBuilder conPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
        return this;
    }

    public TerapiaTestDataBuilder conTipoServicioId(Long tipoServicioId) {
        this.tipoServicioId = tipoServicioId;
        return this;
    }

    public TerapiaTestDataBuilder conEspecialistaId(Long especialistaId) {
        this.especialistaId = especialistaId;
        return this;
    }

    public TerapiaTestDataBuilder conFechaTerapia(LocalDate fechaTerapia) {
        this.fechaTerapia = fechaTerapia;
        return this;
    }

    public TerapiaTestDataBuilder conDescuento(double descuento) {
        this.descuento = descuento;
        return this;
    }

    public TerapiaTestDataBuilder conValorNeto(double valorNeto) {
        this.valorNeto = valorNeto;
        return this;
    }

    public TerapiaTestDataBuilder conValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public Terapia build() {
        return new Terapia(id, pacienteId, tipoServicioId, especialistaId, fechaTerapia, descuento, valorNeto, valorTotal);
    }
}
