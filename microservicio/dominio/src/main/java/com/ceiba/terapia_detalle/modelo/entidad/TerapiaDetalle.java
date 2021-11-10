package com.ceiba.terapia_detalle.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class TerapiaDetalle {
    private final String DEBE_INGRESAR_LA_FECHA_Y_HORA = "Debe ingresar la fecha y hora de la sesion";
    private Long id;
    private Long terapiaId;
    private LocalDateTime fechaHora;

    public TerapiaDetalle(Long id, Long terapiaId, LocalDateTime fechaHora) {
        validarObligatorio(fechaHora, DEBE_INGRESAR_LA_FECHA_Y_HORA);

        this.id = id;
        this.terapiaId = terapiaId;
        this.fechaHora = fechaHora;
    }
}
