package com.ceiba.terapia_detalle.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.terapia_detalle.comando.ComandoTerapiaDetalle;
import com.ceiba.terapia_detalle.comando.fabrica.FabricaTerapiaDetalle;
import com.ceiba.terapia_detalle.modelo.entidad.TerapiaDetalle;
import com.ceiba.terapia_detalle.servicio.ServicioCrearTerapiaDetalle;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearTerapiaDetalle {
    private final FabricaTerapiaDetalle fabricaTerapiaDetalle;
    private final ServicioCrearTerapiaDetalle servcioCrearTerapiaDetalle;

    public ManejadorCrearTerapiaDetalle(FabricaTerapiaDetalle fabricaTerapiaDetalle, ServicioCrearTerapiaDetalle servcioCrearTerapiaDetalle) {
        this.fabricaTerapiaDetalle = fabricaTerapiaDetalle;
        this.servcioCrearTerapiaDetalle = servcioCrearTerapiaDetalle;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoTerapiaDetalle comandoTerapiaDetalle) {
        TerapiaDetalle terapiaDetalle = this.fabricaTerapiaDetalle.crear(comandoTerapiaDetalle);
        return new ComandoRespuesta<>(this.servcioCrearTerapiaDetalle.ejecutar(terapiaDetalle));
    }
}
