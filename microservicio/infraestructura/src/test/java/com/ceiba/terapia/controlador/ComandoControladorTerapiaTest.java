package com.ceiba.terapia.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.especialista.comando.ComandoEspecialista;
import com.ceiba.especialista.controlador.ComandoControladorEspecialista;
import com.ceiba.especialista.servicio.ComandoEspecialistaTestDataBuilder;
import com.ceiba.terapia.comando.ComandoTerapia;
import com.ceiba.terapia.servicio.ComandoTerapiaTestDataBuilder;
import com.ceiba.terapia_detalle.comando.ComandoTerapiaDetalle;
import com.ceiba.terapia_detalle.servicio.ComandoTerapiaDetalleTestDataBuilder;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorEspecialista.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorTerapiaTest {
    private ObjectMapper objectMapper;
    private MockMvc mocMvc;

    @Autowired
    ComandoControladorTerapiaTest(ObjectMapper objectMapper, MockMvc mocMvc) {
        this.objectMapper = objectMapper;
        this.mocMvc = mocMvc;
    }

    @Test
    @DisplayName("Deberia crear una terapia")
    void deberiaCrearUnTerapia() throws Exception {
        // arrange
        List<ComandoTerapiaDetalle> terapiaDetalles = new ArrayList<>();

        ComandoTerapiaDetalle comandoTerapiaDetalle = new ComandoTerapiaDetalleTestDataBuilder().build();
        terapiaDetalles.add(comandoTerapiaDetalle);

        ComandoTerapia comandoTerapia = new ComandoTerapiaTestDataBuilder()
                .conTerapiaDetalle(terapiaDetalles)
                .build();
        // act - assert
        mocMvc.perform(post("/terapias")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoTerapia)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

}