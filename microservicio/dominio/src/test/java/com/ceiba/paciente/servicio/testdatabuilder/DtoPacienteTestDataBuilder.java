package com.ceiba.paciente.servicio.testdatabuilder;

import com.ceiba.paciente.modelo.dto.DtoPaciente;

import java.time.LocalDate;

public class DtoPacienteTestDataBuilder {
    private Long id;
    private String documentoIdentificacion;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public DtoPacienteTestDataBuilder() {
        id = 1L;
        documentoIdentificacion = "1122334455";
        nombres = "Juanito";
        apellidos = "Perez";
        fechaNacimiento = LocalDate.of(1990, 8, 4);
    }

    public DtoPacienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DtoPacienteTestDataBuilder conDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
        return this;
    }

    public DtoPacienteTestDataBuilder conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public DtoPacienteTestDataBuilder conApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public DtoPacienteTestDataBuilder conFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public DtoPaciente build() {
        return new DtoPaciente(id, documentoIdentificacion, nombres, apellidos, fechaNacimiento);
    }
}
