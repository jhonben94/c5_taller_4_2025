# 📘 Proyecto Final – Desarrollo de APIs con Quarkus

Este proyecto consiste en el **desarrollo de un conjunto de APIs REST con Quarkus**.  
Cada alumno elegirá un tema propio (ejemplo: sistema de biblioteca, reservas, inventario, ventas, etc.), pero deberá seguir las mismas **normas y buenas prácticas** definidas aquí.

---

## 1️⃣ Objetivo del Proyecto
- Diseñar y desarrollar **3 a 5 procesos principales** de un sistema.  
- Implementar dichos procesos como **APIs REST** con Quarkus.  
- Crear el **modelo de datos (DER)** que respalde el sistema.  
- Aplicar **buenas prácticas de programación, documentación y estándares REST**.  

---

## 2️⃣ Pasos a Seguir

### Paso 1 – Definir el Tema
- Escoge un **título del proyecto**.  
  Ejemplos:  
  - Gestión de Biblioteca  
  - Sistema de Reservas de Hotel  
  - Control de Inventario  

- Define entre **3 y 5 procesos principales**.  
  Ejemplo (Biblioteca):  
  1. Registrar libros  
  2. Gestionar préstamos  
  3. Gestionar devoluciones  

---

### Paso 2 – Diseñar el DER
- Diseña un **Diagrama Entidad-Relación (DER)** con:
  - Entidades principales  
  - Relaciones (1:1, 1:N, N:M)  
  - Claves primarias y foráneas  

- Buenas prácticas:  
  - Tablas en **plural**: `usuarios`, `libros`, `reservas`  
  - Columnas con prefijo `id_` para claves primarias: `id_usuario`, `id_libro`  
  - Campos de auditoría: `created_at`, `updated_at`  

---

### Paso 3 – Definir los Endpoints
- Sigue la convención REST:  

| Método | Endpoint              | Acción                  |
|--------|----------------------|-------------------------|
| GET    | /api/usuarios        | Listar todos            |
| GET    | /api/usuarios/{id}   | Obtener por ID          |
| POST   | /api/usuarios        | Crear nuevo             |
| PUT    | /api/usuarios/{id}   | Actualizar              |
| DELETE | /api/usuarios/{id}   | Eliminar                |

- Reglas:
  - Formato **JSON** en entrada y salida.  
  - Paginación: `?page=0&size=10` para listados.  
  - Usar códigos HTTP correctos (`200`, `201`, `404`, `500`).  

---

### Paso 4 – Implementar en Quarkus
Organiza el código en capas:

```
src/main/java/com/alumno/proyecto/
 ├── entity      → Entidades JPA
 ├── repository  → Repositorios
 ├── service     → Lógica de negocio
 └── resource    → Endpoints REST
```

Ejemplo de **respuesta genérica**:
```java
public class ApiResponse<T> {
    private String message;
    private int code;
    private T data;
}
```

---

### Paso 5 – Documentar
- Usar **OpenAPI/Swagger** con `quarkus-smallrye-openapi`.  
- Añadir un **README.md** con:
  - Título del proyecto  
  - Procesos definidos  
  - Imagen del DER  
  - Lista de endpoints  

---

### Paso 6 – Subir a GitHub
El repositorio debe contener:
- Código del proyecto  
- DER en formato imagen/PDF  
- README actualizado y claro  

---

### Paso 7 – Presentación en Clase
Cada alumno deberá:
1. Explicar su **tema y procesos principales**.  
2. Mostrar el **DER**.  
3. Hacer una **demo de 3 endpoints funcionando** (uno de ellos POST).  

---
