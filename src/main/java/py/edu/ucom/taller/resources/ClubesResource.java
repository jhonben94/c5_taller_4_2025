package py.edu.ucom.taller.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import py.edu.ucom.taller.models.entities.Club;
import py.edu.ucom.taller.models.results.Pagina;
import py.edu.ucom.taller.repository.ClubesRepository;

@Path("api/v1/clubes")
@Produces(MediaType.APPLICATION_JSON)
public class ClubesResource {

    @Inject
    ClubesRepository repository;

    @GET
    public List<Club> listarTodos() {
        return repository.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") Integer id) {
        Club Club = repository.obtenerPorId(id);
        if (Club == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(Club).build();
    }

    @POST
    public Response crear(Club Club) {
        repository.crear(Club);
        return Response.status(Response.Status.CREATED).entity(Club).build();
    }

    @PUT
    public Response actualizar(Club Club) {
        repository.actualizar(Club);
        return Response.ok(Club).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Integer id) {
        boolean eliminado = repository.eliminar(id);
        if (!eliminado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/paginate")
    public Pagina<Club> paginado(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("10") int size,
            @QueryParam("sortBy") String sortBy,
            @QueryParam("sortDir") @DefaultValue("asc") String sortDir,
            @Context UriInfo uriInfo) {

        Map<String, Object> filtros = new HashMap<>();
        uriInfo.getQueryParameters().forEach((key, values) -> {
            if (!key.equals("page") && !key.equals("size") && !key.equals("sortBy") && !key.equals("sortDir")) {
                if (values != null && !values.isEmpty()) {
                    filtros.put(key, values.get(0));
                }
            }
        });

        return repository.listarConFiltrosYPaginacion(filtros, sortBy, sortDir, page, size);
    }

    @GET
    @Path("/filter")
    public List<Club> listarConFiltros(@Context UriInfo uriInfo) {
        Map<String, Object> filtros = new HashMap<>();
        uriInfo.getQueryParameters().forEach((key, values) -> {
            if (values != null && !values.isEmpty()) {
                filtros.put(key, values.get(0));
            }
        });
        return repository.listarConFiltros(filtros);
    }
}
