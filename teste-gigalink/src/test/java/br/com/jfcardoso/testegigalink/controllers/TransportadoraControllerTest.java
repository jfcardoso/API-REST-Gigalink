package br.com.jfcardoso.testegigalink.controllers;

import br.com.jfcardoso.testegigalink.entities.Transportadora;
import br.com.jfcardoso.testegigalink.services.TransportadoraService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransportadoraController.class)
public class TransportadoraControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransportadoraService transportadoraService;

    @Test
    public void test_findAll() throws Exception {
        List<Transportadora> transportadoras =
                Arrays.asList(buildList(102030L, "test"), buildList(102031L, "test two"));

        when(transportadoraService.getAll()).thenReturn(transportadoras);

        this.mockMvc
                .perform(get("/transportadora"))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(transportadoras.get(0).getId().toString()))
                .andExpect(jsonPath("$[0].nome").value(transportadoras.get(0).getNome()));
    }

    private Transportadora buildList(Long id, String nome) {
        return Transportadora.builder().id(id).nome(nome).build();
    }
}
