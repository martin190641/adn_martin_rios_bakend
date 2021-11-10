package com.ceiba.especialista.servicio;

import com.ceiba.especialista.comando.ComandoEspecialista;

import java.time.LocalDate;
import java.util.UUID;

public class ComandoEspecialistaTestDataBuilder {
    private Long id;
    private String documentoIdentificacion;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private boolean estado;

    public ComandoEspecialistaTestDataBuilder() {
        id = 1L;
        documentoIdentificacion = UUID.randomUUID().toString().substring(0, 14);
        ;
        nombres = "Juanito";
        apellidos = "Perez";
        fechaNacimiento = LocalDate.of(1990, 8, 4);
        estado = true;
    }

    public ComandoEspecialistaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoEspecialistaTestDataBuilder conDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
        return this;
    }

    public ComandoEspecialistaTestDataBuilder conNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public ComandoEspecialistaTestDataBuilder conApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public ComandoEspecialistaTestDataBuilder conFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public ComandoEspecialista build() {
        return new ComandoEspecialista(id, documentoIdentificacion, nombres, apellidos, fechaNacimiento, estado);
    }
}
