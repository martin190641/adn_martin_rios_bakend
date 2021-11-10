package com.ceiba.terapia_detalle.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoTerapiaDetalle {
    private Long id;
    private Long terapiaId;
    private LocalDateTime fechaHora;
}
