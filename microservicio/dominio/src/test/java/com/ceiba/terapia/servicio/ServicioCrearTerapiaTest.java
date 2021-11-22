package com.ceiba.terapia.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.paciente.puerto.dao.DaoPaciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.paciente.servicio.testdatabuilder.DtoPacienteTestDataBuilder;
import com.ceiba.terapia.modelo.entidad.Terapia;
import com.ceiba.terapia.puerto.dao.DaoTerapia;
import com.ceiba.terapia.puerto.repositorio.RepositorioTerapia;
import com.ceiba.terapia.servicio.testdatabuilder.TerapiaTestDataBuilder;
import com.ceiba.tiposervicio.puerto.repositorio.RepositorioTipoServicio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServicioCrearTerapiaTest {
    private static final String EL_PACIENTE_NO_EXISTE = "El paciente no existe";
    private static final String EL_TIPO_DE_SERVICO_NO_EXISTE = "El tipo de servicio no existe";
    private static final String EL_ESPECIALISTA_NO_EXISTE = "El especialista no existe";

    private RepositorioTerapia repositorioTerapia;
    private RepositorioPaciente repositorioPaciente;
    private RepositorioEspecialista repositorioEspecialista;
    private RepositorioTipoServicio repositorioTipoServicio;
    private DaoTerapia daoTerapia;
    private DaoPaciente daoPaciente;
    private ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente servicioObtenerPorcentajeDescuentoTerapiaPorPaciente;

    @BeforeAll
    public void setUp() {
        repositorioTerapia = Mockito.mock(RepositorioTerapia.class);
        repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
        repositorioTipoServicio = Mockito.mock(RepositorioTipoServicio.class);
        daoTerapia = Mockito.mock(DaoTerapia.class);
        daoPaciente = Mockito.mock(DaoPaciente.class);
        servicioObtenerPorcentajeDescuentoTerapiaPorPaciente = Mockito.mock(ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente.class);
    }

    @Test
    @DisplayName("Debería crear Una terapia correctamente")
    void deberiaCrearUnaTerapiaCorectamente() {
        // Preparación
        Terapia terapia = new TerapiaTestDataBuilder().build();
        Mockito.when(daoPaciente.
                listarPorId(terapia.getPacienteId())).thenReturn(new DtoPacienteTestDataBuilder().build());
        Mockito.when(repositorioPaciente.existePorId(terapia.getPacienteId())).thenReturn(true);
        Mockito.when(repositorioTipoServicio.existePorId(terapia.getTipoServicioId())).thenReturn(true);
        Mockito.when(repositorioEspecialista.existePorId(terapia.getEspecialistaId())).thenReturn(true);
        Mockito.when(daoTerapia.cantidadTepariasMes(terapia.getPacienteId(), terapia.getFechaTerapia(),
                terapia.getFechaTerapia())).thenReturn(1);
        Mockito.when(repositorioTerapia.crear(terapia)).thenReturn(1L);


        ServicioCrearTerapia servicioCrearTerapia = new ServicioCrearTerapia(repositorioTerapia, repositorioPaciente,
                repositorioEspecialista, repositorioTipoServicio, servicioObtenerPorcentajeDescuentoTerapiaPorPaciente);

        // Ejecución
        Long idTerapia = servicioCrearTerapia.ejecutar(terapia);

        //- assert
        assertEquals(1L, idTerapia);
    }

    @Test
    @DisplayName("Debería lanzar una excepción al crear una terapia con paciente inexistente")
    void deberiaFallarConPacienteInexistenteAlCrearLaTerapia() {
        // Preparación
        Terapia terapia = new TerapiaTestDataBuilder().build();
        Mockito.when(daoPaciente.
                listarPorId(terapia.getPacienteId())).thenReturn(new DtoPacienteTestDataBuilder().build());
        Mockito.when(repositorioPaciente.existePorId(terapia.getPacienteId())).thenReturn(false);
        Mockito.when(repositorioTipoServicio.existePorId(terapia.getTipoServicioId())).thenReturn(true);
        Mockito.when(repositorioEspecialista.existePorId(terapia.getEspecialistaId())).thenReturn(true);
        Mockito.when(daoTerapia.cantidadTepariasMes(terapia.getPacienteId(), terapia.getFechaTerapia(),
                terapia.getFechaTerapia())).thenReturn(1);
        Mockito.when(repositorioTerapia.crear(terapia)).thenReturn(1L);


        ServicioCrearTerapia servicioCrearTerapia = new ServicioCrearTerapia(repositorioTerapia, repositorioPaciente,
                repositorioEspecialista, repositorioTipoServicio, servicioObtenerPorcentajeDescuentoTerapiaPorPaciente);

        // Ejecución - assert
        BasePrueba.assertThrows(() -> servicioCrearTerapia.ejecutar(terapia), ExcepcionSinDatos.class,
                EL_PACIENTE_NO_EXISTE);
    }

    @Test
    @DisplayName("Debería lanzar una excepción al crear una terapia tipo de servicio inexistente")
    void deberiaFallarSinTipoDeServicioInexistenteAlCrearLaTerapia() {
        // Preparación
        Terapia terapia = new TerapiaTestDataBuilder().build();
        Mockito.when(daoPaciente.
                listarPorId(terapia.getPacienteId())).thenReturn(new DtoPacienteTestDataBuilder().build());
        Mockito.when(repositorioPaciente.existePorId(terapia.getPacienteId())).thenReturn(true);
        Mockito.when(repositorioTipoServicio.existePorId(terapia.getTipoServicioId())).thenReturn(false);
        Mockito.when(repositorioEspecialista.existePorId(terapia.getEspecialistaId())).thenReturn(true);
        Mockito.when(daoTerapia.cantidadTepariasMes(terapia.getPacienteId(), terapia.getFechaTerapia(),
                terapia.getFechaTerapia())).thenReturn(1);
        Mockito.when(repositorioTerapia.crear(terapia)).thenReturn(1L);


        ServicioCrearTerapia servicioCrearTerapia = new ServicioCrearTerapia(repositorioTerapia, repositorioPaciente,
                repositorioEspecialista, repositorioTipoServicio, servicioObtenerPorcentajeDescuentoTerapiaPorPaciente);

        // Ejecución - assert
        BasePrueba.assertThrows(() -> servicioCrearTerapia.ejecutar(terapia), ExcepcionSinDatos.class,
                EL_TIPO_DE_SERVICO_NO_EXISTE);
    }

    @Test
    @DisplayName("Debería lanzar una excepción al crear una terapia sin especialista inexistente")
    void deberiaFallarConEspecialistaInexistenteAlCrearLaTerapia() {
        // Preparación
        Terapia terapia = new TerapiaTestDataBuilder().build();
        Mockito.when(daoPaciente.
                listarPorId(terapia.getPacienteId())).thenReturn(new DtoPacienteTestDataBuilder().build());
        Mockito.when(repositorioPaciente.existePorId(terapia.getPacienteId())).thenReturn(true);
        Mockito.when(repositorioTipoServicio.existePorId(terapia.getTipoServicioId())).thenReturn(true);
        Mockito.when(repositorioEspecialista.existePorId(terapia.getEspecialistaId())).thenReturn(false);
        Mockito.when(daoTerapia.cantidadTepariasMes(terapia.getPacienteId(), terapia.getFechaTerapia(),
                terapia.getFechaTerapia())).thenReturn(1);
        Mockito.when(repositorioTerapia.crear(terapia)).thenReturn(1L);


        ServicioCrearTerapia servicioCrearTerapia = new ServicioCrearTerapia(repositorioTerapia, repositorioPaciente,
                repositorioEspecialista, repositorioTipoServicio, servicioObtenerPorcentajeDescuentoTerapiaPorPaciente);

        // Ejecución - assert
        BasePrueba.assertThrows(() -> servicioCrearTerapia.ejecutar(terapia), ExcepcionSinDatos.class,
                EL_ESPECIALISTA_NO_EXISTE);
    }

}