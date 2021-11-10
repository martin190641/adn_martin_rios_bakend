package com.ceiba.especialista.servico;

import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarEspecialistaTest {
    @Test
    @DisplayName("Deberia eliminar el paciente llamando al repositorio")
    void deberiaEliminarElEspecialistaLlamandoAlRepositorio() {
        RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
        ServicioEliminarEspecialista servicioEliminarEspecialista = new ServicioEliminarEspecialista(repositorioEspecialista);

        servicioEliminarEspecialista.ejecutar(1L);
    }
}