package com.ceiba.terapia_detalle.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoTerapiaDetalle {
    private Long id;
    private Long terapiaId;
    private LocalDateTime fechaHora;
}
