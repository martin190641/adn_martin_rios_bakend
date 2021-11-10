package com.ceiba.terapia_detalle.controlador;

import com.ceiba.terapia_detalle.consulta.ManejadorListarTerapiaDetalles;
import com.ceiba.terapia_detalle.modelo.dto.DtoTerapiaDetalle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/terapia_detalles")
@Api(tags = {"Controlador consulta terapia detalles"})
public class ConsultaControladorTerapiaDetalle {
    private final ManejadorListarTerapiaDetalles manejadorListarTerapiaDetalles;

    public ConsultaControladorTerapiaDetalle(ManejadorListarTerapiaDetalles manejadorListarTerapiaDetalles) {
        this.manejadorListarTerapiaDetalles = manejadorListarTerapiaDetalles;
    }

    @GetMapping(value = "/{terapiaId}")
    @ApiOperation("Listar tarapias por paciente id")
    public List<DtoTerapiaDetalle> listarTerapiasPorPacienteId(@PathVariable Long terapiaId) {
        return this.manejadorListarTerapiaDetalles.ejecutar(terapiaId);
    }
}
