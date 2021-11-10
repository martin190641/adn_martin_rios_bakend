package com.ceiba.festividad.servicio.testdatabuilder;

import com.ceiba.festividad.modelo.dto.DtoFestividad;

import java.time.LocalDate;

public class DtoFestividadTestDataBuilder {
    private final LocalDate fechaFestiva;
    private final String descripcion;

    public DtoFestividadTestDataBuilder() {
        fechaFestiva = LocalDate.now();
        descripcion = "Dia Festivo";
    }

    public DtoFestividad build() {
        return new DtoFestividad(fechaFestiva, descripcion);
    }
}
