package com.ceiba.terapia.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.terapia.comando.ComandoTerapia;
import com.ceiba.terapia.comando.fabrica.FabricaTerapia;
import com.ceiba.terapia.modelo.entidad.Terapia;
import com.ceiba.terapia.servicio.ServicioCrearTerapia;
import com.ceiba.terapia_detalle.comando.ComandoTerapiaDetalle;
import com.ceiba.terapia_detalle.comando.fabrica.FabricaTerapiaDetalle;
import com.ceiba.terapia_detalle.servicio.ServicioCrearTerapiaDetalle;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ManejadorCrearTerapia {
    private final FabricaTerapia fabricaTerapia;
    private final ServicioCrearTerapia servicioCrearTerapia;
    private final ServicioCrearTerapiaDetalle servicioCrearTerapiaDetalle;
    private final FabricaTerapiaDetalle fabricaTerapiaDetalle;

    public ManejadorCrearTerapia(FabricaTerapia fabricaTerapia, ServicioCrearTerapia servicioCrearTerapia, ServicioCrearTerapiaDetalle servicioCrearTerapiaDetalle, FabricaTerapiaDetalle fabricaTerapiaDetalle) {
        this.fabricaTerapia = fabricaTerapia;
        this.servicioCrearTerapia = servicioCrearTerapia;
        this.servicioCrearTerapiaDetalle = servicioCrearTerapiaDetalle;
        this.fabricaTerapiaDetalle = fabricaTerapiaDetalle;
    }

    @Transactional
    public ComandoRespuesta<Long> ejecutar(ComandoTerapia comandoTerapia) {
        Terapia terapia = this.fabricaTerapia.crear(comandoTerapia);
        Long terapiaId = this.servicioCrearTerapia.ejecutar(terapia);
        guardarTerapiaDetalles(comandoTerapia.getTerapiaDetalles(), terapiaId);
        return new ComandoRespuesta<>(terapiaId);
    }

    private void guardarTerapiaDetalles(List<ComandoTerapiaDetalle> terapiaDetalles, Long terapiaId) {
        terapiaDetalles.forEach(terapiaDetalle -> {
            terapiaDetalle.setTerapiaId(terapiaId);
            this.servicioCrearTerapiaDetalle.ejecutar(fabricaTerapiaDetalle.crear(terapiaDetalle));
        });
    }
}
