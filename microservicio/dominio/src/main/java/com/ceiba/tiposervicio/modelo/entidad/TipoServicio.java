package com.ceiba.tiposervicio.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TipoServicio {
    private Long id;
    private String nombre;
    private String descripcion;
    private double valor;

}
