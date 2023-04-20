package com.eburtis.tp.controller;

import com.eburtis.tp.domains.departement.DepartementRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@Tag("DepartementControllerTest")
@DisplayName("Test unitaire pour le controller departement")
public class DepartementControllerTest {

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    @DisplayName("test pour avoir la liste des departements")
    public void listeDesDepartement() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/departement")
        )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
