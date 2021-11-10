package com.ceiba.dominio;

import java.time.LocalDate;
import java.time.Period;

public class UtilsFecha {
    public static int getEdad(LocalDate fecha) {
        return Period.between(fecha, LocalDate.now()).getYears();
    }

    public static LocalDate getFechaIncialMesActual(LocalDate fecha) {
        return LocalDate.of(fecha.getYear(), fecha.getMonth(), 1);
    }

    public static LocalDate getFechaFinMesActual(LocalDate fecha) {
        return getFechaIncialMesActual(fecha).plusMonths(1).minusDays(1);
    }
}
