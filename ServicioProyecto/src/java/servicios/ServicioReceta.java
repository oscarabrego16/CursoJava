/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.entidad.Receta;
import modelo.entidad.RecetaDTO;
import modelo.entidad.Usuario;

/**
 *
 * @author oara1
 */
@Path("receta")
public class ServicioReceta {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertarReceta(Usuario re){
        //String data = 
        
    System.out.println("hmm RECETAAA******"+re.getIdUsuario()+re.getNombre()+re.getApellido());
        
        
        return Response.status(Response.Status.OK).build();
    } 
    
    
}
