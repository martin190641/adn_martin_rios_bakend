package com.ceiba.especialista.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.especialista.comando.ComandoEspecialista;
import com.ceiba.especialista.comando.fabrica.FabricaEspecialista;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.servico.ServicioCrearEspecialista;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEspecialista {
    private final FabricaEspecialista fabricaEspecialista;
    private final ServicioCrearEspecialista servicioCrearEspecialista;

    public ManejadorCrearEspecialista(FabricaEspecialista fabricaEspecialista, ServicioCrearEspecialista servicioCrearEspecialista) {
        this.fabricaEspecialista = fabricaEspecialista;
        this.servicioCrearEspecialista = servicioCrearEspecialista;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEspecialista comandoEspecialista) {
        Especialista paciente = this.fabricaEspecialista.crear(comandoEspecialista);
        return new ComandoRespuesta<>(this.servicioCrearEspecialista.ejecutar(paciente));
    }
}
