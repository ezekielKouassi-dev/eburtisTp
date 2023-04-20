package com.eburtis.tp.service;

import com.eburtis.tp.application.personne.PersonneService;
import com.eburtis.tp.application.personne.PersonneVO;
import com.eburtis.tp.domains.departement.Departement;
import com.eburtis.tp.domains.personne.Personne;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

        Personne personne = new Personne();
        personne.setNom(personneVO.getNom());
        personne.setPrenoms(personneVO.getPrenoms());
        personne.setAge(personne.getAge());
        personne.setDepartement(personneVO.getDepartement());

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
}
