drop database if exists Simulacro;
create database Simulacro;

use Simulacro;

drop user if exists developer@localhost;
create user developer@localhost identified by '1234';

grant all privileges on Simulacro.Pacientes to developer@localhost;

grant all privileges on Simulacro.medicos to developer@localhost;

create table Pacientes (
	dni char(9) primary key,
	nombre varchar(50) not null,
	direccion varchar(100) not null,
	fecha_nacimiento date not null
);

create table medicos (
	dni char(9) primary key,
	nombre varchar(50) not null,
	direccion varchar(100) not null,
	fecha_nacimiento date not null,
    especialidad enum('Cirujano', 'Celador', 'Enfermero', 'Medico')
);

INSERT INTO medicos (dni, nombre, direccion, fecha_nacimiento, especialidad) VALUES
('12345678A', 'Dr. Juan Pérez García', 'Calle Mayor 123, Madrid', '1980-05-15', 'Cirujano'),
('23456789B', 'Dra. María López Sánchez', 'Avenida Libertad 45, Barcelona', '1975-11-22', 'Celador'),
('34567890C', 'Dr. Carlos Martínez Ruiz', 'Plaza España 7, Valencia', '1982-03-30', 'Enfermero'),
('45678901D', 'Dra. Ana Torres Jiménez', 'Calle Gran Vía 89, Sevilla', '1978-07-10', 'Medico'),
('56789012E', 'Dr. Javier Gómez Molina', 'Paseo Marítimo 12, Málaga', '1985-09-18', 'Enfermero');