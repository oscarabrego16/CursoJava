package sv.edu.formas.S5Servicios.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("servicio1")
public class servicioPrueba {
    
    @GET
    //response es una clase de los web services de forma que sea mas transparente la respuresta
    @Produces(MediaType.APPLICATION_JSON)
    public Response prueba1(){
        
        String mensaje = "Hola mundo, soy un servicio webb";
        return Response.status(Response.Status.OK).entity(mensaje).build();
    }
}
