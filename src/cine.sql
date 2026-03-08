CREATE DATABASE cine;

USE cine;

CREATE TABLE usuarios(
 id INT AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(50),
 password VARCHAR(50)
);

CREATE TABLE generos(
 id INT AUTO_INCREMENT PRIMARY KEY,
 nombre VARCHAR(50)
);

CREATE TABLE peliculas(
 id INT AUTO_INCREMENT PRIMARY KEY,
 titulo VARCHAR(100),
 anio INT
);

CREATE TABLE generos_peliculas(
 genero_id INT,
 pelicula_id INT
);

CREATE TABLE usuarios_peliculas_vistas(
 usuario_id INT,
 pelicula_id INT
);

INSERT INTO usuarios(nombre,password) VALUES ('juan','1234'),('ana','abcd');
INSERT INTO generos(nombre) VALUES ('Acción'),('Comedia'),('Drama');
INSERT INTO peliculas(titulo,anio) VALUES ('Matrix',1999),('Titanic',1997),('Superbad',2007);
INSERT INTO generos_peliculas(genero_id,pelicula_id) VALUES (1,1),(2,3),(3,2);
INSERT INTO usuarios_peliculas_vistas(usuario_id,pelicula_id) VALUES (1,1);