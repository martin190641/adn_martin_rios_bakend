package com.ceiba.tiposervicio.controlador;

import com.ceiba.tiposervicio.consulta.ManejadorListarTipoServicio;
import com.ceiba.tiposervicio.modelo.dto.DtoTipoServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo_servicios")
@Api(tags = {"Controlador consulta Tipo de Servicio"})
public class ConsultaControladorTipoServicio {
    private final ManejadorListarTipoServicio manejadorListarTipoServicio;

    public ConsultaControladorTipoServicio(ManejadorListarTipoServicio manejadorListarTipoServicio) {
        this.manejadorListarTipoServicio = manejadorListarTipoServicio;
    }

    @GetMapping
    @ApiOperation("Listar Tipo de Servicio")
    public List<DtoTipoServicio> listar() {
        return this.manejadorListarTipoServicio.ejecutar();
    }
}
