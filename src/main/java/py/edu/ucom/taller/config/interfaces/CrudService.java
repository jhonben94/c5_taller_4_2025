package py.edu.ucom.taller.config.interfaces;

import java.util.List;
import py.edu.ucom.taller.models.results.Pagina;
import py.edu.ucom.taller.models.results.RespuestaGenerica;
import py.edu.ucom.taller.models.results.PaginacionParametros;

public interface CrudService<T, ID> {
    RespuestaGenerica<T> crear(RespuestaGenerica<T> solicitud);

    RespuestaGenerica<T> actualizar(RespuestaGenerica<T> solicitud);

    RespuestaGenerica<Void> eliminar(ID id);

    RespuestaGenerica<T> obtenerPorId(ID id);

    RespuestaGenerica<List<T>> listarTodos();

    RespuestaGenerica<Pagina<T>> listarPaginado(PaginacionParametros parametros);
}
