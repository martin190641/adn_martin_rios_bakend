package com.ceiba.terapia.comando;

import com.ceiba.terapia_detalle.comando.ComandoTerapiaDetalle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoTerapia {
    private Long id;
    private Long pacienteId;
    private Long tipoServicioId;
    private Long especialistaId;
    private LocalDate fechaTerapia;
    private double descuento;
    private double valorNeto;
    private double valorTotal;
    private List<ComandoTerapiaDetalle> terapiaDetalles;
}
