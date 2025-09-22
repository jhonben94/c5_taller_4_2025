package py.edu.ucom.taller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import py.edu.ucom.taller.models.results.RespuestaGenerica;

@Path("api")
public class GreetingResource {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus ";
    }
    @GET
    @Path("taller")
    @Produces(MediaType.TEXT_PLAIN)
    public String taller() {
     
        return "Hello from Quarkus ";
    }
    
    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public RespuestaGenerica jsonExample() {
        RespuestaGenerica rest = new RespuestaGenerica();
        rest.setCodigo("200");
        rest.setMensaje("mensaje");
        return rest ;
    }
}
