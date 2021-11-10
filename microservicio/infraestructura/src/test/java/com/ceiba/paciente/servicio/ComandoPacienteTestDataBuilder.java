package com.ceiba.paciente.servicio;

import com.ceiba.paciente.comando.ComandoPaciente;

import java.time.LocalDate;
import java.util.UUID;

public class ComandoPacienteTestDataBuilder {
    private Long id;
    private String documentoIdentificacion;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public ComandoPacienteTestDataBuilder() {
        id = 1L;
        documentoIdentificacion = UUID.randomUUID().toString().substring(0, 14);
        nombres = "Juanito";
        apellidos = "Perez";
        fechaNacimiento = LocalDate.of(1990, 8, 4);
    }

    public ComandoPacienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoPacienteTestDataBuilder conDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
        return this;
    }

    public ComandoPacienteTestDataBuilder conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public ComandoPacienteTestDataBuilder conApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public ComandoPacienteTestDataBuilder conFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public ComandoPaciente build() {
        return new ComandoPaciente(id, documentoIdentificacion, nombres, apellidos, fechaNacimiento);
    }
}
