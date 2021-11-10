package com.ceiba.festividad.comando.fabrica;

import com.ceiba.festividad.comando.ComandoFestividad;
import com.ceiba.festividad.modelo.entidad.Festividad;
import org.springframework.stereotype.Component;

@Component
public class FabricaFestividad {
    public Festividad crear(ComandoFestividad comandoFestividad) {
        return new Festividad(comandoFestividad.getFechaFestiva(), comandoFestividad.getDescripcion());
    }
}
