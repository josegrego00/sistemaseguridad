create database gestionsim;
use gestionsim;
show tables;

create table usuario(
id int primary key auto_increment,
username varchar(100) unique not null,
contrasenna varchar(100) not null,
rol varchar(100) not null,
nombre varchar(100) not null,
telefono varchar(20) not null,
email varchar(100) not null,
activo boolean not null
);

create table incidente(
id bigint primary key auto_increment,
titulo varchar(500) not null,
descripcion varchar(500),
id_tipo_incidente int not null,
prioridad varchar(100) not null,
estado varchar(100) not null,
id_usuario_reporte int not null,
id_usuario_responsable int not null,
reporte_creado timestamp not null,
reporte_cerrado timestamp
);

create table incidente_log(
id bigint primary key auto_increment,
id_incidente bigint not null,
accion varchar(1000) not null,
id_usuario_accion int not null,
fecha_accion_incidente timestamp,
notas varchar(200)
);

create table tipo_incidente(
    id int primary key auto_increment,
    nombre varchar(100) not null,
    descripcion varchar(255)
);


-- =========================
-- RELACIONES PARA INCIDENTE
-- =========================

ALTER TABLE incidente
ADD CONSTRAINT fk_incidente_tipo
FOREIGN KEY (id_tipo_incidente)
REFERENCES tipo_incidente(id);

ALTER TABLE incidente
ADD CONSTRAINT fk_incidente_usuario_reporte
FOREIGN KEY (id_usuario_reporte)
REFERENCES usuario(id);

ALTER TABLE incidente
ADD CONSTRAINT fk_incidente_usuario_responsable
FOREIGN KEY (id_usuario_responsable)
REFERENCES usuario(id);

-- ============================
-- RELACIONES PARA INCIDENTE_LOG
-- ============================

ALTER TABLE incidente_log
ADD CONSTRAINT fk_log_incidente
FOREIGN KEY (id_incidente)
REFERENCES incidente(id)
ON DELETE CASCADE;

ALTER TABLE incidente_log
ADD CONSTRAINT fk_log_usuario_accion
FOREIGN KEY (id_usuario_accion)
REFERENCES usuario(id);

-- Parte de Codigo para hacer pruebas --

show tables;
Select * from incidente;
describe incidente;
show create table tipo_incidente;

describe tipo_incidente;
