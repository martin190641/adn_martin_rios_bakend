package com.ceiba.especialista.servico.testdatabuilder;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;

import java.time.LocalDate;

public class DtoEspecialistaTestDataBuilder {
    private Long id;
    private String documentoIdentificacion;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private boolean estado;

    public DtoEspecialistaTestDataBuilder() {
        id = 1L;
        documentoIdentificacion = "1122334455";
        nombres = "Juanito";
        apellidos = "Perez";
        fechaNacimiento = LocalDate.of(1990, 8, 4);
        estado = true;
    }

    public DtoEspecialistaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DtoEspecialistaTestDataBuilder conDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
        return this;
    }

    public DtoEspecialistaTestDataBuilder conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public DtoEspecialistaTestDataBuilder conApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public DtoEspecialistaTestDataBuilder conFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public DtoEspecialistaTestDataBuilder conEstado(boolean estado) {
        this.estado = estado;
        return this;
    }

    public DtoEspecialista build() {
        return new DtoEspecialista(id, documentoIdentificacion, nombres, apellidos, fechaNacimiento, estado);
    }
}
