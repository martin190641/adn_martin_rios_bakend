package com.ceiba.terapia.modelo.dto;

import com.ceiba.terapia_detalle.modelo.dto.DtoTerapiaDetalle;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class DtoTerapia {
    private Long id;
    private Long pacienteId;
    private Long tipoServicioId;
    private Long especialistaId;
    private LocalDate fechaTerapia;
    private double descuento;
    private double valorNeto;
    private double valorTotal;
    private List<DtoTerapiaDetalle> terapiaDetalles;
}
