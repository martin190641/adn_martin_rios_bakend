package com.ceiba.paciente.controlador;

import com.ceiba.paciente.consulta.ManejadorListarPacientePorDocumento;
import com.ceiba.paciente.consulta.ManejadorListarPacientes;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@Api(tags = {"Controlador consulta paciente"})
public class ConsultaControladorPaciente {
    private final ManejadorListarPacientes manejadorListarPacientes;
    private final ManejadorListarPacientePorDocumento manejadorListarPacientePorDocumento;

    public ConsultaControladorPaciente(ManejadorListarPacientes manejadorListarPacientes,
                                       ManejadorListarPacientePorDocumento manejadorListarPacientePorDocumento) {
        this.manejadorListarPacientes = manejadorListarPacientes;
        this.manejadorListarPacientePorDocumento = manejadorListarPacientePorDocumento;
    }

    @GetMapping
    @ApiOperation("Listar Pacientes")
    public List<DtoPaciente> listar() {
        return this.manejadorListarPacientes.ejecutar();
    }

    @GetMapping("/{documentoIdentificacion}")
    @ApiOperation("Listar Paciente por Documento")
    public DtoPaciente listarPorDocumentoIdentificacion(@PathVariable String documentoIdentificacion) {
        return this.manejadorListarPacientePorDocumento.ejecutar(documentoIdentificacion);
    }

}
