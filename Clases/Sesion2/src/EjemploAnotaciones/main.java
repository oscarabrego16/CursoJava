package EjemploAnotaciones;

import java.lang.annotation.Annotation;

public class main {
    public static void main(String[] args) {
        
        Ejemplo ob = new Ejemplo();
        System.out.println(ob.getClass().getAnnotations()[0]);
        
        //estas anotaciones son introspecciones de la clases a partir del objeto
        //se puede obtener toda la metadata del objeto
        
        //en una clase en tiempo de ejecucion s epuede a traves de las anotaciones
        //describir el codigo fuente
        
        Annotation[] an = ob.getClass().getAnnotations();
        AnotacionConOpciones ap = (AnotacionConOpciones) an[0];
        System.out.println(ap.Atributo1());
        System.out.println(ap.Atributo2());
    }
}
