package com.ceiba.especialista.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.especialista.comando.ComandoEspecialista;
import com.ceiba.especialista.comando.manejador.ManejadorActualizarEspecialista;
import com.ceiba.especialista.comando.manejador.ManejadorCrearEspecialista;
import com.ceiba.especialista.comando.manejador.ManejadorEliminarEspecialista;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/especialistas")
@Api(tags = {"Controlador comando especialista"})
public class ComandoControladorEspecialista {
    private final ManejadorCrearEspecialista manejadorCrearEspecialista;
    private final ManejadorEliminarEspecialista manejadorEliminarEspecialista;
    private final ManejadorActualizarEspecialista manejadorActualizarEspecialista;

    @Autowired
    public ComandoControladorEspecialista(ManejadorCrearEspecialista manejadorCrearEspecialista,
                                          ManejadorEliminarEspecialista manejadorEliminarEspecialista,
                                          ManejadorActualizarEspecialista manejadorActualizarEspecialista) {
        this.manejadorCrearEspecialista = manejadorCrearEspecialista;
        this.manejadorEliminarEspecialista = manejadorEliminarEspecialista;
        this.manejadorActualizarEspecialista = manejadorActualizarEspecialista;
    }

    @PostMapping
    @ApiOperation("Crear Especialista")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEspecialista comandoEspecialista) {
        return manejadorCrearEspecialista.ejecutar(comandoEspecialista);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Especialista")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarEspecialista.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Especialista")
    public void actualizar(@RequestBody ComandoEspecialista comandoEspecialista, @PathVariable Long id) {
        comandoEspecialista.setId(id);
        manejadorActualizarEspecialista.ejecutar(comandoEspecialista);
    }
}
