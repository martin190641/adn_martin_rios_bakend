package com.ceiba.terapia_detalle.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.festividad.puerto.repositorio.RepositorioFestividad;
import com.ceiba.terapia_detalle.modelo.entidad.TerapiaDetalle;
import com.ceiba.terapia_detalle.puerto.repositorio.RepositorioTerapiaDetalle;
import com.ceiba.terapia_detalle.servicio.testdatabuilder.TerapiaDetalleTestDataBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServicioCrearTerapiaDetalleTest {
    private static final String DIA_NO_PERMITIDOS = "Día no permitido, ingrese solo dias de lunes a viernes";
    private static final String DIA_FESTIVO = "Los días festivos no esta permitido programar sesiones, para la fecha ";
    private static final String MAXIMA_FECHA_PARA_AGREGAR_SESSION = "Las sesiones de la terapia solo pueden registrarse con 45 días calendario de anticipación.";

    private RepositorioTerapiaDetalle repositorioTerapiaDetalle;
    private RepositorioFestividad repositorioFestividad;

    @BeforeAll
    public void setUp() {
        repositorioTerapiaDetalle = Mockito.mock(RepositorioTerapiaDetalle.class);
        repositorioFestividad = Mockito.mock(RepositorioFestividad.class);
    }

    @Test
    @DisplayName("Debería crear un detalle de terapia correctamente")
    void deberiaCrearUnDetalleDeTerapiaCorectamente() {
        // Preparación
        TerapiaDetalle terapiaDetalle = new TerapiaDetalleTestDataBuilder().build();
        Mockito.when(repositorioTerapiaDetalle.crear(terapiaDetalle)).thenReturn(1L);
        Mockito.when(repositorioFestividad.existe(terapiaDetalle.getFechaHora().toLocalDate())).thenReturn(false);
        ServicioCrearTerapiaDetalle servicioCrearTerapiaDetalle = new ServicioCrearTerapiaDetalle(repositorioTerapiaDetalle, repositorioFestividad);

        // Ejecución
        Long idTerapiaDetalle = servicioCrearTerapiaDetalle.ejecutar(terapiaDetalle);

        //- assert
        assertEquals(1L, idTerapiaDetalle);
    }

    @Test
    @DisplayName("Debería lanzar una excepción al crear una session de terapia un dia de fin de semana")
    void deberiaFallarConFechaHoraFinDeSemanaAlCrearLaTerapiaDetalle() {
        // Preparación
        LocalDateTime fechaFinDeSemana = LocalDateTime.now().withDayOfMonth(DayOfWeek.SATURDAY.getValue());
        TerapiaDetalle terapiaDetalle = new TerapiaDetalleTestDataBuilder().conFechaHora(fechaFinDeSemana).build();
        Mockito.when(repositorioTerapiaDetalle.crear(terapiaDetalle)).thenReturn(1L);
        Mockito.when(repositorioFestividad.existe(terapiaDetalle.getFechaHora().toLocalDate())).thenReturn(false);
        ServicioCrearTerapiaDetalle servicioCrearTerapiaDetalle = new ServicioCrearTerapiaDetalle(repositorioTerapiaDetalle, repositorioFestividad);

        // Ejecución - assert
        BasePrueba.assertThrows(() -> servicioCrearTerapiaDetalle.ejecutar(terapiaDetalle), ExcepcionValorInvalido.class,
                DIA_NO_PERMITIDOS);
    }

    @Test
    @DisplayName("Debería lanzar una excepción al crear una session de terapia en una de fecha festiva")
    void deberiaFallarConFechaFestivaAlCrearLaTerapiaDetalle() {
        // Preparación
        LocalDateTime fechaHora = LocalDateTime.now().withDayOfMonth(DayOfWeek.MONDAY.getValue());
        TerapiaDetalle terapiaDetalle = new TerapiaDetalleTestDataBuilder().conFechaHora(fechaHora).build();
        Mockito.when(repositorioTerapiaDetalle.crear(terapiaDetalle)).thenReturn(1L);
        Mockito.when(repositorioFestividad.existe(terapiaDetalle.getFechaHora().toLocalDate())).thenReturn(true);
        ServicioCrearTerapiaDetalle servicioCrearTerapiaDetalle = new ServicioCrearTerapiaDetalle(repositorioTerapiaDetalle, repositorioFestividad);

        // Ejecución - assert
        BasePrueba.assertThrows(() -> servicioCrearTerapiaDetalle.ejecutar(terapiaDetalle), ExcepcionValorInvalido.class,
                DIA_FESTIVO.concat(fechaHora.toLocalDate().toString()));
    }

    @Test
    @DisplayName("Debería lanzar una excepción al crear una session de terapia en una de fecha superiro a 45 días habiles desde la fecha actual")
    void deberiaFallarConFechaDeSesionSuperiorA45DiasHabiliesDesdeLaFechaActualAlCrearLaTerapiaDetalle() {
        // Preparación
        LocalDateTime fechaHora = LocalDateTime.now().plusDays(46);
        TerapiaDetalle terapiaDetalle = new TerapiaDetalleTestDataBuilder().conFechaHora(fechaHora).build();
        Mockito.when(repositorioTerapiaDetalle.crear(terapiaDetalle)).thenReturn(1L);
        Mockito.when(repositorioFestividad.existe(terapiaDetalle.getFechaHora().toLocalDate())).thenReturn(true);
        ServicioCrearTerapiaDetalle servicioCrearTerapiaDetalle = new ServicioCrearTerapiaDetalle(repositorioTerapiaDetalle, repositorioFestividad);

        // Ejecución - assert
        BasePrueba.assertThrows(() -> servicioCrearTerapiaDetalle.ejecutar(terapiaDetalle), ExcepcionValorInvalido.class,
                MAXIMA_FECHA_PARA_AGREGAR_SESSION);
    }
}