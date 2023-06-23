/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import javax.persistence.Entity;

/**
 *
 * @author oara1
 */
@Entity
public class RecetaDTO {
    private int idUsuario;
    private String indicacion;
    private int cantidad;

    public RecetaDTO() {
    }

    public RecetaDTO(int idUsuario, String indicacion, int cantidad) {
        this.idUsuario = idUsuario;
        this.indicacion = indicacion;
        this.cantidad = cantidad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIndicacion() {
        return indicacion;
    }

    public void setIndicacion(String indicacion) {
        this.indicacion = indicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
