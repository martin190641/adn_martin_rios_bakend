package com.ceiba.terapia.comando.fabrica;

import com.ceiba.terapia.comando.ComandoTerapia;
import com.ceiba.terapia.modelo.entidad.Terapia;
import org.springframework.stereotype.Component;

@Component
public class FabricaTerapia {
    public Terapia crear(ComandoTerapia comandoTerapia) {
        return new Terapia(comandoTerapia.getId(),
                comandoTerapia.getPacienteId(),
                comandoTerapia.getTipoServicioId(),
                comandoTerapia.getEspecialistaId(),
                comandoTerapia.getFechaTerapia(),
                comandoTerapia.getDescuento(),
                comandoTerapia.getValorNeto(),
                comandoTerapia.getValorTotal());
    }
}
