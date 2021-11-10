package com.ceiba.paciente.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPaciente {
    private Long id;
    private String documentoIdentificacion;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
}
