package com.ceiba.terapia.servicio;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.especialista.puerto.dao.DaoEspecialista;
import com.ceiba.especialista.servico.testdatabuilder.DtoEspecialistaTestDataBuilder;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import com.ceiba.paciente.puerto.dao.DaoPaciente;
import com.ceiba.paciente.servicio.testdatabuilder.DtoPacienteTestDataBuilder;
import com.ceiba.terapia.modelo.dto.DtoTerapia;
import com.ceiba.terapia.modelo.dto.DtoTerapiaPorPaciente;
import com.ceiba.terapia.puerto.dao.DaoTerapia;
import com.ceiba.terapia.servicio.testdatabuilder.DtoTerapiaPorPacienteTestDataBuilder;
import com.ceiba.terapia.servicio.testdatabuilder.DtoTerapiaTestDataBuilder;
import com.ceiba.tiposervicio.modelo.dto.DtoTipoServicio;
import com.ceiba.tiposervicio.puerto.dao.DaoTipoServicio;
import com.ceiba.tiposervicio.servicio.testdatabuilder.DtoTipoServicioTestDataBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServicioListarTerapiasPorPacienteTest {

    private DaoPaciente daoPaciente;
    private DaoTipoServicio daoTipoServicio;
    private DaoEspecialista daoEspecialista;
    private DaoTerapia daoTerapia;

    @BeforeAll
    public void setUp() {
        daoTipoServicio = Mockito.mock(DaoTipoServicio.class);
        daoEspecialista = Mockito.mock(DaoEspecialista.class);
        daoTerapia = Mockito.mock(DaoTerapia.class);
        daoPaciente = Mockito.mock(DaoPaciente.class);
    }

    @Test
    @DisplayName("Debería listar las terapias de un paciente")
    void deberiaListarLasTerapiasDeUnPaciente() {
        // Preparación
        Long pacienteId = 1L;
        DtoTerapiaPorPaciente terapiaPorPaciente = new DtoTerapiaPorPacienteTestDataBuilder().build();
        DtoEspecialista especialista = new DtoEspecialistaTestDataBuilder().build();
        DtoTipoServicio tipoServicio = new DtoTipoServicioTestDataBuilder().build();
        DtoPaciente paciente = new DtoPacienteTestDataBuilder().conId(pacienteId).build();
        List<DtoTerapia> listaDtoTerapias = new ArrayList<>();
        listaDtoTerapias.add(new DtoTerapiaTestDataBuilder()
                .conId(1L)
                .conTipoServicioId(1L)
                .conEspecialistaId(1L)
                .build());
        Mockito.when(daoPaciente.
                listarPorId(paciente.getId())).thenReturn(paciente);
        Mockito.when(daoEspecialista.listarPorId(especialista.getId())).thenReturn(especialista);
        Mockito.when(daoTerapia.listarPorPaciente(pacienteId)).thenReturn(listaDtoTerapias);
        Mockito.when(daoTipoServicio.listarPorId(tipoServicio.getId())).thenReturn(tipoServicio);


        ServicioListarTerapiasPorPaciente servicioListarTerapiasPorPaciente = new ServicioListarTerapiasPorPaciente(daoPaciente, daoTipoServicio, daoEspecialista, daoTerapia);

        // Ejecución
        List<DtoTerapiaPorPaciente> dtoTerapiaPorPacientes = servicioListarTerapiasPorPaciente.ejecutar(pacienteId);

        //- assert
        assertFalse(dtoTerapiaPorPacientes.isEmpty());
    }
}