package com.ceiba.terapia.servicio;


import com.ceiba.dominio.UtilsFecha;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import com.ceiba.paciente.puerto.dao.DaoPaciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.terapia.puerto.dao.DaoTerapia;

import java.time.LocalDate;

public class ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente {
    private static final String EL_PACIENTE_NO_EXISTE = "El paciente no existe";
    private static final double PORCENTAJE_POR_EDAD = 25;
    private static final int EDAD_MAXIMA_PARA_DESCUENTO_NINO = 4;
    private static final int EDAD_MINIMA_PARA_DESCUENTO_ADULTO = 59;
    private static final int CANTIDAD_MINIMA_DE_TERAPIAS_EN_EL_MES = 2;
    private static final double PORCENTAJE_POR_CANTIDAD_DE_TERAPIAS = 15;
    private final DaoTerapia daoTerapia;
    private final DaoPaciente daoPaciente;
    private final RepositorioPaciente repositorioPaciente;
    private double porcentajeDescuento;

    public ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente(DaoTerapia daoTerapia, DaoPaciente daoPaciente, RepositorioPaciente repositorioPaciente) {
        this.daoTerapia = daoTerapia;
        this.daoPaciente = daoPaciente;
        this.repositorioPaciente = repositorioPaciente;
        this.porcentajeDescuento = 0;
    }

    public Double ejecutar(Long pacienteId) {
        validarExistenciaPreviaPaciente(pacienteId);

        obtenerDescuentosParaLaTerapia(pacienteId);


        return this.porcentajeDescuento;
    }

    private void validarExistenciaPreviaPaciente(Long pacienteId) {
        boolean existe = this.repositorioPaciente.existePorId(pacienteId);
        if (!existe) {
            throw new ExcepcionSinDatos(EL_PACIENTE_NO_EXISTE);
        }
    }

    private void obtenerDescuentosParaLaTerapia(Long pacienteId) {
        DtoPaciente dtoPaciente = daoPaciente.listarPorId(pacienteId);
        double pocentajeDescuento = 0;
        if (dtoPaciente.getEdad() <= EDAD_MAXIMA_PARA_DESCUENTO_NINO || dtoPaciente.getEdad() >= EDAD_MINIMA_PARA_DESCUENTO_ADULTO) {
            pocentajeDescuento += PORCENTAJE_POR_EDAD;
        }
        LocalDate fechaInicial = UtilsFecha.getFechaIncialMesActual(LocalDate.now());
        LocalDate fechaFinal = UtilsFecha.getFechaFinMesActual(LocalDate.now());
        Integer cantidadTepariasMes = daoTerapia.cantidadTepariasMes(pacienteId, fechaInicial, fechaFinal);
        if (cantidadTepariasMes >= CANTIDAD_MINIMA_DE_TERAPIAS_EN_EL_MES) {
            pocentajeDescuento += PORCENTAJE_POR_CANTIDAD_DE_TERAPIAS;
        }

        this.porcentajeDescuento = pocentajeDescuento;
    }
}
