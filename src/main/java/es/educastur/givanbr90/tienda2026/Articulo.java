/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.givanbr90.tienda2026;

import java.io.Serializable;

/**
 *
 * @author 1dawd17
 */
public class Articulo implements Serializable{
    private String idArticulo;
    private String descripcion;
    private int existencias;
    private double pvp;
    private boolean activo;

    public Articulo(String idArticulo, String descripcion, int existencias, double pvp) {
        this.idArticulo = idArticulo;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.pvp = pvp;
        this.activo= true;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    @Override
    public String toString() {
        return idArticulo + " / " + descripcion + " / " + existencias + " uds / " + pvp + " euros /" + (activo ? "ACTIVO" : "INACTIVO");
    }

}
