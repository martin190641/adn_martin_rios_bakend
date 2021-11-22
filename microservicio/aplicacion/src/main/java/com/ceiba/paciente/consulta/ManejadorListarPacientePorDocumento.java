package com.ceiba.paciente.consulta;

import com.ceiba.paciente.modelo.dto.DtoPaciente;
import com.ceiba.paciente.puerto.dao.DaoPaciente;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ManejadorListarPacientePorDocumento {

    private final DaoPaciente daoPaciente;

    public ManejadorListarPacientePorDocumento(DaoPaciente daoPaciente) {
        this.daoPaciente = daoPaciente;
    }

    public DtoPaciente ejecutar(String documentoIdentificacion) {
        return this.daoPaciente.listarPorDocumentoIdentificacion(documentoIdentificacion);
    }
}
