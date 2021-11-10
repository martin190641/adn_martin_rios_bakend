package com.ceiba.paciente.comando.manejador;

import com.ceiba.paciente.servicio.ServicioEliminarPaciente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPaciente {
    private final ServicioEliminarPaciente servicioEliminarPaciente;

    public ManejadorEliminarPaciente(ServicioEliminarPaciente servicioEliminarPaciente) {
        this.servicioEliminarPaciente = servicioEliminarPaciente;
    }

    public void ejecutar(Long idPaciente) {
        this.servicioEliminarPaciente.ejecutar(idPaciente);
    }
}
