package py.edu.ucom.taller.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import py.edu.ucom.taller.models.entities.Club;
import py.edu.ucom.taller.repository.ClubesRepository;
import java.util.List;

@Path("/clubes")
@Produces(MediaType.APPLICATION_JSON)
public class ClubesResource {

    @Inject
    ClubesRepository repository;

    @GET
    public List<Club> listarTodos() {
        return repository.listarTodos();
    }

}
