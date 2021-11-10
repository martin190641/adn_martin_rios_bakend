package com.ceiba.terapia.consulta;

import com.ceiba.terapia.modelo.dto.DtoTerapiaPorPaciente;
import com.ceiba.terapia.servicio.ServicioListarTerapiasPorPaciente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTerapiasPorPaciente {
    private final ServicioListarTerapiasPorPaciente servicioListarTerapiasPorPaciente;

    public ManejadorListarTerapiasPorPaciente(ServicioListarTerapiasPorPaciente servicioListarTerapiasPorPaciente) {
        this.servicioListarTerapiasPorPaciente = servicioListarTerapiasPorPaciente;
    }

    public List<DtoTerapiaPorPaciente> ejecutar(Long pacienteId) {
        return this.servicioListarTerapiasPorPaciente.ejecutar(pacienteId);
    }
}
