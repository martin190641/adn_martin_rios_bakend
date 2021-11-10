package com.ceiba.festividad.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoFestividad {
    private final LocalDate fechaFestiva;
    private final String descripcion;
}
