package com.ceiba.especialista.comando.manejador;

import com.ceiba.especialista.servico.ServicioEliminarEspecialista;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarEspecialista {
    private final ServicioEliminarEspecialista servicioEliminarEspecialista;

    public ManejadorEliminarEspecialista(ServicioEliminarEspecialista servicioEliminarEspecialista) {
        this.servicioEliminarEspecialista = servicioEliminarEspecialista;
    }

    public void ejecutar(Long idEspecialista) {
        this.servicioEliminarEspecialista.ejecutar(idEspecialista);
    }
}
