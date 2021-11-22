package com.ceiba.terapia.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.UtilsFecha;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.paciente.puerto.dao.DaoPaciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.paciente.servicio.testdatabuilder.DtoPacienteTestDataBuilder;
import com.ceiba.terapia.puerto.dao.DaoTerapia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServicioObtenerPorcentajeDescuentoTerapiaPorPacienteTest {
    private static final String EL_PACIENTE_NO_EXISTE = "El paciente no existe";
    private static final double PORCENTAJE_POR_EDAD = 25;
    private static final int EDAD_MAXIMA_PARA_DESCUENTO_NINO = 4;
    private static final int EDAD_MINIMA_PARA_DESCUENTO_ADULTO = 59;
    private static final Integer CANTIDAD_MINIMA_DE_TERAPIAS_EN_EL_MES = 2;
    private static final double PORCENTAJE_POR_CANTIDAD_DE_TERAPIAS = 15;

    private RepositorioPaciente repositorioPaciente;
    private DaoTerapia daoTerapia;
    private DaoPaciente daoPaciente;
    private Long pacienteId;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    @BeforeAll
    public void setUp() {
        repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        daoTerapia = Mockito.mock(DaoTerapia.class);
        daoPaciente = Mockito.mock(DaoPaciente.class);
        pacienteId = 1L;
        fechaInicial = UtilsFecha.getFechaIncialMesActual(LocalDate.now());
        fechaFinal = UtilsFecha.getFechaFinMesActual(LocalDate.now());
    }

    @Test
    @DisplayName("Debería obtener un descuento de cero")
    void deberiaDescuentoDeCeroPorciento() {
        // Preparación
        Mockito.when(daoPaciente.
                listarPorId(this.pacienteId)).thenReturn(new DtoPacienteTestDataBuilder()
                .conFechaNacimiento(LocalDate.now().minusYears(18)).build());
        Mockito.when(repositorioPaciente.existePorId(this.pacienteId)).thenReturn(true);
        Mockito.when(daoTerapia.cantidadTepariasMes(this.pacienteId, this.fechaInicial,
               this.fechaFinal)).thenReturn(1);


        ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente servicioObtenerPorcentajeDescuentoTerapiaPorPaciente
                = new ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente(daoTerapia, daoPaciente, repositorioPaciente);

        // Ejecución
        double pocentajeDescuento = servicioObtenerPorcentajeDescuentoTerapiaPorPaciente.ejecutar(this.pacienteId);

        //- assert
        assertEquals(0, pocentajeDescuento);
    }

    @Test
    @DisplayName("Debería obtener un descuento del 25% por ser un niño menor a 5 años")
    void deberiaDescuentoDePorEdadParaNino() {
        // Preparación
        Mockito.when(daoPaciente.
                listarPorId(this.pacienteId)).thenReturn(new DtoPacienteTestDataBuilder()
                .conFechaNacimiento(LocalDate.now().minusYears(EDAD_MAXIMA_PARA_DESCUENTO_NINO)).build());
        Mockito.when(repositorioPaciente.existePorId(this.pacienteId)).thenReturn(true);
        Mockito.when(daoTerapia.cantidadTepariasMes(this.pacienteId, this.fechaInicial,
                this.fechaFinal)).thenReturn(1);


        ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente servicioObtenerPorcentajeDescuentoTerapiaPorPaciente
                = new ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente(daoTerapia, daoPaciente, repositorioPaciente);

        // Ejecución
        double pocentajeDescuento = servicioObtenerPorcentajeDescuentoTerapiaPorPaciente.ejecutar(this.pacienteId);

        //- assert
        assertEquals(PORCENTAJE_POR_EDAD, pocentajeDescuento);
    }

    @Test
    @DisplayName("Debería obtener un descuento del 25% por ser un adulto mayor a 58 años")
    void deberiaDescuentoDePorEdadParaAdultoMayorA58() {
        // Preparación
        Mockito.when(daoPaciente.
                listarPorId(this.pacienteId)).thenReturn(new DtoPacienteTestDataBuilder()
                .conFechaNacimiento(LocalDate.now().minusYears(EDAD_MINIMA_PARA_DESCUENTO_ADULTO)).build());
        Mockito.when(repositorioPaciente.existePorId(this.pacienteId)).thenReturn(true);
        Mockito.when(daoTerapia.cantidadTepariasMes(this.pacienteId, this.fechaInicial,
                this.fechaFinal)).thenReturn(1);


        ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente servicioObtenerPorcentajeDescuentoTerapiaPorPaciente
                = new ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente(daoTerapia, daoPaciente, repositorioPaciente);

        // Ejecución
        double pocentajeDescuento = servicioObtenerPorcentajeDescuentoTerapiaPorPaciente.ejecutar(this.pacienteId);

        //- assert
        assertEquals(PORCENTAJE_POR_EDAD, pocentajeDescuento);
    }

    @Test
    @DisplayName("Debería obtener un descuento del 15% por tener mas de una terapia registrada en el mes de la terapia")
    void deberiaDescuentoDePorMultiplesTerapiasEnElMes() {
        // Preparación
        daoTerapia = Mockito.mock(DaoTerapia.class);
        Mockito.when(daoPaciente.
                listarPorId(this.pacienteId)).thenReturn(new DtoPacienteTestDataBuilder()
                .conFechaNacimiento(LocalDate.now().minusYears(18)).build());
        Mockito.when(repositorioPaciente.existePorId(this.pacienteId)).thenReturn(true);
        Mockito.when(daoTerapia.cantidadTepariasMes(this.pacienteId, this.fechaInicial,
                this.fechaFinal)).thenReturn(CANTIDAD_MINIMA_DE_TERAPIAS_EN_EL_MES);


        ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente servicioObtenerPorcentajeDescuentoTerapiaPorPaciente
                = new ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente(daoTerapia, daoPaciente, repositorioPaciente);

        // Ejecución
        double pocentajeDescuento = servicioObtenerPorcentajeDescuentoTerapiaPorPaciente.ejecutar(this.pacienteId);

        //- assert
        assertEquals(PORCENTAJE_POR_CANTIDAD_DE_TERAPIAS, pocentajeDescuento);
    }
    @Test
    @DisplayName("Debería obtener un descuento del 40% por tener mas de una terapia registrada en el mes de la terapia y tiene una edad menor a 5 años")
    void deberiaDescuentoDePorMultiplesTerapiasEnElMesYPorEdadMenorA5() {
        // Preparación
        daoTerapia = Mockito.mock(DaoTerapia.class);
        Mockito.when(daoPaciente.
                listarPorId(this.pacienteId)).thenReturn(new DtoPacienteTestDataBuilder()
                .conFechaNacimiento(LocalDate.now().minusYears(EDAD_MAXIMA_PARA_DESCUENTO_NINO)).build());
        Mockito.when(repositorioPaciente.existePorId(this.pacienteId)).thenReturn(true);
        Mockito.when(daoTerapia.cantidadTepariasMes(this.pacienteId, this.fechaInicial,
                this.fechaFinal)).thenReturn(CANTIDAD_MINIMA_DE_TERAPIAS_EN_EL_MES);


        ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente servicioObtenerPorcentajeDescuentoTerapiaPorPaciente
                = new ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente(daoTerapia, daoPaciente, repositorioPaciente);

        // Ejecución
        double pocentajeDescuento = servicioObtenerPorcentajeDescuentoTerapiaPorPaciente.ejecutar(this.pacienteId);

        //- assert
        assertEquals(PORCENTAJE_POR_CANTIDAD_DE_TERAPIAS + PORCENTAJE_POR_EDAD, pocentajeDescuento);
    }

    @Test
    @DisplayName("Debería obtener un descuento del 40% por tener mas de una terapia registrada en el mes de la terapia y tiene una edad mayor a 58 años")
    void deberiaDescuentoDePorMultiplesTerapiasEnElMesYPorEdadMayorA58() {
        // Preparación
        daoTerapia = Mockito.mock(DaoTerapia.class);
        Mockito.when(daoPaciente.
                listarPorId(this.pacienteId)).thenReturn(new DtoPacienteTestDataBuilder()
                .conFechaNacimiento(LocalDate.now().minusYears(EDAD_MINIMA_PARA_DESCUENTO_ADULTO)).build());
        Mockito.when(repositorioPaciente.existePorId(this.pacienteId)).thenReturn(true);
        Mockito.when(daoTerapia.cantidadTepariasMes(this.pacienteId, this.fechaInicial,
                this.fechaFinal)).thenReturn(CANTIDAD_MINIMA_DE_TERAPIAS_EN_EL_MES);


        ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente servicioObtenerPorcentajeDescuentoTerapiaPorPaciente
                = new ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente(daoTerapia, daoPaciente, repositorioPaciente);

        // Ejecución
        double pocentajeDescuento = servicioObtenerPorcentajeDescuentoTerapiaPorPaciente.ejecutar(this.pacienteId);

        //- assert
        assertEquals(PORCENTAJE_POR_CANTIDAD_DE_TERAPIAS + PORCENTAJE_POR_EDAD, pocentajeDescuento);
    }

    @Test
    @DisplayName("Debería lanzar una excepción al obtener un porcentaje de descuento con paciente inexistente")
    void deberiaFallarConPacienteInexistenteAlObtenerPorcentajeDescuento() {
        // Preparación
        daoTerapia = Mockito.mock(DaoTerapia.class);
        Mockito.when(daoPaciente.
                listarPorId(this.pacienteId)).thenReturn(new DtoPacienteTestDataBuilder()
                .conFechaNacimiento(LocalDate.now().minusYears(EDAD_MINIMA_PARA_DESCUENTO_ADULTO)).build());
        Mockito.when(repositorioPaciente.existePorId(this.pacienteId)).thenReturn(false);
        Mockito.when(daoTerapia.cantidadTepariasMes(this.pacienteId, this.fechaInicial,
                this.fechaFinal)).thenReturn(CANTIDAD_MINIMA_DE_TERAPIAS_EN_EL_MES);


        ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente servicioObtenerPorcentajeDescuentoTerapiaPorPaciente
                = new ServicioObtenerPorcentajeDescuentoTerapiaPorPaciente(daoTerapia, daoPaciente, repositorioPaciente);

        // Ejecución - assert
        BasePrueba.assertThrows(() -> servicioObtenerPorcentajeDescuentoTerapiaPorPaciente.ejecutar(this.pacienteId), ExcepcionSinDatos.class,
                EL_PACIENTE_NO_EXISTE);
    }

}