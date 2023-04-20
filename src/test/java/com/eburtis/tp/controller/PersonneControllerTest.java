package com.eburtis.tp.controller;

import com.eburtis.tp.domains.personne.PersonneRepository;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest // cette annotation permet de spécifier que cette classe est une classe de tests
// Cette annotation permet de gerer l'instanciation de ma classe de test
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
// cette annotation permet de gerer l'ordre d'execution des methodes de test
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// cette annotation permet d'injecter un object mockmvc qui est une classe de test pour tester nos endpoint
@AutoConfigureMockMvc
// cette annotation est utile pour executer les tests en fonction de leur domaine
@Tag("PersonneControllerTest")
// cette annotation est utile pour décrire nos classe ou methode de test
@DisplayName("Test unitaire pour le controller des personnes")
public class PersonneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private JSONObject jsonObject;



    @Test
    @Order(1)
    @DisplayName("test création de personne")
    public void creationPersonneTest() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/personne")
                .content(
                        "{\n" +
                                "\t\"nom\" : \"kouassi\",\n" +
                                "\t\"prenoms\": \"amon\",\n" +
                                "\t\"age\": 25,\n" +
                                "\t\"departement\": {\"id\":1,\"code\":\"TY859663\", \"designation\":\"Departement informatique\"}\n" +
                                "}"
                ).contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(jsonPath("$.message", is("personne enregistré avec succès")))
                .andExpect(jsonPath("$.status", is(200)))
                .andReturn();

        jsonObject = new JSONObject(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @Order(2)
    @DisplayName("test mise à jour d'une personne")
    public void miseAJourPersonneTest() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.put("/api/v1/personne/1")
                        .content(
                                "{\n" +
                                        "\t\"nom\" : \"Cisse\",\n" +
                                        "\t\"prenoms\": \"amon\",\n" +
                                        "\t\"age\": 25,\n" +
                                        "\t\"departement\": {\"id\":1,\"code\":\"TY859663\", \"designation\":\"Departement informatique\"}\n" +
                                        "}"
                        )
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(print())
                .andExpect(jsonPath("$.message", is("impossible de MAJ une personne qui n'existe pas!")))
                .andExpect(jsonPath("$.status", is(404))
        )
                .andReturn();
        jsonObject = new JSONObject(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @Order(3)
    @DisplayName("test de liste des personnes")
    public void listeDesPersonnesTest() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/personne")
        )
                .andDo(print())
                .andExpect(jsonPath("$.message", is("succèss")))
                .andExpect(jsonPath("$.status", is(200)));

    }

    @Test
    @Order(4)
    @DisplayName("test de suppression de personne")
    public void supprimerPersonneTest() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/v1/personne/1")
        )
                .andDo(print())
                .andExpect(jsonPath("$.message", is("personne impossible à trouvé")))
                .andExpect(jsonPath("$.status", is(404)));
    }
}
