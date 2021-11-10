package com.ceiba.especialista.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.especialista.comando.ComandoEspecialista;
import com.ceiba.especialista.servicio.ComandoEspecialistaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorEspecialista.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorEspecialistaTest {

    private ObjectMapper objectMapper;
    private MockMvc mocMvc;

    @Autowired
    ComandoControladorEspecialistaTest(ObjectMapper objectMapper, MockMvc mocMvc) {
        this.objectMapper = objectMapper;
        this.mocMvc = mocMvc;
    }

    @Test
    @DisplayName("Deberia crear un especialista")
    void deberiaCrearUnEspecialista() throws Exception {
        // arrange
        ComandoEspecialista especialista = new ComandoEspecialistaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/especialistas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(especialista)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia actualizar un especialista")
    void deberiaActualizarUnEspecialista() throws Exception {
        // arrange
        Long id = 1L;
        ComandoEspecialista especialista = new ComandoEspecialistaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/especialistas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(especialista)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar un especialista")
    void deberiaEliminarUnEspecialista() throws Exception {
        ComandoEspecialista especialista = new ComandoEspecialistaTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/especialistas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(especialista)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));

        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/especialistas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/especialistas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));


    }

}