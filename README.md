# Foro Hub API

API REST para la gestión de un foro, que permite registrar, listar, actualizar y eliminar tópicos relacionados con cursos y usuarios.

## Funcionalidades

- Registro de nuevos tópicos con validación y control de duplicados.
- Listado paginado de tópicos con filtros opcionales por curso y año.
- Visualización del detalle de un tópico específico por ID.
- Actualización de tópicos con validación.
- Eliminación de tópicos.
- Manejo de relaciones entre Usuario, Curso y Tema.
- Validación robusta de datos usando @Valid y mensajes claros de error.
- Endpoints accesibles y probados mediante Insomnia o Postman.

## Endpoints disponibles

| Método | Ruta            | Descripción                          |
|--------|-----------------|------------------------------------|
| POST   | /temas          | Crear un nuevo tópico               |
| GET    | /temas          | Listar tópicos (paginado y filtrado)|
| GET    | /temas/{id}     | Obtener detalle de un tópico        |
| PUT    | /temas/{id}     | Actualizar un tópico                 |
| DELETE | /temas/{id}     | Eliminar un tópico                  |

## Uso con Insomnia

- Para crear o actualizar, envía un JSON con título, mensaje, autor (ID) y curso (ID).
- Para listar, puedes agregar query params `curso` y `año` junto con paginación.
- Para obtener detalle, usar GET con ID en la ruta.
- Para eliminar, usar DELETE con ID en la ruta.

---

