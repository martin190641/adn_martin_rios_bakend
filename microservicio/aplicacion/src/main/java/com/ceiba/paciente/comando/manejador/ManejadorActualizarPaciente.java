package com.ceiba.paciente.comando.manejador;

import com.ceiba.paciente.comando.ComandoPaciente;
import com.ceiba.paciente.comando.fabrica.FabricaPaciente;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.servicio.ServicioActualizarPaciente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPaciente {
    private final FabricaPaciente fabricaPaciente;
    private final ServicioActualizarPaciente servicioActualizarPaciente;

    public ManejadorActualizarPaciente(FabricaPaciente fabricaPaciente, ServicioActualizarPaciente servicioActualizarPaciente) {
        this.fabricaPaciente = fabricaPaciente;
        this.servicioActualizarPaciente = servicioActualizarPaciente;
    }

    public void ejecutar(ComandoPaciente comandoPaciente) {
        Paciente paciente = this.fabricaPaciente.crear(comandoPaciente);
        this.servicioActualizarPaciente.ejecutar(paciente);
    }
}
