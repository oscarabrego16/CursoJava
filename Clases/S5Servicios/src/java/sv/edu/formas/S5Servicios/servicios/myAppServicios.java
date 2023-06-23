package sv.edu.formas.S5Servicios.servicios;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//contexto de despliegue es la notacion
@ApplicationPath("webapi") //ahi se deploya sobre el proyecto
public class myAppServicios extends Application{
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> recursos = new HashSet<>(); //HashSet es interfaz para manejar colecciiones
        recursos.add(servicioPrueba.class);
        recursos.add(ServicioCliente.class);
        recursos.add(loginServicio.class);
        return recursos;
    }
}
