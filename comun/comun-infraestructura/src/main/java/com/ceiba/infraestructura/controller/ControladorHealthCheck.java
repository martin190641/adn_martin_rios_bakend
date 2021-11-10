package com.ceiba.infraestructura.controller;

import com.ceiba.infraestructura.actuator.ManejadorHealthCheckBloques;
import com.ceiba.infraestructura.error.ErrorHealthCheck;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/healthCheck")
public class ControladorHealthCheck {

    private final ManejadorHealthCheckBloques manejadorHealthCheckBloques;

    public ControladorHealthCheck(ManejadorHealthCheckBloques manejadorHealthCheckBloques) {
        this.manejadorHealthCheckBloques = manejadorHealthCheckBloques;
    }

    @GetMapping
    public ResponseEntity<Object> healthCheck() {
        if (this.manejadorHealthCheckBloques.existenErrores()) {
            List<ErrorHealthCheck> listaErrorHealthCheck = this.manejadorHealthCheckBloques.getListadoErroresBloques();//a�adir
            return new ResponseEntity<Object>(listaErrorHealthCheck, HttpStatus.SERVICE_UNAVAILABLE);
        } else {
            return new ResponseEntity<Object>(true, HttpStatus.OK);
        }
    }
}
