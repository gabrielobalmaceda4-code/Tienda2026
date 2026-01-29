/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.givanbr90.tienda2026;

/**
 *
 * @author 1dawd17
 */
public class StockCero extends Exception {
    public StockCero (String mensaje){
        super(mensaje);//No hago el constructor, estamos llamando al constructor de las Exception para construir nuestra propias excepciones
    }
}
