package com.ceiba.especialista.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Especialista {
    private static final String SE_DEBE_INGRESAR_EL_DOCUMENTO_IDENTIFICACION = "Se deben ingresar el documento de identificación";
    private static final String SE_DEBE_INGRESAR_LOS_NOMBRES = "Se deben ingresar los nombres";
    private static final String SE_DEBE_INGRESAR_LOS_APELLIDOS = "Se deben ingresar los apellidos";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO = "Se debe ingresar la fecha de nacimiento";

    private Long id;
    private String documentoIdentificacion;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private boolean estado;

    public Especialista(Long id, String documentoIdentificacion, String nombres, String apellidos, LocalDate fechaNacimiento, boolean estado) {
        validarObligatorio(documentoIdentificacion, SE_DEBE_INGRESAR_EL_DOCUMENTO_IDENTIFICACION);
        validarObligatorio(nombres, SE_DEBE_INGRESAR_LOS_NOMBRES);
        validarObligatorio(apellidos, SE_DEBE_INGRESAR_LOS_APELLIDOS);
        validarObligatorio(fechaNacimiento, SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO);

        this.id = id;
        this.documentoIdentificacion = documentoIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }
}
