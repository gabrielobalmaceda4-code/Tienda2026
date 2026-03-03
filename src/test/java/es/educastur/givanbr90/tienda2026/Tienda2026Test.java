/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package es.educastur.givanbr90.tienda2026;

import java.util.ArrayList;
import java.util.HashMap;
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
public class Tienda2026Test {

    public Tienda2026Test() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        t.cargaDatos();//Ejecutamos el cargaDatos de la misma tienda para hacer las pruebas con los mimos datos, SIEMPRE ANTES DEL AFTEREACH
    }

    @AfterEach
    public void tearDown() {
    }

    Tienda2026 t = new Tienda2026();

    /**
     * HAY QUE HACER MÁS CASOS DE PRUEBA CON LOS DISTINTOS MÉTODOS PARA DOMINAR
     * LOS JUNIT
     *
     * PARA PODER PROBAR LOS MÉTODOS EN EL TEST DEBEMOS CAMBIAR LOS MÉTODOS DE
     * PRIVATE A PUBLIC DE FORMA TEMPORAL PARA QUE LOS TEST FUNCIONEN
     *
     * LOS MÉTODOS QUE NO DEVUELVEN NADA NO SEPUEDEN PROBAR, EXCEPTO AQUELLOS
     * QUE LANZAN LAS EXCEPCIONES
     */
    @Test
    /**
     * Test of cargaDatos method, of class Tienda2026.
     */
    public void testCargaDatos() {
        assertAll(
                //AssertEquals ejecuta los métodos tal cual en la tienda teniendo en cuenta el lenguaje de predicados, estamos accediendo a cada una de las colecciones de la tienda
                () -> assertEquals(10, t.getArticulos().size()),//La colección me tiene que dar 10 porque hay 10 artículos
                () -> assertEquals(4, t.getClientes().size()),
                () -> assertEquals(5, t.getPedidos().size())
        );

    }

    @Test
    /**
     * Test del método generaIdPedido
     */
    public void testGeneraIdPedido() {
        assertAll(
                () -> assertEquals("80580845T-003/2026", t.generaIdPedido("80580845T")),//Como esta persona tiene 2 pedidos le genera el id 003
                () -> assertEquals("36347775R-003/2026", t.generaIdPedido("36347775R")),//Tenía 2, pues 003
                () -> assertEquals("63921307Y-002/2026", t.generaIdPedido("63921307Y")),//Tenía 1 pues id 002
                () -> assertEquals("02337565Y-001/2026", t.generaIdPedido("02337565Y"))//No tenía pedidos, id 001
        );
    }

    @Test
    /**
     * Verifica el Total gastado en cada pedido
     */
    public void testTotalPedido() {
        assertAll(
                /*Con equals primero ponemos el valor esperado y luego el que recibimos. Debemos meterle los datos de para que calcule los pedidos,
          esto pasa porque en la clase Tienda2026 los datos son private, para acceder a ellos debemos hacer un get para acceder a las colecciones
          desde otra clase, en este caso la clase de prueba
               - Se añaden en los getter en la clase original para poder acceder a los datos en las prueba, como si lo hagamos public
               - El método de totalPedido támbien debe ser public para que se pueda hacer el test
          MUY IMPORTANTE METER EL t.cargaDatos(); EN EL @BeforeEach PARA QUE PODAMOS ACCEDER A LOS DATOS Y NO ESTÉN VACÍOS
          El primer dígito representa el supuesto valor real del pedido del segundo dígito, estamos señalando el precio de dicho pedido. Los valores
          deberíamos haberlo calculado manualmente
                
          Assert All nos permite identificar los casos de prueba->casos de prueba
                
          Llamamos al método con sus respectivos pedidos (0,1,2,3,4) para ver si los gastos son los mismo que los establecidos al principio del predicado
                 */
                () -> assertEquals(585, t.totalPedido(t.getPedidos().get(0))),
                () -> assertEquals(2980, t.totalPedido(t.getPedidos().get(1))),
                () -> assertEquals(390, t.totalPedido(t.getPedidos().get(2))),
                () -> assertEquals(1980, t.totalPedido(t.getPedidos().get(3))),
                () -> assertEquals(2160, t.totalPedido(t.getPedidos().get(4)))
        );
    }

    @Test
    /**
     * Verifica el total gastado por cada cliente
     */
    public void testTotalCliente() {
        assertAll(
                /*LLamamos a los 4 clientes mediante dni que coincida con los gastos de dichw persoana*/
                () -> assertEquals(3565, t.totalCliente(t.getClientes().get("80580845T"))),
                () -> assertEquals(2370, t.totalCliente(t.getClientes().get("36347775R"))),
                () -> assertEquals(2160, t.totalCliente(t.getClientes().get("63921307Y"))),
                () -> assertEquals(0, t.totalCliente(t.getClientes().get("02337565Y")))
        );

    }

    @Test
    /**
     * Contabiliza Stock de artículos según las excepciones planteadas
     */
    public void testStock() {
        
        assertAll(
                ()-> assertThrows(StockCero.class, ()->{t.stock(t.getArticulos().get("1-11"), 5);}),
                ()-> assertThrows(StockCero.class, ()->{t.stock(t.getArticulos().get("2-33"), 1);}),
                ()-> assertThrows(StockInsuficiente.class, ()->{t.stock(t.getArticulos().get("3-11"), 5);}),
                ()-> assertThrows(StockInsuficiente.class, ()->{t.stock(t.getArticulos().get("3-22"), 10);})    
        );
    }
}
