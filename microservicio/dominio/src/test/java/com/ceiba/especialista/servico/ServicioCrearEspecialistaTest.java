package com.ceiba.especialista.servico;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.especialista.servico.testdatabuilder.EspecialistaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearEspecialistaTest {
    private static final String EL_ESPECIALISTA_YA_EXISTE_EN_EL_SISTEMA = "El especialista ya existe en el sistema";

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Especialista")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelEspecialista() {
        // arrange
        Especialista usuario = new EspecialistaTestDataBuilder().build();
        RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
        Mockito.when(repositorioEspecialista.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearEspecialista servicioCrearEspecialista = new ServicioCrearEspecialista(repositorioEspecialista);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearEspecialista.ejecutar(usuario), ExcepcionDuplicidad.class,
                EL_ESPECIALISTA_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    @DisplayName("Deberia Crear el especialista de manera correcta")
    void deberiaCrearElEspecialistaDeManeraCorrecta() {
        // arrange
        Especialista usuario = new EspecialistaTestDataBuilder().build();
        RepositorioEspecialista repositorioEspecialista = Mockito.mock(RepositorioEspecialista.class);
        Mockito.when(repositorioEspecialista.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioEspecialista.crear(usuario)).thenReturn(10L);
        ServicioCrearEspecialista servicioCrearEspecialista = new ServicioCrearEspecialista(repositorioEspecialista);
        // act
        Long idEspecialista = servicioCrearEspecialista.ejecutar(usuario);
        //- assert
        assertEquals(10L, idEspecialista);
        Mockito.verify(repositorioEspecialista, Mockito.times(1)).crear(usuario);
    }
}