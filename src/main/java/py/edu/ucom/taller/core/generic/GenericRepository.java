package py.edu.ucom.taller.core.generic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.transaction.Transactional;
import py.edu.ucom.taller.models.results.Pagina;

public abstract class GenericRepository<T, ID> implements PanacheRepositoryBase<T, ID> {

    public List<T> listarTodos() {
        return listAll();
    }

    public T obtenerPorId(ID id) {
        return findById(id);
    }

    @Transactional
    public void crear(T entity) {
        persist(entity);
    }

    @Transactional
    public void actualizar(T entity) {
        persist(entity);
    }

    @Transactional
    public boolean eliminar(ID id) {
        return deleteById(id);
    }

    public Pagina<T> listarConFiltrosYPaginacion(
            Map<String, Object> filtros,
            String ordenPor,
            String ordenDir,
            int pagina,
            int tamanio) {

        StringBuilder query = new StringBuilder();
        Map<String, Object> queryParams = new HashMap<>();

        if (filtros != null && !filtros.isEmpty()) {
            String filterConditions = filtros.entrySet().stream()
                    .map(entry -> {
                        String key = entry.getKey();
                        Object value = entry.getValue();

                        if (value instanceof String) {
                            queryParams.put(key, "%" + value.toString().toUpperCase() + "%");
                            return "UPPER(" + key + ") LIKE UPPER(:" + key + ")";
                        } else if (value instanceof Number) {
                            queryParams.put(key, value);
                            return key + " = :" + key;
                        } else if (value instanceof LocalDate || value instanceof LocalDateTime) {
                            queryParams.put(key, value);
                            return key + " = :" + key;
                        }
                        return null;
                    })
                    .filter(condition -> condition != null)
                    .collect(Collectors.joining(" AND "));

            if (!filterConditions.isEmpty()) {
                query.append("WHERE ").append(filterConditions);
            }
        }

        if (ordenPor != null && !ordenPor.isEmpty()) {
            query.append(" ORDER BY ").append(ordenPor).append(" ")
                    .append("desc".equalsIgnoreCase(ordenDir) ? "DESC" : "ASC");
        }

        List<T> content = find(query.toString(), queryParams).page(pagina, tamanio).list();
        long totalElements = count();
        int totalPages = (int) Math.ceil((double) totalElements / (double) tamanio);

        Pagina<T> resultado = new Pagina<>();
        resultado.setItems(content);
        resultado.setPage(pagina);
        resultado.setSize(tamanio);
        resultado.setTotalItems(totalElements);
        resultado.setTotalPages(totalPages);
        resultado.setOrdenarPor(ordenPor);
        resultado.setDireccionOrden(ordenDir);
        return resultado;
    }

    public List<T> listarConFiltros(Map<String, Object> filtros) {
        StringBuilder query = new StringBuilder();
        Map<String, Object> queryParams = new HashMap<>();

        if (filtros != null && !filtros.isEmpty()) {
            String filterConditions = filtros.entrySet().stream()
                    .map(entry -> {
                        String key = entry.getKey();
                        Object value = entry.getValue();

                        if (value instanceof String) {
                            queryParams.put(key, "%" + value.toString().toUpperCase() + "%");
                            return "UPPER(" + key + ") LIKE UPPER(:" + key + ")";
                        } else if (value instanceof Number) {
                            queryParams.put(key, value);
                            return key + " = :" + key;
                        } else if (value instanceof LocalDate || value instanceof LocalDateTime) {
                            queryParams.put(key, value);
                            return key + " = :" + key;
                        }
                        return null;
                    })
                    .filter(condition -> condition != null)
                    .collect(Collectors.joining(" AND "));

            if (!filterConditions.isEmpty()) {
                query.append("WHERE ").append(filterConditions);
            }
        }

        return find(query.toString(), queryParams).list();
    }
}
