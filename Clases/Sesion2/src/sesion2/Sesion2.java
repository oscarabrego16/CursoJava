/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sesion2;

import Ejemplo1.SubEjemplo1;
import Ejemplo1.Ejemplo1;

/**
 *
 * @author oara1
 */


public class Sesion2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SubEjemplo1 obj1 = new SubEjemplo1();
        obj1.setAtributoProtegido("Hola atributo protegido");
        System.out.println(obj1.getAtributoProtegido());
        
    }
    
}
