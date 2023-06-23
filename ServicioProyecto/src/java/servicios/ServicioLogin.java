/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.dao.DaoUsuario;
import modelo.entidad.Usuario;

/**
 *
 * @author oara1
 */
@Path("auth")
public class ServicioLogin {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Response validar(@FormParam("username") String username, @FormParam("password") String password) {
        DaoUsuario du = new DaoUsuario();
        /*File configFile = new File("config.properties");
        try{
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            String secret = props.getProperty("secret");
            reader.close();
            System.out.println("servicios.ServicioLogin.validar() SECRETTTTTTTTTTT: "+ secret);
        }catch(FileNotFoundException ex){
            System.out.println("Error, archivo no existe "+ ex.getMessage());
        }
        catch (IOException ex) {
   System.out.println("Error de IO "+ ex.getMessage());
}*/
        
        System.out.println("servicios.ServicioLogin.validar() "+username+password);
        boolean status = du.validar(username, password);
        if (status) {
            String secret = "miClave";
            long tiempo = System.currentTimeMillis();
            String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.ES256.HS256, secret)
                    .setSubject(username)
                    .setIssuedAt(new Date(tiempo))
                    .setExpiration(new Date(tiempo + 900000000))
                    .claim("username",username)
                    .compact();
            JsonObject json = Json.createObjectBuilder().add("JWT", jwt).build();
            
            return Response.status(Response.Status.CREATED).entity(jwt).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
