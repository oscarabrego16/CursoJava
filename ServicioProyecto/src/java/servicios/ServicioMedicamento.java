package servicios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.dao.DaoMedicamento;
import modelo.entidad.Medicamento;

@Path("medicamento")
public class ServicioMedicamento {

    @Context
    private UriInfo context;

    public ServicioMedicamento() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        DaoMedicamento dm = new DaoMedicamento();
        List<Medicamento> medicamentos = dm.getAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(medicamentos);

        return Response.ok(json).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarMedicamento(@FormParam("nombre") String nombre, @FormParam("laboratorio") String laboratorio,
            @FormParam("activo") String activo) {
        Medicamento med = new Medicamento();
        med.setNombre(nombre);
        med.setLaboratorio(laboratorio);
        med.setActivo(activo);
        DaoMedicamento dm = new DaoMedicamento();
        if (dm.insertar(med)) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.GONE).build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarMedicamento(@FormParam("id") int id, @FormParam("nombre") String nombre, @FormParam("laboratorio") String laboratorio,
            @FormParam("activo") String activo) {
        Medicamento med = new Medicamento();
        med.setNombre(nombre);
        med.setLaboratorio(laboratorio);
        med.setActivo(activo);
        DaoMedicamento dm = new DaoMedicamento();
        if (dm.modificar(id, med)) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.GONE).build();
        }
    }

    @DELETE
    @Path("/{id}")
    //@Produces(MediaType.APPLICATION_JSON)
    public Response eliminarMedicamento(@PathParam("id") int id) { 
        System.out.println("servicios.ServicioMedicamento.eliminarMedicamento()");
        DaoMedicamento dm = new DaoMedicamento();
        if (dm.eliminar(id)) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.GONE).build();
        }
    }
}
