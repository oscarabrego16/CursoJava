package EjemploAnotaciones;

//es importante usar las politicas de uso de las anotaciones

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AnotacionConOpciones {
    String Atributo1();
    String Atributo2();
}