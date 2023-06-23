/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Genericos;

/**
 *
 * @author oara1
 */
public class Contenedor<T> {
    private T atributo1;
    public Contenedor(T v){
        this.atributo1 = v;
        System.out.println("Tipo: " + v.getClass().getName());
    }

    public T getAtributo1() {
        return atributo1;
    }

    public void setAtributo1(T atributo1) {
        this.atributo1 = atributo1;
    }
    
    
    
}
