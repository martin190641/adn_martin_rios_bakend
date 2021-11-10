package com.ceiba.terapia.modelo.dto;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import com.ceiba.terapia_detalle.modelo.dto.DtoTerapiaDetalle;
import com.ceiba.tiposervicio.modelo.dto.DtoTipoServicio;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class DtoTerapiaPorPaciente {
    private Long id;
    private DtoPaciente paciente;
    private DtoTipoServicio tipoServicio;
    private DtoEspecialista especialista;
    private LocalDate fechaTerapia;
    private double descuento;
    private double valorNeto;
    private double valorTotal;
    private List<DtoTerapiaDetalle> terapiaDetalles;
}
