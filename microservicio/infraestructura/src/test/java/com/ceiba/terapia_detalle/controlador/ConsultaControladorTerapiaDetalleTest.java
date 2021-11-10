package com.ceiba.terapia_detalle.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.especialista.controlador.ComandoControladorEspecialista;
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
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorEspecialista.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorTerapiaDetalleTest {
    private MockMvc mocMvc;

    @Autowired
    ConsultaControladorTerapiaDetalleTest(MockMvc mocMvc) {
        this.mocMvc = mocMvc;
    }

    @Test
    @DisplayName("Deberia listar el detalle de una terapia por id")
    void deberiaListarElDetalleDeUnaTerapiaPorId() throws Exception {
        // arrange
        long terapiaId = 1L;
        // act - assert
        mocMvc.perform(get("/terapia_detalles/" + terapiaId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].terapiaId", is(1)));
    }
}