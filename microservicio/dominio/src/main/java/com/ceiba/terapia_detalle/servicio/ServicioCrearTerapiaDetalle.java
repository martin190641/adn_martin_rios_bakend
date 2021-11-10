package com.ceiba.terapia_detalle.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.festividad.puerto.repositorio.RepositorioFestividad;
import com.ceiba.terapia_detalle.modelo.entidad.TerapiaDetalle;
import com.ceiba.terapia_detalle.puerto.repositorio.RepositorioTerapiaDetalle;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ServicioCrearTerapiaDetalle {
    private static final String DIA_NO_PERMITIDOS = "Día no permitido, ingrese solo dias de lunes a viernes";
    private static final String DIA_FESTIVO = "Los días festivos no esta permitido programar sesiones, para la fecha ";
    private static final String MAXIMA_FECHA_PARA_AGREGAR_SESSION = "Las sesiones de la terapia solo pueden registrarse con 45 días calendario de anticipación.";

    private final RepositorioTerapiaDetalle repositorioTerapiaDetalle;
    private final RepositorioFestividad repositorioFestividad;

    public ServicioCrearTerapiaDetalle(RepositorioTerapiaDetalle repositorioTerapiaDetalle, RepositorioFestividad repositorioFestividad) {
        this.repositorioTerapiaDetalle = repositorioTerapiaDetalle;
        this.repositorioFestividad = repositorioFestividad;
    }

    public Long ejecutar(TerapiaDetalle terapiaDetalle) {
        validarFechaMaximaPermitida(terapiaDetalle.getFechaHora().toLocalDate());
        validarFechaDiasHabiles(terapiaDetalle.getFechaHora().toLocalDate());
        return this.repositorioTerapiaDetalle.crear(terapiaDetalle);
    }

    private void validarFechaMaximaPermitida(LocalDate fechaSession) {
        if (fechaSession.isAfter(LocalDate.now().plusDays(45))) {
            throw new ExcepcionValorInvalido(MAXIMA_FECHA_PARA_AGREGAR_SESSION);
        }
    }

    private void validarFechaDiasHabiles(LocalDate fechaSession) {
        validarFechaFinDeSemana(fechaSession.getDayOfWeek());
        validarFechaFestiva(fechaSession);
    }


    private void validarFechaFinDeSemana(DayOfWeek dayOfWeek) {
        if (dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            throw new ExcepcionValorInvalido(DIA_NO_PERMITIDOS);
        }
    }

    private void validarFechaFestiva(LocalDate fechaSession) {
        if (repositorioFestividad.existe(fechaSession)) {
            throw new ExcepcionValorInvalido(DIA_FESTIVO.concat(fechaSession.toString()));
        }
    }

}
