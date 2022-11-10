DROP table if exists trabajadores;
DROP table IF EXISTS trabajador;

create table trabajador(
	id long auto_increment primary key,
	nombre varchar(250),
	apellido varchar(250),
    salario int,
	puesto varchar(250)
);

insert into trabajador (nombre, apellido, salario, puesto)values('Jose','Marin', 50000,'Directivo');
insert into trabajador (nombre, apellido, salario, puesto)values('Juan','Lopez', 50000,'Directivo');
insert into trabajador (nombre, apellido, salario, puesto)values('Pedro','Guillem', 35000,'Senior');
insert into trabajador (nombre, apellido, salario, puesto)values('Jordi','Martin', 35000,'Senior');
insert into trabajador (nombre, apellido, salario, puesto)values('Jonatan','Vicente', 25000,'Junior');
