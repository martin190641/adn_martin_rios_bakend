package com.ceiba.especialista.comando.manejador;

import com.ceiba.especialista.comando.ComandoEspecialista;
import com.ceiba.especialista.comando.fabrica.FabricaEspecialista;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.servico.ServicioActualizarEspecialista;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarEspecialista {
    private final FabricaEspecialista fabricaEspecialista;
    private final ServicioActualizarEspecialista servicioActualizarEspecialista;

    public ManejadorActualizarEspecialista(FabricaEspecialista fabricaEspecialista, ServicioActualizarEspecialista servicioActualizarEspecialista) {
        this.fabricaEspecialista = fabricaEspecialista;
        this.servicioActualizarEspecialista = servicioActualizarEspecialista;
    }

    public void ejecutar(ComandoEspecialista comandoEspecialista) {
        Especialista paciente = this.fabricaEspecialista.crear(comandoEspecialista);
        this.servicioActualizarEspecialista.ejecutar(paciente);
    }
}
