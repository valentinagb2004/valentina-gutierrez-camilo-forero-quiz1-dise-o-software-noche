CREATE DATABASE gestion_motocicleta;

USE gestion_motocicleta;

create table usuario ( 
cedula varchar(100) PRIMARY KEY,
contrasena varchar(100) NOT NULL
);

create table motocicleta (
id_motocicleta INT AUTO_INCREMENT PRIMARY KEY,
marca varchar(100) not null,
cilindraje int not null,
precio double not null,
color varchar (100) not null
);