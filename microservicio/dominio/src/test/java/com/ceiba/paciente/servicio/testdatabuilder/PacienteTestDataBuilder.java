package com.ceiba.paciente.servicio.testdatabuilder;

import com.ceiba.paciente.modelo.entidad.Paciente;

import java.time.LocalDate;

public class PacienteTestDataBuilder {
    private Long id;
    private String documentoIdentificacion;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public PacienteTestDataBuilder() {
        id = 1L;
        documentoIdentificacion = "1122334455";
        nombres = "Juanito";
        apellidos = "Perez";
        fechaNacimiento = LocalDate.of(1990, 8, 4);
    }

    public PacienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public PacienteTestDataBuilder conDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
        return this;
    }

    public PacienteTestDataBuilder conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public PacienteTestDataBuilder conApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public PacienteTestDataBuilder conFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public Paciente build() {
        return new Paciente(id, documentoIdentificacion, nombres, apellidos, fechaNacimiento);
    }
}
