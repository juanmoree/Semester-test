# semester-test

1. Definición de Entidades
   Necesitaremos definir las siguientes entidades para manejar los datos de la aplicación:

- Usuario: Para almacenar información sobre los usuarios y administradores.
- Grado: Para representar los diferentes grados o cursos disponibles.
- Asignatura: Relacionada con un grado específico.
- Nivel: Cada asignatura tendrá diferentes niveles.
- Pregunta: Asociada a una asignatura y un nivel específico, incluirá las opciones de respuesta.
- Respuesta: Las posibles respuestas para cada pregunta, incluida la correcta.

2. Esquema de la Base de Datos

   - Usuarios: "id", "nombre", "correo", "contraseña", "rol".
   - Grados: "id", "nombre".
   - Asignaturas: "id", "nombre", "grado_id".
   - Niveles: "id", "nombre", "asignatura_id".
   - Preguntas: "id", "texto", "nivel_id".
   - Respuestas: "id", "texto", "pregunta_id", "correcta (booleano)".


3. Lógica de la Aplicación
- Autenticación y Roles:
  - Implementar la autenticación de usuarios y administradores.
  - Diferenciar roles en la aplicación para restringir el acceso a ciertas funcionalidades (CRUD de preguntas, exámenes, etc.).
   
- CRUD de Preguntas
   - Permitir que los administradores puedan crear, leer, actualizar y eliminar preguntas, así como sus respuestas asociadas.

- Lógica de Examinación
   - Examen Total: Seleccionar aleatoriamente 10 preguntas de cada nivel de las 9 asignaturas para conformar un examen de 50 preguntas. 
   - Examen por Asignatura:
     - Con nivel específico: Permitir al usuario seleccionar un nivel y generar un examen con preguntas específicas de ese nivel.
     - Sin nivel específico: Generar un examen con preguntas aleatorias de todos los niveles disponibles en esa asignatura.

- Examen como Invitado
  - Permitir a los usuarios no registrados realizar exámenes en modo invitado, sin necesidad de guardar sus resultados.

4. Implementación Técnica
   - Modelo: Definir las clases de entidad en Java usando JPA para mapear a la base de datos MySQL.
   - Vista: Crear plantillas Thymeleaf para las diferentes páginas de la aplicación (inicio de sesión, registro, menú principal, CRUD de preguntas, toma de exámenes).
   - Controlador: Implementar controladores en Spring Boot para manejar las solicitudes HTTP, interactuar con la base de datos a través de los servicios y devolver las vistas adecuadas.
   

5. Seguridad
   Implementar seguridad con Spring Security, dejando la configuración básica para más adelante enfocarse en la funcionalidad principal primero.


6. Escalabilidad
   Diseñar la aplicación de manera que sea fácil añadir más grados, asignaturas, niveles y preguntas en el futuro. Esto se puede lograr mediante un diseño de base de datos flexible y una arquitectura de software que permita la expansión sin requerir grandes cambios.
 
