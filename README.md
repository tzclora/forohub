# Foro Hub API

API REST para la gestión de un foro, que permite registrar, listar, actualizar y eliminar tópicos relacionados con cursos y usuarios.

---

## Funcionalidades

- Registro de nuevos tópicos con validación y control de duplicados.
- Listado paginado de tópicos con filtros opcionales por curso y año.
- Visualización del detalle de un tópico específico por ID.
- Actualización de tópicos con validación.
- Eliminación de tópicos.
- Manejo de relaciones entre Usuario, Curso y Tema.
- Validación robusta de datos usando `@Valid` y mensajes claros de error.
- Endpoints accesibles y probados mediante Insomnia o Postman.

---

## Endpoints disponibles

| Método | Ruta          | Descripción                        |
|--------|---------------|----------------------------------|
| POST   | `/temas`      | Crear un nuevo tópico             |
| GET    | `/temas`      | Listar tópicos (paginado y filtrado) |
| GET    | `/temas/{id}` | Obtener detalle de un tópico      |
| PUT    | `/temas/{id}` | Actualizar un tópico              |
| DELETE | `/temas/{id}` | Eliminar un tópico                |

---

## Uso con Insomnia o Postman

- Para **crear** o **actualizar** un tópico, envía un JSON con los siguientes campos:

```json
{
  "titulo": "Título del tópico",
  "mensaje": "Mensaje descriptivo",
  "autorId": 1,
  "cursoId": 2
}
## Para listar tópicos, puedes usar query params opcionales:

curso: filtrar por ID de curso

ano: filtrar por año

Parámetros de paginación como page y size

Ejemplo:
GET /temas?curso=2&ano=2024&page=0&size=10

Para obtener detalle de un tópico específico, usa:
GET /temas/{id}

Para eliminar un tópico, usa:
DELETE /temas/{id}

## Instalación
Clona el repositorio:

bash
Copiar
Editar
git clone https://github.com/tzclora/forohub.git
Navega al directorio:

bash
Copiar
Editar
cd forohub
Construye el proyecto con Maven:

bash
Copiar
Editar
mvn clean install
Ejecuta la aplicación:

bash
Copiar
Editar
mvn spring-boot:run
La API estará disponible en http://localhost:8080.

## Tecnologías utilizadas
Java 17+

Spring Boot 3

Spring Data JPA

Spring Security con JWT

Hibernate Validator (@Valid)

PostgreSQL (u otra base de datos relacional)

Maven

## Control de versiones
Este proyecto utiliza Git para control de versiones. Por favor, sigue el flujo de trabajo:

Haz un fork o clonación

Crea una rama para cada funcionalidad o fix (git checkout -b feature/nueva-funcionalidad)

Haz commits con mensajes claros y descriptivos

Envía un pull request para revisión

Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.

Contacto
Para dudas o sugerencias, puedes contactarme en:

GitHub: tzclora

## Notas finales
Recuerda enviar el token JWT en el encabezado Authorization con el prefijo Bearer para acceder a endpoints protegidos.

El manejo de errores y validaciones devuelve mensajes claros en formato JSON para facilitar la integración en frontend o pruebas.

¡Gracias por usar Foro Hub API! 🙌
