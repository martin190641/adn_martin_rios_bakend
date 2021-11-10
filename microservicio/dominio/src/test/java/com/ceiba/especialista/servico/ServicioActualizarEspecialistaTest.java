package com.ceiba.especialista.servico;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.especialista.servico.testdatabuilder.EspecialistaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarEspecialistaTest {
    private static final String EL_ESPECIALISTA_NO_EXISTE_EN_EL_SISTEMA = "El especialista no existe en el sistema";

    @Test
    @DisplayName("Deberia validar la existencia previa del especialista")
    void deberiaValidarLaExistenciaPreviaDelEspecialista() {
        // Preparación
        Especialista especialista = new EspecialistaTestDataBuilder().conId(1L).build();
        RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
        Mockito.when(repositorioEspecialista.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarEspecialista servicioActualizarEspecialista = new ServicioActualizarEspecialista(repositorioEspecialista);

        //act -assert
        BasePrueba.assertThrows(() -> servicioActualizarEspecialista.ejecutar(especialista), ExcepcionDuplicidad.class,
                EL_ESPECIALISTA_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // Preparación
        Especialista especialista = new EspecialistaTestDataBuilder().conId(1L).build();
        RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
        Mockito.when(repositorioEspecialista.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarEspecialista servicioActualizarEspecialista = new ServicioActualizarEspecialista(repositorioEspecialista);
        // Procesar
        servicioActualizarEspecialista.ejecutar(especialista);

        // Assert
        Mockito.verify(repositorioEspecialista, Mockito.times(1)).actualizar(especialista);
    }

}