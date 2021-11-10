package com.ceiba.tiposervicio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoTipoServicio {
    private Long id;
    private String nombre;
    private String descripcion;
    private double valor;
}
