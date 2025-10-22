# API de Gestión de Torneos de Ajedrez - Ejemplos de Uso

## Descripción General

Esta API permite gestionar torneos de ajedrez con sistema de pareos suizos, incluyendo:
- Creación de torneos
- Inscripción de jugadores
- Generación de pareos suizos
- Registro de resultados
- Gestión de rondas

## Endpoints Principales

### 1. Gestión de Torneos

#### Crear Torneo Básico
```http
POST /api/v1/torneos-completos/crear-basico
Content-Type: application/json

{
  "nombre": "Torneo Nacional de Ajedrez 2025",
  "fechaInicio": "2025-03-01",
  "fechaFin": "2025-03-03",
  "lugar": "Centro de Convenciones",
  "rondas": 7,
  "directorTorneo": "Juan Pérez",
  "ritmoCodigo": "RAP",
  "tipoCodigo": "SUI"
}
```

#### Crear Torneo con Jugadores Existentes
```http
POST /api/v1/torneos-completos/crear-con-jugadores
Content-Type: application/json

{
  "nombre": "Torneo Nacional de Ajedrez 2025",
  "fechaInicio": "2025-03-01",
  "fechaFin": "2025-03-03",
  "lugar": "Centro de Convenciones",
  "rondas": 7,
  "directorTorneo": "Juan Pérez",
  "ritmoCodigo": "RAP",
  "tipoCodigo": "SUI",
  "idsJugadores": [1, 2, 3, 4, 5, 6, 7, 8],
  "datosAdicionalesJugadores": {
    "federacion": "PAR",
    "clubNombre": "Club de Ajedrez Central"
  }
}
```

#### Crear Torneo con Jugadores Nuevos
```http
POST /api/v1/torneos-completos/crear-con-jugadores
Content-Type: application/json

{
  "nombre": "Torneo Nacional de Ajedrez 2025",
  "fechaInicio": "2025-03-01",
  "fechaFin": "2025-03-03",
  "lugar": "Centro de Convenciones",
  "rondas": 7,
  "directorTorneo": "Juan Pérez",
  "ritmoCodigo": "RAP",
  "tipoCodigo": "SUI",
  "jugadoresNuevos": [
    {
      "nombre": "Carlos",
      "apellido": "García",
      "email": "carlos.garcia@email.com",
      "telefono": "+595981234567",
      "fechaNacimiento": "1990-05-15",
      "elo": 1800,
      "fideId": "PAR123456",
      "federacion": "PAR",
      "clubNombre": "Club Central",
      "fideK": 20,
      "federacionTorneo": "PAR",
      "clubNombreTorneo": "Club Central",
      "fideKTorneo": 20
    },
    {
      "nombre": "Ana",
      "apellido": "Martínez",
      "email": "ana.martinez@email.com",
      "telefono": "+595981234568",
      "fechaNacimiento": "1985-08-22",
      "elo": 1650,
      "fideId": "PAR123457",
      "federacion": "PAR",
      "clubNombre": "Club Central",
      "fideK": 20
    }
  ]
}
```

#### Crear Torneo con Jugadores Mixtos (Existentes + Nuevos)
```http
POST /api/v1/torneos-completos/crear-con-jugadores
Content-Type: application/json

{
  "nombre": "Torneo Nacional de Ajedrez 2025",
  "fechaInicio": "2025-03-01",
  "fechaFin": "2025-03-03",
  "lugar": "Centro de Convenciones",
  "rondas": 7,
  "directorTorneo": "Juan Pérez",
  "ritmoCodigo": "RAP",
  "tipoCodigo": "SUI",
  "idsJugadores": [1, 2, 3, 4],
  "jugadoresNuevos": [
    {
      "nombre": "Carlos",
      "apellido": "García",
      "email": "carlos.garcia@email.com",
      "elo": 1800,
      "federacionTorneo": "PAR",
      "clubNombreTorneo": "Club Central"
    },
    {
      "nombre": "Ana",
      "apellido": "Martínez",
      "email": "ana.martinez@email.com",
      "elo": 1650,
      "federacionTorneo": "PAR",
      "clubNombreTorneo": "Club Central"
    }
  ],
  "datosAdicionalesJugadores": {
    "federacion": "PAR",
    "clubNombre": "Club de Ajedrez Central"
  }
}
```

#### Inscribir Jugador Individual
```http
POST /api/v1/torneos-management/{idTorneo}/inscribir/{idJugador}
Content-Type: application/json

{
  "federacion": "PAR",
  "clubNombre": "Club de Ajedrez Central",
  "fideK": 20
}
```

#### Inscribir Múltiples Jugadores
```http
POST /api/v1/torneos-management/{idTorneo}/inscribir-masivos
Content-Type: application/json

{
  "idsJugadores": [9, 10, 11, 12],
  "datosAdicionalesJugadores": {
    "federacion": "PAR",
    "clubNombre": "Club de Ajedrez Central"
  }
}
```

### 2. Gestión de Pareos y Rondas

#### Generar Pareos para una Ronda
```http
POST /api/v1/pareos/torneos/{idTorneo}/rondas/{numeroRonda}/generar
```

#### Registrar Resultado de Partida
```http
PUT /api/v1/pareos/partidas/{idPartida}/resultado
Content-Type: application/json

{
  "resultado": "1-0"
}
```

**Resultados válidos:**
- `"1-0"` - Ganaron las blancas
- `"0-1"` - Ganaron las negras  
- `"1/2-1/2"` - Empate

#### Obtener Partidas de una Ronda
```http
GET /api/v1/pareos/rondas/{idRonda}/partidas
```

#### Finalizar Ronda
```http
POST /api/v1/pareos/rondas/{idRonda}/finalizar
```

### 3. Gestión de Jugadores

#### Crear Jugador Individual
```http
POST /api/v1/jugadores-management/crear
Content-Type: application/json

{
  "nombre": "Carlos",
  "apellido": "García",
  "email": "carlos.garcia@email.com",
  "telefono": "+595981234567",
  "fechaNacimiento": "1990-05-15",
  "elo": 1800,
  "fideId": "PAR123456",
  "federacion": "PAR",
  "clubNombre": "Club Central",
  "fideK": 20
}
```

#### Crear Múltiples Jugadores
```http
POST /api/v1/jugadores-management/crear-masivos
Content-Type: application/json

[
  {
    "nombre": "Carlos",
    "apellido": "García",
    "email": "carlos.garcia@email.com",
    "elo": 1800,
    "federacion": "PAR",
    "clubNombre": "Club Central"
  },
  {
    "nombre": "Ana",
    "apellido": "Martínez",
    "email": "ana.martinez@email.com",
    "elo": 1650,
    "federacion": "PAR",
    "clubNombre": "Club Central"
  }
]
```

#### Crear Jugadores e Inscribir en Torneo
```http
POST /api/v1/jugadores-management/crear-e-inscribir/{idTorneo}
Content-Type: application/json

[
  {
    "nombre": "Carlos",
    "apellido": "García",
    "email": "carlos.garcia@email.com",
    "elo": 1800,
    "federacionTorneo": "PAR",
    "clubNombreTorneo": "Club Central",
    "fideKTorneo": 20
  },
  {
    "nombre": "Ana",
    "apellido": "Martínez",
    "email": "ana.martinez@email.com",
    "elo": 1650,
    "federacionTorneo": "PAR",
    "clubNombreTorneo": "Club Central",
    "fideKTorneo": 20
  }
]
```

#### Inscribir Jugadores Mixtos (Existentes + Nuevos)
```http
POST /api/v1/jugadores-management/inscribir-mixtos/{idTorneo}
Content-Type: application/json

{
  "idsJugadoresExistentes": [1, 2, 3, 4],
  "jugadoresNuevos": [
    {
      "nombre": "Carlos",
      "apellido": "García",
      "email": "carlos.garcia@email.com",
      "elo": 1800,
      "federacionTorneo": "PAR",
      "clubNombreTorneo": "Club Central"
    },
    {
      "nombre": "Ana",
      "apellido": "Martínez",
      "email": "ana.martinez@email.com",
      "elo": 1650,
      "federacionTorneo": "PAR",
      "clubNombreTorneo": "Club Central"
    }
  ],
  "datosAdicionales": {
    "federacion": "PAR",
    "clubNombre": "Club de Ajedrez Central"
  }
}
```

### 4. Consultas y Estadísticas

#### Obtener Tabla de Posiciones
```http
GET /api/v1/torneos-management/{idTorneo}/tabla-posiciones
```

#### Obtener Participantes
```http
GET /api/v1/torneos-management/{idTorneo}/participantes
```

#### Obtener Estadísticas del Torneo
```http
GET /api/v1/torneos-management/{idTorneo}/estadisticas
```

#### Obtener Rondas de un Torneo
```http
GET /api/v1/pareos/torneos/{idTorneo}/rondas
```

### 5. Análisis de Performance

#### Obtener Performance de Jugador en Torneo Específico
```http
GET /api/v1/performance/jugador/{idJugador}/torneo/{idTorneo}
```

**Respuesta:**
```json
{
  "idJugador": 1,
  "nombreJugador": "Carlos",
  "apellidoJugador": "García",
  "eloInicial": 1800,
  "performanceCalculado": 1950,
  "puntosObtenidos": 5.5,
  "partidasJugadas": 7,
  "promedioEloOponentes": 1750.50,
  "categoriaPerformance": "Primera Categoría",
  "variacionElo": 150,
  "partidas": [
    {
      "idPartida": 1,
      "numeroRonda": 1,
      "eloOponente": 1700,
      "resultado": "1-0",
      "puntosObtenidos": 1.0,
      "color": "blancas",
      "nombreOponente": "Ana",
      "apellidoOponente": "Martínez"
    }
  ]
}
```

#### Obtener Performance de Jugador en Todos los Torneos
```http
GET /api/v1/performance/jugador/{idJugador}/todos-torneos
```

#### Obtener Estadísticas de Performance
```http
GET /api/v1/performance/jugador/{idJugador}/estadisticas
```

**Respuesta:**
```json
{
  "totalTorneos": 3,
  "mejorPerformance": 2100,
  "peorPerformance": 1800,
  "promedioPerformance": 1950,
  "performances": [...]
}
```

## Flujo Completo de un Torneo

### 1. Crear el Torneo
```bash
# Crear torneo con jugadores iniciales
curl -X POST "http://localhost:8080/api/v1/torneos-completos/crear-con-jugadores" \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Torneo Nacional 2025",
    "fechaInicio": "2025-03-01",
    "lugar": "Centro de Convenciones",
    "rondas": 7,
    "directorTorneo": "Juan Pérez",
    "ritmoCodigo": "RAP",
    "tipoCodigo": "SUI",
    "idsJugadores": [1, 2, 3, 4, 5, 6, 7, 8]
  }'
```

### 2. Iniciar el Torneo
```bash
curl -X POST "http://localhost:8080/api/v1/torneos-management/{idTorneo}/iniciar"
```

### 3. Generar Primera Ronda
```bash
curl -X POST "http://localhost:8080/api/v1/pareos/torneos/{idTorneo}/rondas/1/generar"
```

### 4. Registrar Resultados
```bash
# Para cada partida, registrar el resultado
curl -X PUT "http://localhost:8080/api/v1/pareos/partidas/{idPartida}/resultado" \
  -H "Content-Type: application/json" \
  -d '{"resultado": "1-0"}'
```

### 5. Finalizar Ronda
```bash
curl -X POST "http://localhost:8080/api/v1/pareos/rondas/{idRonda}/finalizar"
```

### 6. Generar Siguiente Ronda
```bash
curl -X POST "http://localhost:8080/api/v1/pareos/torneos/{idTorneo}/rondas/2/generar"
```

### 7. Repetir hasta completar todas las rondas

### 8. Finalizar Torneo
```bash
curl -X POST "http://localhost:8080/api/v1/torneos-management/{idTorneo}/finalizar"
```

## Estados del Sistema

### Estados de Torneo
- `P` - Pendiente (recién creado)
- `A` - Activo (en curso)
- `F` - Finalizado

### Estados de Ronda
- `P` - Pendiente (generada pero no iniciada)
- `A` - Activa (en curso)
- `F` - Finalizada

## Algoritmo de Pareos Suizos

El sistema implementa un algoritmo de pareos suizos que:

1. **Ordena jugadores** por puntos (descendente) y luego por ELO (descendente)
2. **Agrupa por puntos** para evitar enfrentamientos entre jugadores con puntuaciones muy diferentes
3. **Evita enfrentamientos repetidos** verificando partidas anteriores
4. **Asigna colores** priorizando al jugador con mayor ELO para las blancas
5. **Maneja números impares** dando bye al último jugador (recibe 1 punto automático)

## Códigos de Ritmo y Tipo

### Ritmos de Torneo (ejemplos)
- `RAP` - Rápido
- `BLA` - Blitz
- `CLA` - Clásico

### Tipos de Torneo (ejemplos)
- `SUI` - Suizo
- `ROB` - Round Robin
- `ELI` - Eliminación

## Manejo de Errores

La API devuelve códigos de estado HTTP apropiados:

- `200 OK` - Operación exitosa
- `201 Created` - Recurso creado exitosamente
- `400 Bad Request` - Datos inválidos o faltantes
- `404 Not Found` - Recurso no encontrado
- `500 Internal Server Error` - Error interno del servidor

Los errores incluyen un objeto JSON con el campo `error` describiendo el problema:

```json
{
  "error": "El torneo no existe"
}
```

## Nuevas Funcionalidades: Gestión de Jugadores

### Características Principales

#### **Creación de Jugadores Nuevos**
- ✅ Crear jugadores individuales con datos completos
- ✅ Crear múltiples jugadores en lote
- ✅ Validación de datos obligatorios (nombre, apellido)
- ✅ ELO por defecto (1200) si no se especifica
- ✅ Datos FIDE opcionales

#### **Inscripción Mixta**
- ✅ Combinar jugadores existentes y nuevos en una sola operación
- ✅ Datos específicos para el torneo (federación, club, FIDE K)
- ✅ Datos personales separados de datos del torneo
- ✅ Manejo de errores individual por jugador

#### **Flexibilidad de Datos**
- ✅ Datos personales: nombre, apellido, email, teléfono, fecha nacimiento
- ✅ Datos de ajedrez: ELO, FIDE ID, federación, club, FIDE K
- ✅ Datos específicos del torneo: federación, club, FIDE K para el torneo
- ✅ Campos opcionales con valores por defecto

### Casos de Uso

#### **1. Torneo con Jugadores Registrados**
```json
{
  "idsJugadores": [1, 2, 3, 4],
  "datosAdicionalesJugadores": {
    "federacion": "PAR",
    "clubNombre": "Club Central"
  }
}
```

#### **2. Torneo con Jugadores Nuevos**
```json
{
  "jugadoresNuevos": [
    {
      "nombre": "Carlos",
      "apellido": "García",
      "elo": 1800,
      "federacionTorneo": "PAR",
      "clubNombreTorneo": "Club Central"
    }
  ]
}
```

#### **3. Torneo Mixto (Recomendado)**
```json
{
  "idsJugadores": [1, 2, 3],
  "jugadoresNuevos": [
    {
      "nombre": "Carlos",
      "apellido": "García",
      "elo": 1800,
      "federacionTorneo": "PAR"
    }
  ],
  "datosAdicionalesJugadores": {
    "federacion": "PAR",
    "clubNombre": "Club Central"
  }
}
```

### Ventajas del Sistema

1. **Flexibilidad Total**: Permite cualquier combinación de jugadores
2. **Datos Separados**: Información personal vs. datos del torneo
3. **Validación Robusta**: Manejo de errores sin afectar otros jugadores
4. **Transaccional**: Operaciones atómicas para mantener consistencia
5. **Escalabilidad**: Manejo eficiente de grandes cantidades de jugadores

## Algoritmo de Cálculo de Performance

### Fórmula de Performance

El sistema utiliza la **fórmula estándar de FIDE** para calcular el performance:

```
Performance = PromedioEloOponentes + 400 × log₁₀(puntosObtenidos / partidasJugadas / (1 - puntosObtenidos / partidasJugadas))
```

### Categorías de Performance

| Performance | Categoría |
|-------------|-----------|
| ≥ 2800 | Super Gran Maestro |
| ≥ 2600 | Gran Maestro |
| ≥ 2400 | Maestro Internacional |
| ≥ 2200 | Maestro FIDE |
| ≥ 2000 | Candidato a Maestro |
| ≥ 1800 | Primera Categoría |
| ≥ 1600 | Segunda Categoría |
| ≥ 1400 | Tercera Categoría |
| ≥ 1200 | Cuarta Categoría |
| < 1200 | Quinta Categoría |

### Datos Calculados

- **Performance Calculado**: ELO de performance según fórmula FIDE
- **Promedio ELO Oponentes**: Promedio de ELO de todos los oponentes
- **Variación ELO**: Diferencia entre performance y ELO inicial
- **Categoría Performance**: Categoría correspondiente al performance
- **Detalle de Partidas**: Información de cada partida individual

## Consideraciones Técnicas

1. **Transacciones**: Las operaciones críticas están envueltas en transacciones
2. **Validaciones**: Se validan todos los datos de entrada
3. **Integridad**: Se mantiene la integridad referencial entre entidades
4. **Performance**: Los pareos se generan de manera eficiente
5. **Flexibilidad**: Permite torneos con o sin jugadores iniciales
6. **Gestión de Jugadores**: Creación e inscripción en una sola operación
7. **Manejo de Errores**: Continuidad en caso de errores individuales
8. **Datos Separados**: Información personal vs. datos específicos del torneo
9. **Análisis de Performance**: Cálculo automático usando fórmulas estándar de FIDE
10. **Categorización**: Clasificación automática por nivel de performance
