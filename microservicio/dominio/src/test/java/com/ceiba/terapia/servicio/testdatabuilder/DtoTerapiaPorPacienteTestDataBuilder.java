package com.ceiba.terapia.servicio.testdatabuilder;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import com.ceiba.terapia.modelo.dto.DtoTerapiaPorPaciente;
import com.ceiba.terapia_detalle.modelo.dto.DtoTerapiaDetalle;
import com.ceiba.tiposervicio.modelo.dto.DtoTipoServicio;

import java.time.LocalDate;
import java.util.List;

public class DtoTerapiaPorPacienteTestDataBuilder {
    private Long id;
    private DtoPaciente paciente;
    private DtoTipoServicio tipoServicio;
    private DtoEspecialista especialista;
    private LocalDate fechaTerapia;
    private double descuento;
    private double valorNeto;
    private double valorTotal;
    private List<DtoTerapiaDetalle> terapiaDetalles;


    public DtoTerapiaPorPacienteTestDataBuilder() {
        id = 1L;
        fechaTerapia = LocalDate.now();
        descuento = 0;
        valorNeto = 100;
        valorTotal = 100;
    }

    public DtoTerapiaPorPacienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DtoTerapiaPorPacienteTestDataBuilder conPacienteId(DtoPaciente paciente) {
        this.paciente = paciente;
        return this;
    }

    public DtoTerapiaPorPacienteTestDataBuilder conTipoServicioId(DtoTipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
        return this;
    }

    public DtoTerapiaPorPacienteTestDataBuilder conEspecialistaId(DtoEspecialista especialista) {
        this.especialista = especialista;
        return this;
    }

    public DtoTerapiaPorPacienteTestDataBuilder conFechaTerapia(LocalDate fechaTerapia) {
        this.fechaTerapia = fechaTerapia;
        return this;
    }

    public DtoTerapiaPorPacienteTestDataBuilder conDescuento(double descuento) {
        this.descuento = descuento;
        return this;
    }

    public DtoTerapiaPorPacienteTestDataBuilder conValorNeto(double valorNeto) {
        this.valorNeto = valorNeto;
        return this;
    }

    public DtoTerapiaPorPacienteTestDataBuilder conValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public DtoTerapiaPorPaciente build() {
        return new DtoTerapiaPorPaciente(id, paciente, tipoServicio, especialista, fechaTerapia, descuento, valorNeto, valorTotal, null);
    }
}
