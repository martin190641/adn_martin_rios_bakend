package com.ceiba.festividad.servicio.testdatabuilder;


import com.ceiba.festividad.modelo.entidad.Festividad;

import java.time.LocalDate;

public class FestividadTestDataBuilder {
    private final LocalDate fechaFestiva;
    private final String descripcion;

    public FestividadTestDataBuilder() {
        fechaFestiva = LocalDate.now();
        descripcion = "Dia Festivo";
    }


    public Festividad build() {
        return new Festividad(fechaFestiva, descripcion);
    }
}
