package com.ceiba.especialista.servico.testdatabuilder;


import com.ceiba.especialista.modelo.entidad.Especialista;

import java.time.LocalDate;

public class EspecialistaTestDataBuilder {
    private Long id;
    private String documentoIdentificacion;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private boolean estado;

    public EspecialistaTestDataBuilder() {
        id = 1L;
        documentoIdentificacion = "1122334455";
        nombres = "Juanito";
        apellidos = "Perez";
        fechaNacimiento = LocalDate.of(1990, 8, 4);
        estado = true;
    }

    public EspecialistaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public EspecialistaTestDataBuilder conDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
        return this;
    }

    public EspecialistaTestDataBuilder conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public EspecialistaTestDataBuilder conApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public EspecialistaTestDataBuilder conFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public EspecialistaTestDataBuilder conEstado(boolean estado) {
        this.estado = estado;
        return this;
    }

    public Especialista build() {
        return new Especialista(id, documentoIdentificacion, nombres, apellidos, fechaNacimiento, estado);
    }
}
