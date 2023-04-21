package com.eburtis.tp.service;

import com.eburtis.tp.application.departement.DepartementService;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DepartementServiceTest {

    @Autowired
    private DepartementService departementService;

    Gson gson;

    @Test
    @DisplayName("test pour avoir la liste des département")
    public void listeDepartementTest() {
        gson = new Gson();

        // GIVEN
        String actual = "[{\"code\":\"TY859663\"}, {...}]";
        String[] actualList = actual.split(",");
        Map<String, Object> mapActual = gson.fromJson(actualList[0], Map.class);

        // WHEN
        String result = this.departementService.fetchAllDepartement();
        String[] resultList = result.split(",");
        System.out.println(result);
        Map<String, Object> mapResult = gson.fromJson(resultList[0], Map.class);

        // THEN
        assertEquals(mapActual.get("code"), mapResult.get("code"));

    }
}
