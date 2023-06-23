/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.dao.DaoCliente;

@Path("cliente")
public class servicioCliente {

    @Context
    private UriInfo context;

    public servicioCliente() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientes() {
        DaoCliente dc= new DaoCliente();
        return Response.ok(dc.getAll()).build();
        
    }

    /**
     * PUT method for updating or creating an instance of servicioCliente
     * @param content representation for the resource
     */
    /**
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }*/
}
