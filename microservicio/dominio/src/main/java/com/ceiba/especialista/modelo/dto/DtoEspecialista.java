package com.ceiba.especialista.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoEspecialista {
    private Long id;
    private String documentoIdentificacion;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private boolean estado;
}
