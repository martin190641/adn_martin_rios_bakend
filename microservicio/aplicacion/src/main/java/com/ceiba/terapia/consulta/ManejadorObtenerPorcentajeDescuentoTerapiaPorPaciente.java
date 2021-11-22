package com.ceiba.terapia.consulta;


import com.ceiba.ComandoRespuesta;
import com.ceiba.terapia.servicio.ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerPorcentajeDescuentoTerapiaPorPaciente {
    private final ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente servicioObtenerPorcentajeDescuentoTerapiaPorPaciente;

    public ManejadorObtenerPorcentajeDescuentoTerapiaPorPaciente(ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente servicioObtenerPorcentajeDescuentoTerapiaPorPaciente) {
        this.servicioObtenerPorcentajeDescuentoTerapiaPorPaciente = servicioObtenerPorcentajeDescuentoTerapiaPorPaciente;
    }

    public ComandoRespuesta<Double> ejecutar(Long pacienteId) {
        return new ComandoRespuesta<>(this.servicioObtenerPorcentajeDescuentoTerapiaPorPaciente.ejecutar(pacienteId));
    }
}
