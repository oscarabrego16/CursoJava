/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import javax.json.Json;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.dao.DaoUsuario;
import javax.ws.rs.core.GenericEntity;
import modelo.entidad.Usuario;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

@Path("cliente")
public class ServicioCliente {

    @Context
    private UriInfo context;

    public ServicioCliente() {
    }
//return Response.status(Response.Status.OK).entity(dc.getAll()).build();

    public void validarJWT(String token) throws Throwable {
        if (token != null) {
            try {
                String _token = token.substring(7);
                String datos[] = _token.split("\\.");
                Base64.Decoder decodificador = Base64.getUrlDecoder();
                Jwts.parser().setSigningKey("miClave").parseClaimsJws(_token);
                //como obtener la clave de un properties?
                System.out.println("Payload " + new String(decodificador.decode(datos[1])));
                //String subject = jwtClaims.getBody();
            } catch (Exception e) {
                throw e;
            }

        } else {
            throw new SignatureException("Token vacio");
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientes(@HeaderParam("Authorization") String token) throws Throwable {
        try {
            validarJWT(token);
        } catch (SignatureException e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        DaoUsuario du = new DaoUsuario();
        List<Usuario> usuarios = du.getAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(usuarios);
        //no retornar con ok, sino con status
        //return Response.status(Response.Status.OK).entity(dc.getAll()).build();
        return Response.ok(json).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarCliente(@HeaderParam("Authorization") String token, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido,
            @FormParam("username") String username, @FormParam("password") String password) throws Throwable {
        try {
            validarJWT(token);
        } catch (SignatureException e) {
            System.out.println(e.getMessage());
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        Usuario us = new Usuario();
        us.setNombre(nombre);
        us.setApellido(apellido);
        us.setUsername(username.toLowerCase());
        us.setPassword(password);
        DaoUsuario du = new DaoUsuario();
        if (du.insertar(us)) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.GONE).build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarCliente(@HeaderParam("Authorization") String token, @FormParam("id") int id, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido,
            @FormParam("username") String username, @FormParam("password") String password) throws Throwable {
        try {
            validarJWT(token);
        } catch (SignatureException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
//System.out.println("servicios.ServicioCliente.modificarCliente()  + "+nombre+apellido+username+password +id);
        Usuario us = new Usuario();
        us.setNombre(nombre);
        us.setApellido(apellido);
        us.setUsername(username.toLowerCase());
        us.setPassword(password);
        DaoUsuario du = new DaoUsuario();
        if (du.modificar(id, us)) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.GONE).build();
        }

    }

    @DELETE
    @Path("/{id}")
    //@Produces(MediaType.APPLICATION_JSON)
    public Response eliminarCliente(@HeaderParam("Authorization") String token, @PathParam("id") int id) throws Throwable {
        try {
            validarJWT(token);
        } catch (SignatureException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
        DaoUsuario du = new DaoUsuario();
        System.out.println("servicios.ServicioCliente.eliminarCliente()" + id);
        if (du.eliminar(id)) {
            System.out.println("exitoso()");
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.GONE).build();
        }
    }

}
