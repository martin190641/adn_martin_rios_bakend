package com.ceiba.paciente.modelo.dto;

import com.ceiba.dominio.UtilsFecha;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DtoPaciente {
    private Long id;
    private String documentoIdentificacion;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private int edad;

    public DtoPaciente(Long id, String documentoIdentificacion, String nombres, String apellidos, LocalDate fechaNacimiento) {
        this.id = id;
        this.documentoIdentificacion = documentoIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = UtilsFecha.getEdad(fechaNacimiento);
    }
}
