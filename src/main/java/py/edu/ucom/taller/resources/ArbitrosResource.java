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
import py.edu.ucom.taller.models.entities.Arbitro;
import py.edu.ucom.taller.models.results.Pagina;
import py.edu.ucom.taller.repository.ArbitrosRepository;

@Path("api/v1/arbitros")
@Produces(MediaType.APPLICATION_JSON)
public class ArbitrosResource {

    @Inject
    ArbitrosRepository repository;

    @GET
    public List<Arbitro> listarTodos() {
        return repository.listarTodos();
    }

    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") Integer id) {
        Arbitro Arbitro = repository.obtenerPorId(id);
        if (Arbitro == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(Arbitro).build();
    }

    @POST
    public Response crear(Arbitro Arbitro) {
        repository.crear(Arbitro);
        return Response.status(Response.Status.CREATED).entity(Arbitro).build();
    }

    @PUT
    public Response actualizar(Arbitro Arbitro) {
        repository.actualizar(Arbitro);
        return Response.ok(Arbitro).build();
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
    public Pagina<Arbitro> paginado(
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
    public List<Arbitro> listarConFiltros(@Context UriInfo uriInfo) {
        Map<String, Object> filtros = new HashMap<>();
        uriInfo.getQueryParameters().forEach((key, values) -> {
            if (values != null && !values.isEmpty()) {
                filtros.put(key, values.get(0));
            }
        });
        return repository.listarConFiltros(filtros);
    }
}
