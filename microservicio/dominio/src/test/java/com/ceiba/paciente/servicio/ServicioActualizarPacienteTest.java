package com.ceiba.paciente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.paciente.servicio.testdatabuilder.PacienteTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarPacienteTest {
    private static final String EL_PACIENTE_NO_EXISTE_EN_EL_SISTEMA = "El paciente no existe en el sistema";

    @Test
    @DisplayName("Deberia validar la existencia previa del paciente")
    void deberiaValidarLaExistenciaPreviaDelPaciente() {
        // Preparación
        Paciente paciente = new PacienteTestDataBuilder().conId(1L).build();
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioPaciente.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarPaciente servicioActualizarPaciente = new ServicioActualizarPaciente(repositorioPaciente);

        //act -assert
        BasePrueba.assertThrows(() -> servicioActualizarPaciente.ejecutar(paciente), ExcepcionDuplicidad.class,
                EL_PACIENTE_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // Preparación
        Paciente paciente = new PacienteTestDataBuilder().conId(1L).build();
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioPaciente.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarPaciente servicioActualizarPaciente = new ServicioActualizarPaciente(repositorioPaciente);
        // Procesar
        servicioActualizarPaciente.ejecutar(paciente);

        // Assert
        Mockito.verify(repositorioPaciente, Mockito.times(1)).actualizar(paciente);
    }

}