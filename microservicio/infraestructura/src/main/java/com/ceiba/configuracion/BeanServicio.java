package com.ceiba.configuracion;

import com.ceiba.especialista.puerto.dao.DaoEspecialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.especialista.servico.ServicioActualizarEspecialista;
import com.ceiba.especialista.servico.ServicioCrearEspecialista;
import com.ceiba.especialista.servico.ServicioEliminarEspecialista;
import com.ceiba.festividad.puerto.repositorio.RepositorioFestividad;
import com.ceiba.paciente.puerto.dao.DaoPaciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.paciente.servicio.ServicioActualizarPaciente;
import com.ceiba.paciente.servicio.ServicioCrearPaciente;
import com.ceiba.paciente.servicio.ServicioEliminarPaciente;
import com.ceiba.terapia.puerto.dao.DaoTerapia;
import com.ceiba.terapia.puerto.repositorio.RepositorioTerapia;
import com.ceiba.terapia.servicio.ServicioCrearTerapia;
import com.ceiba.terapia.servicio.ServicioListarTerapiasPorPaciente;
import com.ceiba.terapia.servicio.ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente;
import com.ceiba.terapia_detalle.puerto.repositorio.RepositorioTerapiaDetalle;
import com.ceiba.terapia_detalle.servicio.ServicioCrearTerapiaDetalle;
import com.ceiba.tiposervicio.puerto.dao.DaoTipoServicio;
import com.ceiba.tiposervicio.puerto.repositorio.RepositorioTipoServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearPaciente servicioCrearPaciente(RepositorioPaciente repositorioPaciente) {
        return new ServicioCrearPaciente(repositorioPaciente);
    }

    @Bean
    public ServicioEliminarPaciente servicioEliminarPaciente(RepositorioPaciente repositorioPaciente) {
        return new ServicioEliminarPaciente(repositorioPaciente);
    }

    @Bean
    public ServicioActualizarPaciente servicioActualizarPaciente(RepositorioPaciente repositorioPaciente) {
        return new ServicioActualizarPaciente(repositorioPaciente);
    }

    @Bean
    public ServicioCrearEspecialista servicioCrearEspecialista(RepositorioEspecialista repositorioEspecialista) {
        return new ServicioCrearEspecialista(repositorioEspecialista);
    }

    @Bean
    public ServicioEliminarEspecialista servicioEliminarEspecialista(RepositorioEspecialista repositorioEspecialista) {
        return new ServicioEliminarEspecialista(repositorioEspecialista);
    }

    @Bean
    public ServicioActualizarEspecialista servicioActualizarEspecialista(
            RepositorioEspecialista repositorioEspecialista) {
        return new ServicioActualizarEspecialista(repositorioEspecialista);
    }

    @Bean
    public ServicioCrearTerapia servicioCrearTerapia(RepositorioTerapia repositorioTerapia,
                                                     RepositorioPaciente repositorioPaciente,
                                                     RepositorioEspecialista repositorioEspecialista,
                                                     RepositorioTipoServicio repositorioTipoServicio,
                                                     ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente
                                                             servicioObtenerPorcentajeDescuentoTerapiaPorPaciente) {
        return new ServicioCrearTerapia(repositorioTerapia, repositorioPaciente, repositorioEspecialista,
                repositorioTipoServicio, servicioObtenerPorcentajeDescuentoTerapiaPorPaciente);
    }

    @Bean
    public ServicioCrearTerapiaDetalle servicioCrearTerapiaDetalle(RepositorioTerapiaDetalle repositorioTerapiaDetalle,
                                                                   RepositorioFestividad repositorioFestividad) {
        return new ServicioCrearTerapiaDetalle(repositorioTerapiaDetalle, repositorioFestividad);
    }

    @Bean
    public ServicioListarTerapiasPorPaciente servicioListarTerapiasPorPaciente(DaoPaciente daoPaciente,
                                                                               DaoTipoServicio daoTipoServicio,
                                                                               DaoEspecialista daoEspecialista,
                                                                               DaoTerapia daoTerapia) {
        return new ServicioListarTerapiasPorPaciente(daoPaciente, daoTipoServicio, daoEspecialista, daoTerapia);
    }

    @Bean
    public ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente servicioObtenerPorcentajeDescuentoTerapiaPorPaciente(
            DaoTerapia daoTerapia, DaoPaciente daoPaciente, RepositorioPaciente repositorioPaciente) {
        return new ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente(daoTerapia, daoPaciente, repositorioPaciente);
    }
}
