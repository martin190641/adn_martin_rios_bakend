package com.ceiba.terapia.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.terapia.comando.ComandoTerapia;
import com.ceiba.terapia.comando.manejador.ManejadorCrearTerapia;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/terapias")
@Api(tags = {"Controlador comando terapia"})
public class ComandoControladorTerapia {
    private final ManejadorCrearTerapia manejadorCrearTerapia;

    @Autowired
    public ComandoControladorTerapia(ManejadorCrearTerapia manejadorCrearTerapia) {
        this.manejadorCrearTerapia = manejadorCrearTerapia;
    }

    @PostMapping
    @ApiOperation("Crear terapia")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTerapia comandoTerapia) {
        return manejadorCrearTerapia.ejecutar(comandoTerapia);
    }


}
