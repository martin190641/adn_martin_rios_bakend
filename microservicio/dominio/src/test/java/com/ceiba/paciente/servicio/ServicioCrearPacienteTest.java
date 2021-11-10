package com.ceiba.paciente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.paciente.servicio.testdatabuilder.PacienteTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearPacienteTest {

    private static final String EL_PACIENTE_YA_EXISTE_EN_EL_SISTEMA = "El paciente ya existe en el sistema";

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Paciente")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelPaciente() {
        // arrange
        Paciente usuario = new PacienteTestDataBuilder().build();
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioPaciente.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearPaciente servicioCrearPaciente = new ServicioCrearPaciente(repositorioPaciente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPaciente.ejecutar(usuario), ExcepcionDuplicidad.class,
                EL_PACIENTE_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    @DisplayName("Deberia Crear el paciente de manera correcta")
    void deberiaCrearElPacienteDeManeraCorrecta() {
        // arrange
        Paciente usuario = new PacienteTestDataBuilder().build();
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioPaciente.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioPaciente.crear(usuario)).thenReturn(10L);
        ServicioCrearPaciente servicioCrearPaciente = new ServicioCrearPaciente(repositorioPaciente);
        // act
        Long idPaciente = servicioCrearPaciente.ejecutar(usuario);
        //- assert
        assertEquals(10L, idPaciente);
        Mockito.verify(repositorioPaciente, Mockito.times(1)).crear(usuario);
    }
}
