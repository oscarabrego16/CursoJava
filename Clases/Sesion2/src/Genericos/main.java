package Genericos;

import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        Set<String> lista = new HashSet<>();
        lista.add("Cadena1");
        lista.add("Cadena2");
        lista.add("Cadena3");
        //aplicando una lambda en coleccion
        lista.forEach((item)->{
        System.out.println(item);
        });
        
        //puede definirse cualquier tipo pues es generico, util cuanod se busca utilizar distintos tipos de datos
        Contenedor<Object> ob1 = new Contenedor<>(1f);
        System.out.println(ob1.getAtributo1());
        
    }
}
