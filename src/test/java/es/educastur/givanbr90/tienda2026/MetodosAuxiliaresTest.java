/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package es.educastur.givanbr90.tienda2026;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 1dawd17
 */
public class MetodosAuxiliaresTest {

    public MetodosAuxiliaresTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of esInt method, of class MetodosAuxiliares.
     */
    @Test
    public void testEsInt() {

        //Assert sueltos, no nos dice cual de ellos falló en la prueba
        /*assertTrue(MetodosAuxiliares.esInt("5"));
        assertTrue(MetodosAuxiliares.esInt("-5"));
        assertFalse(MetodosAuxiliares.esInt("5.5"));
        assertFalse(MetodosAuxiliares.esInt("fywigdfcas"));*/
        //ASSERTALL permite encuadrar los casos de prueba de en un all para evitar confusiones si alguna prueba falla, ya que nos dice si hay alguna falla entre los tests
        assertAll(
                () -> assertTrue(MetodosAuxiliares.esInt("5")),
                () -> assertTrue(MetodosAuxiliares.esInt("-5")),
                () -> assertFalse(MetodosAuxiliares.esInt("5.5")),
                () -> assertFalse(MetodosAuxiliares.esInt("fywigdfcas"))
        );
    }

    /**
     * Test of esDouble method, of class MetodosAuxiliares.
     */
    @Test
    public void testEsDouble() {
        assertAll(
                () -> assertTrue(MetodosAuxiliares.esInt("5")),
                () -> assertTrue(MetodosAuxiliares.esInt("-5")),
                () -> assertFalse(MetodosAuxiliares.esInt("5.5")),
                () -> assertFalse(MetodosAuxiliares.esInt("fywigdfcas"))
        );        
    }

    /**
     * Test of validarDni method, of class MetodosAuxiliares.
     */
    @Test
    public void testValidarDni() {
        assertAll(
                () -> assertTrue(MetodosAuxiliares.validarDni("80580845T")),
                () -> assertTrue(MetodosAuxiliares.validarDni("36347775R")),
                () -> assertFalse(MetodosAuxiliares.validarDni("36347775A")),
                () -> assertFalse(MetodosAuxiliares.validarDni("363477A")),
                () -> assertFalse(MetodosAuxiliares.validarDni("80580845B"))
        );
    }

    /**
     * Test of calcularLetraDni method, of class MetodosAuxiliares.
     */
    /*@Test
    public void testCalcularLetraDni() {
        System.out.println("calcularLetraDni");
        int numero = 0;
        char expResult = ' ';
        char result = MetodosAuxiliares.calcularLetraDni(numero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
