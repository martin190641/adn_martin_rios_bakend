package com.ceiba.terapia_detalle.consulta;

import com.ceiba.terapia_detalle.modelo.dto.DtoTerapiaDetalle;
import com.ceiba.terapia_detalle.puerto.dao.DaoTerapiaDetalle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTerapiaDetalles {
    private final DaoTerapiaDetalle daoTerapiaDetalle;

    public ManejadorListarTerapiaDetalles(DaoTerapiaDetalle daoTerapiaDetalle) {
        this.daoTerapiaDetalle = daoTerapiaDetalle;
    }

    public List<DtoTerapiaDetalle> ejecutar(Long terapiaId) {
        return this.daoTerapiaDetalle.listarPorTerapiaId(terapiaId);
    }
}
