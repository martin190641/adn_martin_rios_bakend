package com.ceiba.terapia.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Terapia {
    private static final String SE_DEBE_INGRESAR_EL_PACIENTE = "Se deben ingresar el paciente";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_SERVICIO = "Se deben ingresar el tipo de servicio";
    private static final String SE_DEBE_INGRESAR_EL_ESPECIALISTA = "Se deben ingresar el especialista";

    private Long id;
    private Long pacienteId;
    private Long tipoServicioId;
    private Long especialistaId;
    private LocalDate fechaTerapia;
    private double descuento;
    private double valorNeto;
    private double valorTotal;

    public Terapia(Long id, Long pacienteId, Long tipoServicioId, Long especialistaId, LocalDate fechaTerapia, double descuento, double valorNeto, double valorTotal) {
        validarObligatorio(pacienteId, SE_DEBE_INGRESAR_EL_PACIENTE);
        validarObligatorio(tipoServicioId, SE_DEBE_INGRESAR_EL_TIPO_DE_SERVICIO);
        validarObligatorio(especialistaId, SE_DEBE_INGRESAR_EL_ESPECIALISTA);

        this.id = id;
        this.pacienteId = pacienteId;
        this.tipoServicioId = tipoServicioId;
        this.especialistaId = especialistaId;
        this.fechaTerapia = fechaTerapia;
        this.descuento = descuento;
        this.valorNeto = valorNeto;
        this.valorTotal = valorTotal;
    }

    public void reasignarValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void asignarDescuento(double descuento) {
        this.descuento = descuento;
    }
}
