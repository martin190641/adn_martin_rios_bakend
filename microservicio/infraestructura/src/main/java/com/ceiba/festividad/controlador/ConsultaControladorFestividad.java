package com.ceiba.festividad.controlador;

import com.ceiba.festividad.consulta.ManejadorListarFestividades;
import com.ceiba.festividad.modelo.dto.DtoFestividad;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/festividades")
@Api(tags = {"Controlador consulta Festividades"})
public class ConsultaControladorFestividad {
    private final ManejadorListarFestividades manejadorListarFestividades;

    public ConsultaControladorFestividad(ManejadorListarFestividades manejadorListarFestividades) {
        this.manejadorListarFestividades = manejadorListarFestividades;
    }

    @GetMapping
    @ApiOperation("Listar las festividades")
    public List<DtoFestividad> listar() {
        return this.manejadorListarFestividades.ejecutar();
    }
}
