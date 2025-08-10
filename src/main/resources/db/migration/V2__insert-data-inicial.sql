-- Insertar usuario de prueba (contraseña: 123456)
INSERT INTO usuarios (nombre, email, contrasena)
VALUES ('Usuario Foro', 'usuario@foro.com', '$2a$10$DnTAl0SR/UyEhuZPVVEz6OZbVXOaSCt.OCz0KArAvBgZHzcEqbpS2');

-- Insertar curso de prueba
INSERT INTO cursos (nombre, categoria) VALUES ('Java Básico', 'Programación');

-- Insertar tópico de prueba
INSERT INTO topicos (titulo, mensaje, status, autor_id, curso_id)
VALUES ('Bienvenida', 'Este es el primer tópico de prueba', 'NO_RESPONDIDO', 1, 1);
