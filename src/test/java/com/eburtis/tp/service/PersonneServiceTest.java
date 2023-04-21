package com.eburtis.tp.service;

import com.eburtis.tp.application.personne.PersonneService;
import com.eburtis.tp.application.personne.PersonneVO;
import com.eburtis.tp.domains.departement.Departement;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("test du personne service")
public class PersonneServiceTest {

    @Autowired
    private PersonneService personneService;
    @Test
    @Order(1)
    @DisplayName("test d'enregistrement de personne")
    public void testSavePersonne() {
        // GIVEN
        String actual = "{\"message\":\"personne enregistré avec succès\",\"status\":200}";
        PersonneVO personneVO = new PersonneVO();
        personneVO.setNom("kouassi");
        personneVO.setPrenoms("ezekiel");
        personneVO.setAge(21L);
        personneVO.setDepartement(new Departement(1L, "TY859663", "Departement informatique"));

        // WHEN
        String result = personneService.savePersonne(personneVO);

        // THEN
        assertEquals(result, actual);
    }

    @Test
    @Order(2)
    @DisplayName("test de mise à jour de personne")
    public void testMiseAJourPersonne() {
        // GIVEN
        String actual = "{\"message\":\"personne MAJ avec succès\",\"status\":200}";
        Long id = 33L;
        PersonneVO personneVO = new PersonneVO();
        personneVO.setNom("konan");
        personneVO.setPrenoms("emmanuel");
        personneVO.setAge(21L);
        personneVO.setDepartement(new Departement(2L, "FF78200", "Departement RH"));

        // WHEN
        String result = personneService.updatePersonne(id, personneVO);

        // THEN
        assertEquals(result, actual);
    }

    @Test
    @Order(3)
    @DisplayName("test pour la liste des personnes")
    public void testListePersonne() throws JsonProcessingException {
        // GIVEN
        String actual = "{\"data\":\"...\",\"status\":200}";
        Gson gsonActual = new Gson();
        Map<String, Object> mapActual = gsonActual.fromJson(actual, Map.class);

        // WHEN
        String result = personneService.fetchAllPersonne();
        Gson gsonResult = new Gson();
        Map<String, Object> mapResult = gsonResult.fromJson(result, Map.class);

        // THEN
        assertEquals(mapActual.get("status"), mapResult.get("status"));
    }

    @Test
    @Order(4)
    @DisplayName("test pour la suppression d'une personne")
    public void testSupprimerPresonne() {
        // GIVEN
        String actual = "{\"message\":\"personne impossible à trouvé\",\"status\":404}";

        // WHEN
        String result = personneService.deletePersonne(22L);

        // THEN
        assertEquals(result, actual);
    }
}
