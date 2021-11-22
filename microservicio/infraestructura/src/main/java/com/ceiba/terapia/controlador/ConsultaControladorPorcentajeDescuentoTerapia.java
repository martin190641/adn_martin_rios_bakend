package com.ceiba.terapia.controlador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.terapia.consulta.ManejadorObtenerPorcentajeDescuentoTerapiaPorPaciente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/terapias")
@Api(tags = {"Controlador obtener porcentaje de descuento terapia"})
public class ConsultaControladorPorcentajeDescuentoTerapia {
    private final ManejadorObtenerPorcentajeDescuentoTerapiaPorPaciente manejadorObtenerPorcentajeDescuentoTerapiaPorPaciente;

    public ConsultaControladorPorcentajeDescuentoTerapia(ManejadorObtenerPorcentajeDescuentoTerapiaPorPaciente manejadorObtenerPorcentajeDescuentoTerapiaPorPaciente) {
        this.manejadorObtenerPorcentajeDescuentoTerapiaPorPaciente = manejadorObtenerPorcentajeDescuentoTerapiaPorPaciente;
    }

    @GetMapping(value = "/descuento/{pacienteId}")
    @ApiOperation("Obtener porcentaje de descuento para la terapia por paciente id")
    public ComandoRespuesta<Double> obtenerDescuento(@PathVariable Long pacienteId) {
        return this.manejadorObtenerPorcentajeDescuentoTerapiaPorPaciente.ejecutar(pacienteId);
    }
}
