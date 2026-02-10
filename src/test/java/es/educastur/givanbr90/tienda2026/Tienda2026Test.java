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
        t.cargaDatos();
    }

    @AfterEach
    public void tearDown() {
    }

    
    Tienda2026 t=new Tienda2026();
    
    /**
     *
     */
    @Test
    public void testTotalPedido() {
        assertAll(
        /*Con equals primero ponemos el valor esperado y luego el que recibimos. Debemos meterle los datos de para que calcule los pedidos,
          esto pasa porque en la clase Tienda2026 los datos son private, para acceder a ellos debemos hacer un get para acceder a las colecciones
          desde otra clase, en este caso la clase de prueba
               - Se añaden en los getter en la clase original para poder acceder a los datos en las prueba, como si lo hagamos public
               - El método de totalPedido támbien debe ser public para que se pueda hacer el test
          MUY IMPORTANTE METER EL t.cargaDatos(); EN EL @BeforeEach PARA QUE PODAMOS ACCEDER A LOS DATOS Y NO ESTÉN VACÍOS
          El primer dígito representa el supuesto valor real del pedido del segundo dígito, estamos señalando el precio de dicho pedido. Los valores
          deberíamos haberlo calculado manualmente*/
                
                () -> assertEquals(585, t.totalPedido(t.getPedidos().get(0))),
                () -> assertEquals(2980, t.totalPedido(t.getPedidos().get(1))),
                () -> assertEquals(390, t.totalPedido(t.getPedidos().get(2))),
                () -> assertEquals(1980, t.totalPedido(t.getPedidos().get(3)))
        );
    }

}
