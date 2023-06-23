/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.formas.S5Servicios.servicios;

import io.jsonwebtoken.Jwts;
import java.util.Base64;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.edu.formas.s5.dao.DaoCliente;
import sv.edu.formas.s5.entidad.Cliente;

@Path("cliente")
public class ServicioCliente {
        //metodos de consulta
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarTodos(@HeaderParam("Authorization") String token){
        if(token != null){
        System.out.println("Token> "+ token);
        String _token = token.substring(7);
        System.out.println("Token> "+ _token);
        String datos[] = _token.split("\\.");
        Base64.Decoder decodificador = Base64.getUrlDecoder();
        
        try{
            System.out.println("Entrando try");
            Jwts.parser().setSigningKey("miClave").parseClaimsJws(_token);
            System.out.println("Payload "+ new String(decodificador.decode(datos[1])));
            
        DaoCliente dc = new DaoCliente();
        return Response.status(Response.Status.OK).entity(dc.getAll()).build();
        }catch (Exception e){
        System.out.println(e.getMessage());
        }
        
        return Response.status(Response.Status.UNAUTHORIZED).build();
        }else{
        return Response.status(Response.Status.BAD_REQUEST).build();
        }
        
    }
    
    //no s epueden tener dos get en el mismo path, pero puedo redefinir el path de una
    @GET
    @Path("/filtro")
    @Produces(MediaType.APPLICATION_JSON)
    //puede enviarse paraetros en el params, headers, o body, en body por medio de muchas cosas
    //segun la priamide de richardson no deberia usarse por queryparam
    public Response consultarPorId(@QueryParam("id") int id){
        DaoCliente dc = new DaoCliente();
        Cliente cli = dc.getById(id);
        System.out.println("ConsultarporID "+ id);
        return Response.status(Response.Status.OK).entity(cli).build();
    }
    
    @GET
    @Path("{id}")
    //tambien pueden enviarse mas parametros @Path("{id/nombre}"), pero no es tan usual usar dos para un filtrado
    @Produces(MediaType.APPLICATION_JSON)
    //ya no se recibe por queryparam sino que por path param
    public Response consultarIdPath(@PathParam("id") int id){
        DaoCliente dc = new DaoCliente();
        Cliente cli = dc.getById(id);
        System.out.println("ConsultarporID "+ id);
        return Response.status(Response.Status.OK).entity(cli).build();
    }
    
    //***********************************************************************************
    //***********************operaciones de escritura*************************************
    
    @POST
    //@Consumes(MediaType.APPLICATION_JSON) podria consumir tambien JSON
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarCliente( @FormParam("nom") String nombre, @FormParam("apellido") String apellido){
        Cliente cli= new Cliente();
        cli.setNombre(nombre);
        cli.setApellido(apellido);
        DaoCliente dc = new DaoCliente();
        
        if(dc.insertar(cli)>0)
        {
        return Response.status(Response.Status.CREATED).build();
        }else{
        return Response.status(Response.Status.GONE).build();    
        }
        
    }
    
    
    
    //*************modificaciones
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarCliente(@PathParam("id") int id, @FormParam("nom") String nombre, @FormParam("apellido") String apellido){
        
        Cliente cli= new Cliente();
        cli.setNombre(nombre);
        cli.setApellido(apellido);
        DaoCliente dc = new DaoCliente();
        
        if(dc.modificar(id,cli)>0)
        {
        return Response.status(Response.Status.OK).build();
        }else{
        return Response.status(Response.Status.GONE).build();    
        }
        
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarCliente(@PathParam("id") int id){
       
        DaoCliente dc = new DaoCliente();
        
        if(dc.eliminar(id)>0)
        {
        return Response.status(Response.Status.OK).build();
        }else{
        return Response.status(Response.Status.GONE).build();    
        }
        
    }
    
    
    
}
