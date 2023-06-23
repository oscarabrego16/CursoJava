/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplo1;

/**
 *
 * @author oara1
 */

//para indicar que se hace herencia se utiliza extends
//la clase Ejemplo1 esta extendiendo la clase Object
//Incluso que no se coloque la heredacion, todas las clases por defecto heredan de OBject
//
public class Ejemplo1 extends Object{
    protected String atributoProtegido;

    public String getAtributoProtegido() {
        return atributoProtegido;
    }

    public void setAtributoProtegido(String atributoProtegido) {
        this.atributoProtegido = atributoProtegido;
    }
    
    
}
