package com.ceiba.tiposervicio.servicio.testdatabuilder;

import com.ceiba.tiposervicio.modelo.entidad.TipoServicio;

public class TipoServicioTestDataBuilder {
    private Long id;
    private String nombre;
    private String descripcion;
    private double valor;

    public TipoServicioTestDataBuilder() {
        id = 1L;
        nombre = "Test";
        descripcion = "Test Descripcion";
        valor = 10000.0;
    }

    public TipoServicio build() {
        return new TipoServicio(id, nombre, descripcion, valor);
    }
}
