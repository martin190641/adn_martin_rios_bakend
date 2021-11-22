package com.ceiba.terapia.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.terapia.modelo.entidad.Terapia;
import com.ceiba.terapia.puerto.repositorio.RepositorioTerapia;
import com.ceiba.tiposervicio.puerto.repositorio.RepositorioTipoServicio;

public class ServicioCrearTerapia {
    private static final String EL_PACIENTE_NO_EXISTE = "El paciente no existe";
    private static final String EL_TIPO_DE_SERVICO_NO_EXISTE = "El tipo de servicio no existe";
    private static final String EL_ESPECIALISTA_NO_EXISTE = "El especialista no existe";

    private final RepositorioTerapia repositorioTerapia;
    private final RepositorioPaciente repositorioPaciente;
    private final RepositorioEspecialista repositorioEspecialista;
    private final RepositorioTipoServicio repositorioTipoServicio;
    private final ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente servicioObtenerPorcentajeDescuentoTerapiaPorPaciente;


    public ServicioCrearTerapia(RepositorioTerapia repositorioTerapia, RepositorioPaciente repositorioPaciente,
                                RepositorioEspecialista repositorioEspecialista,
                                RepositorioTipoServicio repositorioTipoServicio,
                                ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente
                                        servicioObtenerPorcentajeDescuentoTerapiaPorPaciente) {
        this.repositorioTerapia = repositorioTerapia;
        this.repositorioPaciente = repositorioPaciente;
        this.repositorioEspecialista = repositorioEspecialista;
        this.repositorioTipoServicio = repositorioTipoServicio;
        this.servicioObtenerPorcentajeDescuentoTerapiaPorPaciente = servicioObtenerPorcentajeDescuentoTerapiaPorPaciente;
    }

    public Long ejecutar(Terapia terapia) {
        validarExistenciaPreviaPaciente(terapia.getPacienteId());
        validarExistenciaPreviaTipoServicio(terapia.getTipoServicioId());
        validarExistenciaPreviaEspecialista(terapia.getEspecialistaId());

        obtenerDescuentosParaLaTerapia(terapia);
        calcularValorTotalDeLaTerapia(terapia);

        return this.repositorioTerapia.crear(terapia);
    }

    private void calcularValorTotalDeLaTerapia(Terapia terapia) {
        double valorTotal = terapia.getValorNeto() - (terapia.getValorNeto() * terapia.getDescuento() / 100);

        terapia.reasignarValorTotal(valorTotal);
    }

    private void obtenerDescuentosParaLaTerapia(Terapia terapia) {
        terapia.asignarDescuento(servicioObtenerPorcentajeDescuentoTerapiaPorPaciente.ejecutar(terapia.getPacienteId()));
    }

    private void validarExistenciaPreviaPaciente(Long pacienteId) {
        boolean existe = this.repositorioPaciente.existePorId(pacienteId);
        if (!existe) {
            throw new ExcepcionSinDatos(EL_PACIENTE_NO_EXISTE);
        }
    }

    private void validarExistenciaPreviaTipoServicio(Long tipoServicioId) {
        boolean existe = this.repositorioTipoServicio.existePorId(tipoServicioId);
        if (!existe) {
            throw new ExcepcionSinDatos(EL_TIPO_DE_SERVICO_NO_EXISTE);
        }
    }

    private void validarExistenciaPreviaEspecialista(Long especialistaId) {
        boolean existe = this.repositorioEspecialista.existePorId(especialistaId);
        if (!existe) {
            throw new ExcepcionSinDatos(EL_ESPECIALISTA_NO_EXISTE);
        }
    }
}
