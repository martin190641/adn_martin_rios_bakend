package com.ceiba.terapia_detalle.comando.fabrica;

import com.ceiba.terapia_detalle.comando.ComandoTerapiaDetalle;
import com.ceiba.terapia_detalle.modelo.entidad.TerapiaDetalle;
import org.springframework.stereotype.Component;

@Component
public class FabricaTerapiaDetalle {
    public TerapiaDetalle crear(ComandoTerapiaDetalle comandoTerapiaDetalle) {
        return new TerapiaDetalle(comandoTerapiaDetalle.getId(),
                comandoTerapiaDetalle.getTerapiaId(),
                comandoTerapiaDetalle.getFechaHora());
    }
}
