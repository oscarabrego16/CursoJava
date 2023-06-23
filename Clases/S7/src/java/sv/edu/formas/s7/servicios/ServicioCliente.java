package sv.edu.formas.s7.servicios;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import sv.edu.formas.s7.entidad.Cliente;

public class ServicioCliente {
    private Client client;
    private WebTarget webTarget;
    
    public ServicioCliente (){
        String url="http://localhost:8080/S5Servicios/webapi/"; //la direccion del servicio
        this.client = javax.ws.rs.client.ClientBuilder.newClient();
        this.webTarget = this.client.target(url).path("cliente");
    }
    
    public List<Cliente> consultarClientes(){
        String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJPc2NhciBSb2RyaWd1ZXoiLCJpYXQiOjE2ODIxOTc5MjgsImV4cCI6MTY4MjE5ODgyOCwiZW1haWwiOiJvYXJhMTZAaG90bWFpbC5jb20ifQ.HCS1yBgtPjVH1zMPZ__SA1qNCsZtxFhVwOkMv7BuWvs";
        return this.webTarget.request(MediaType.APPLICATION_JSON)
                .header("Authorization", token)
                .get(new GenericType<List<Cliente>>(){});//la peticion nso devuelve un json y eso se inyecta en un generico con esos nodos
    }
}
