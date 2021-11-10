package com.ceiba.terapia_detalle.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.festividad.puerto.repositorio.RepositorioFestividad;
import com.ceiba.terapia_detalle.modelo.entidad.TerapiaDetalle;
import com.ceiba.terapia_detalle.puerto.repositorio.RepositorioTerapiaDetalle;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ServicioCrearTerapiaDetalle {
    private final String DIA_NO_PERMITIDOS = "Día no permitido, ingrese solo dias de lunes a viernes";
    private final String DIA_FESTIVO = "Los días festivos no esta permitido programar sesiones, para la fecha ";
    private final String MAXIMA_FECHA_PARA_AGREGAR_SESSION = "Las sesiones de la terapia solo pueden registrarse con 45 días calendario de anticipación.";

    private final RepositorioTerapiaDetalle repositorioTerapiaDetalle;
    private final RepositorioFestividad repositorioFestividad;

    public ServicioCrearTerapiaDetalle(RepositorioTerapiaDetalle repositorioTerapiaDetalle, RepositorioFestividad repositorioFestividad) {
        this.repositorioTerapiaDetalle = repositorioTerapiaDetalle;
        this.repositorioFestividad = repositorioFestividad;
    }

    public Long ejecutar(TerapiaDetalle terapiaDetalle) {
        ValidarFechaMaximaPermitida(terapiaDetalle.getFechaHora().toLocalDate());
        ValidarFechaDiasHabiles(terapiaDetalle.getFechaHora().toLocalDate());
        return this.repositorioTerapiaDetalle.crear(terapiaDetalle);
    }

    private void ValidarFechaMaximaPermitida(LocalDate fechaSession) {
        if (fechaSession.isAfter(LocalDate.now().plusDays(45))) {
            throw new ExcepcionValorInvalido(MAXIMA_FECHA_PARA_AGREGAR_SESSION);
        }
    }

    private void ValidarFechaDiasHabiles(LocalDate fechaSession) {
        ValidarFechaFinDeSemana(fechaSession.getDayOfWeek());
        ValidarFechaFestiva(fechaSession);
    }


    private void ValidarFechaFinDeSemana(DayOfWeek dayOfWeek) {
        if (dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            throw new ExcepcionValorInvalido(DIA_NO_PERMITIDOS);
        }
    }

    private void ValidarFechaFestiva(LocalDate fechaSession) {
        if (repositorioFestividad.existe(fechaSession)) {
            throw new ExcepcionValorInvalido(DIA_FESTIVO.concat(fechaSession.toString()));
        }
    }

}
