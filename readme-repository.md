## Patrón de Repositorio Genérico con Paginación, Orden y Filtros (Quarkus + Panache)

Este documento describe el patrón implementado para estandarizar el acceso a datos con Quarkus (Panache), incluyendo:

- CRUD genérico
- Listado paginado
- Ordenamiento dinámico (sort)
- Filtros dinámicos (texto, numéricos y de fecha)

### Componentes

- `py.edu.ucom.taller.core.generic.GenericRepository<T, ID>`
  - Base no reactiva que extiende `PanacheRepositoryBase<T, ID>`.
  - Provee utilitarios para listar (`listarTodos`), obtener (`obtenerPorId`), crear (`crear`), actualizar (`actualizar`), eliminar (`eliminar`), filtrar/paginar (`listarConFiltrosYPaginacion`).

- `py.edu.ucom.taller.models.results.PaginacionParametros`
  - DTO de entrada para paginación/orden/filtros.
  - Campos: `pagina`, `tamanio`, `ordenarPor`, `direccionOrden`, `filtroTexto`, `filtros` (mapa clave/valor).

- `py.edu.ucom.taller.models.results.Pagina<T>`
  - DTO de salida para resultados paginados.
  - Campos: `items`, `totalItems`, `page`, `size`, `totalPages`, `ordenarPor`, `direccionOrden`.

- `py.edu.ucom.taller.config.interfaces.CrudService<T, ID>`
  - Interfaz de servicio genérico usando `RespuestaGenerica` como contrato de entrada/salida.
  - Incluye `listarPaginado(PaginacionParametros)` retornando `RespuestaGenerica<Pagina<T>>`.

- `py.edu.ucom.taller.models.results.RespuestaGenerica<T>`
  - Envoltura genérica para respuestas con `codigo`, `mensaje` y `data`.

### Archivo clave: GenericRepository

Ubicación: `src/main/java/py/edu/ucom/taller/core/generic/GenericRepository.java`

Responsabilidades principales:

- `findAllEntities()` y `findEntityById(ID id)`
- `createEntity(T entity)`, `updateEntity(T entity)`, `deleteEntity(ID id)`
- `findWithFiltersAndPagination(Map<String,Object> filters, String sortBy, String sortDir, int page, int size)`
  - Construye dinámicamente la cláusula `WHERE` a partir de un `Map<String,Object>` de filtros.
  - Soporta tipos: `String` (LIKE UPPER), `Number` (=), `LocalDate`/`LocalDateTime` (=).
  - Aplica `ORDER BY` dinámico con dirección `ASC` o `DESC`.
  - Pagina usando `page(page, size)` de Panache.
  - Retorna un `Pagina<T>` con metadatos de paginación y orden actual.

### Cómo extender el repositorio para una entidad

Ejemplo para una entidad `Jugador` con id `Integer`:

```java
package py.edu.ucom.taller.repository;

import jakarta.enterprise.context.ApplicationScoped;
import py.edu.ucom.taller.core.generic.GenericRepository;
import py.edu.ucom.taller.models.entities.Jugador;

@ApplicationScoped
public class JugadorRepository extends GenericRepository<Jugador, Integer> {
}
```

### Uso básico en un servicio

```java
package py.edu.ucom.taller.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import py.edu.ucom.taller.models.entities.Jugador;
import py.edu.ucom.taller.models.results.Pagina;
import py.edu.ucom.taller.models.results.PaginacionParametros;
import py.edu.ucom.taller.repository.JugadorRepository;

import java.util.HashMap;

@ApplicationScoped
public class JugadorService {
    @Inject
    JugadorRepository repo;

    public Pagina<Jugador> listar(PaginacionParametros p) {
        return repo.listarConFiltrosYPaginacion(
            p.getFiltros() != null ? p.getFiltros() : new HashMap<>(),
            p.getOrdenarPor(),
            p.getDireccionOrden(),
            p.getPagina(),
            p.getTamanio()
        );
    }
}
```

### Contrato de entrada/salida estándar

- Entrada: `PaginacionParametros`
  - `page` (0-based), `size` (tamaño de página)
  - `sortBy` (campo), `sortDir` (`asc`|`desc`)
  - `filtroTexto` (libre, opcional), `filtros` (mapa estructurado clave -> valor)

- Salida: `Pagina<T>`
  - `items` (lista con el contenido)
  - `totalItems` (total de registros)
  - `page`, `size`, `totalPages`
  - `sortBy`, `sortDir` (reflejan el orden aplicado)

### Notas y buenas prácticas

- Validar `sortBy` contra una lista blanca de campos de la entidad para evitar SQL injection en el ORDER BY.
- Normalizar `sortDir` a `ASC` si el valor es nulo o inválido.
- Para filtros, el ejemplo une condiciones con `AND`; si se necesitan combinaciones más complejas (OR, rangos, BETWEEN), extender el builder según los casos.
- Si usas `PanacheEntity` o `PanacheEntityBase`, ajusta la llamada a `count()` si requieres conteo por filtros específicos (en el ejemplo `count()` trae total global; puedes reemplazarlo por `count(query, params)` para contar el mismo conjunto filtrado).

### Extensiones futuras

- Versión reactiva (`Mutiny` + `hibernate-reactive`) equivalente a `GenericRepository`, devolviendo `Uni<Pagina<T>>` y `Uni<List<T>>`.
- Recursos REST genéricos que acepten `PaginacionParametros` por query params y exportación (CSV/JSON) utilizando reflexión.


