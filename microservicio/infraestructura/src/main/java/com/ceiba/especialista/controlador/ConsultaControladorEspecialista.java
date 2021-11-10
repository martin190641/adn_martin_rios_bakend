package com.ceiba.especialista.controlador;

import com.ceiba.especialista.consulta.ManejadorListarEspecialistas;
import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/especialistas")
@Api(tags = {"Controlador consulta especialistas"})
public class ConsultaControladorEspecialista {
    private final ManejadorListarEspecialistas manejadorListarEspecialistas;

    public ConsultaControladorEspecialista(ManejadorListarEspecialistas manejadorListarEspecialistas) {
        this.manejadorListarEspecialistas = manejadorListarEspecialistas;
    }

    @GetMapping
    @ApiOperation("Listar Especialistas")
    public List<DtoEspecialista> listar() {
        return this.manejadorListarEspecialistas.ejecutar();
    }
}
