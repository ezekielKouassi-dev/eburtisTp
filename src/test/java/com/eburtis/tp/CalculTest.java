package com.eburtis.tp;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("CalculTest")
@DisplayName("test de calcule")
public class CalculTest {
    private float a = 1;
    private float b= 1;
    Calcul calcul = new Calcul(a,b);

    @Order(value = 1)
    @DisplayName("Test d'addition")
    @Test
    public void CalculAdditionTest() throws Exception {
        Assertions.assertEquals(this.calcul.additionner(a,b), 2.0);
    }

    @Order(value = 2)
    @DisplayName("Test de soustraction")
    @Test
    public void CalculSoustraireTest() throws Exception {
        Assertions.assertEquals(this.calcul.soustraire(a,b), 0.0);
    }

    @Order(value = 3)
    @DisplayName("Test de multiplication")
    @Test
    public void CalculMultiplierTest() throws Exception {
        Assertions.assertEquals(this.calcul.multiplier(a,b), 1.0);
    }

    @Order(value = 4)
    @DisplayName("Test de division")
    @Test
    public void CalculDiviserTest() throws Exception {
        Assertions.assertEquals(this.calcul.diviser(a,b), 2.0);
    }

    @Order(value = 5)
    @DisplayName("Test du carré")
    @Test
    public void CalculCarreTest() throws Exception {
        Assertions.assertEquals(this.calcul.carre(a), 1.0);
    }

    @Order(value = 6)
    @DisplayName("Test avec identité remarquable")
    @Test
    public void CalculIdentiteRemarquableTest() throws Exception {
        Assertions.assertEquals(this.calcul.identiteRemarquable(a,b), 4.0);
    }
}
