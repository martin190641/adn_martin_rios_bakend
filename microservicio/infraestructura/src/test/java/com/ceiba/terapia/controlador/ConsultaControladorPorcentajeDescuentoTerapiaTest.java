package com.ceiba.terapia.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.especialista.controlador.ComandoControladorEspecialista;
import com.ceiba.paciente.comando.ComandoPaciente;
import com.ceiba.paciente.servicio.ComandoPacienteTestDataBuilder;
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

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorEspecialista.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorPorcentajeDescuentoTerapiaTest {

    private final ObjectMapper objectMapper;
    private final MockMvc mocMvc;


    @Autowired
    ConsultaControladorPorcentajeDescuentoTerapiaTest(ObjectMapper objectMapper, MockMvc mocMvc) {
        this.objectMapper = objectMapper;
        this.mocMvc = mocMvc;
    }

    @Test
    @DisplayName("Deberia realizar una consulta exitosa con status 200 al servicio")
    void deberiaRealizarUnaConsultaExitosa() throws Exception {
        // arrange
        long pacienteId = 1;

        // act - assert
        mocMvc.perform(get("/terapias/descuento/" + pacienteId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


}