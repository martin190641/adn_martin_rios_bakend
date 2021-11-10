package com.ceiba.paciente.servicio;

import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarPacienteTest {
    @Test
    @DisplayName("Deberia eliminar el paciente llamando al repositorio")
    void deberiaEliminarElPacienteLlamandoAlRepositorio() {
        RepositorioPaciente repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        ServicioEliminarPaciente servicioEliminarPaciente = new ServicioEliminarPaciente(repositorioPaciente);

        servicioEliminarPaciente.ejecutar(1L);
    }
}