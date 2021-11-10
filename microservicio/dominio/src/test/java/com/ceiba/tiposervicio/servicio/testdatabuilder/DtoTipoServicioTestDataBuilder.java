package com.ceiba.tiposervicio.servicio.testdatabuilder;

import com.ceiba.tiposervicio.modelo.dto.DtoTipoServicio;

public class DtoTipoServicioTestDataBuilder {
    private Long id;
    private String nombre;
    private String descripcion;
    private double valor;

    public DtoTipoServicioTestDataBuilder() {
        id = 1L;
        nombre = "Test";
        descripcion = "Test Descripcion";
        valor = 10000.0;
    }

    public DtoTipoServicio build() {
        return new DtoTipoServicio(id, nombre, descripcion, valor);
    }
}
