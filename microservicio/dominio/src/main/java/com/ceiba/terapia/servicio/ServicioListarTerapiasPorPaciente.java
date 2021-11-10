package com.ceiba.terapia.servicio;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.especialista.puerto.dao.DaoEspecialista;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import com.ceiba.paciente.puerto.dao.DaoPaciente;
import com.ceiba.terapia.modelo.dto.DtoTerapiaPorPaciente;
import com.ceiba.terapia.puerto.dao.DaoTerapia;
import com.ceiba.tiposervicio.modelo.dto.DtoTipoServicio;
import com.ceiba.tiposervicio.puerto.dao.DaoTipoServicio;

import java.util.ArrayList;
import java.util.List;

public class ServicioListarTerapiasPorPaciente {
    private final DaoPaciente daoPaciente;
    private final DaoTipoServicio daoTipoServicio;
    private final DaoEspecialista daoEspecialista;
    private final DaoTerapia daoTerapia;

    public ServicioListarTerapiasPorPaciente(DaoPaciente daoPaciente, DaoTipoServicio daoTipoServicio, DaoEspecialista daoEspecialista, DaoTerapia daoTerapia) {
        this.daoPaciente = daoPaciente;
        this.daoTipoServicio = daoTipoServicio;
        this.daoEspecialista = daoEspecialista;
        this.daoTerapia = daoTerapia;
    }

    public List<DtoTerapiaPorPaciente> ejecutar(Long pacienteId) {
        List<DtoTerapiaPorPaciente> dtoTerapiaPorPacientes = new ArrayList<>();
        DtoPaciente paciente = daoPaciente.listarPorId(pacienteId);
        this.daoTerapia.listarPorPaciente(pacienteId).forEach(dtoTerapia -> {
            DtoTipoServicio tipoServicio = daoTipoServicio.listarPorId(dtoTerapia.getTipoServicioId());
            DtoEspecialista especialista = daoEspecialista.listarPorId(dtoTerapia.getEspecialistaId());

            dtoTerapiaPorPacientes.add(new DtoTerapiaPorPaciente(dtoTerapia.getId(), paciente, tipoServicio,
                    especialista, dtoTerapia.getFechaTerapia(), dtoTerapia.getDescuento(), dtoTerapia.getValorNeto(),
                    dtoTerapia.getValorTotal(), null));

        });
        return dtoTerapiaPorPacientes;
    }
}
