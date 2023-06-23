package sv.edu.formas.S5Servicios.servicios;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.json.JsonObject;
import javax.json.Json;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.edu.formas.s5.dao.DaoUsuario;
import sv.edu.formas.s5.entidad.Usuario;


@Path("auth")
public class loginServicio {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validar(Usuario us){
        DaoUsuario du = new DaoUsuario();
        System.out.println("USUARIO "+ us.getUsername());
        System.out.println("USUARIO "+ us.getPassword());
        boolean status=du.validar(us.getUsername(), us.getPassword());
        if(status){
            String secret = "miClave";
            long tiempo = System.currentTimeMillis();
            String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .setSubject("Oscar Rodriguez")
                    .setIssuedAt(new Date(tiempo))
                    .setExpiration(new Date(tiempo + 900000))
                    .claim("email", "oara16@hotmail.com")
                    .compact();
            JsonObject json = Json.createObjectBuilder().add("JWT", jwt).build();
            return Response.status(Response.Status.CREATED).entity(jwt).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
