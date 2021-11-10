package com.ceiba.festividad.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Festividad {
    private final LocalDate fechaFestiva;
    private final String descripcion;

    public Festividad(LocalDate fechaFestiva, String descripcion) {
        this.fechaFestiva = fechaFestiva;
        this.descripcion = descripcion;
    }
}
