package com.ceiba.terapia.controlador;

import com.ceiba.terapia.consulta.ManejadorListarTerapiasPorPaciente;
import com.ceiba.terapia.modelo.dto.DtoTerapiaPorPaciente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/terapias")
@Api(tags = {"Controlador consulta terapias"})
public class ConsultaControladorTerapia {
    private final ManejadorListarTerapiasPorPaciente manejadorListarTerapiasPorPacienteId;

    public ConsultaControladorTerapia(ManejadorListarTerapiasPorPaciente manejadorListarTerapiasPorPacienteId) {
        this.manejadorListarTerapiasPorPacienteId = manejadorListarTerapiasPorPacienteId;
    }

    @GetMapping(value = "/{pacienteId}")
    @ApiOperation("Listar tarapias por paciente id")
    public List<DtoTerapiaPorPaciente> listarTerapiasPorPacienteId(@PathVariable Long pacienteId) {
        return this.manejadorListarTerapiasPorPacienteId.ejecutar(pacienteId);
    }
}
