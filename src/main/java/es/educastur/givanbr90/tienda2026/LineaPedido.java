/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.givanbr90.tienda2026;

/**
 *
 * @author 1dawd17
 */
public class LineaPedido {
    private Articulo articulo;
    private int unidades;

    public LineaPedido(Articulo articulo, int unidades){
        this.articulo = articulo;
        this.unidades = unidades;
    }
    
    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    @Override
    public String toString() {
        return articulo + " - " + unidades + " uds.";
    }
    
}
