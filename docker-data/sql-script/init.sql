CREATE DATABASE microservicios_demo
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

\c microservicios_demo

/*--===================-- LIMA SCHEMA --===================--*/
CREATE SCHEMA lima
    AUTHORIZATION postgres;
	
CREATE TABLE lima.persona
(
    id_persona bigserial NOT NULL,
    nombres text COLLATE pg_catalog."default",
    apellidos text COLLATE pg_catalog."default",
    fecha_nacimiento date,
    estado boolean,
    CONSTRAINT "persona_pk" PRIMARY KEY (id_persona)
)

TABLESPACE pg_default;

ALTER TABLE lima.persona
    OWNER to postgres;
	
CREATE TABLE lima.usuario
(
    id_usuario bigserial NOT NULL,
    id_persona bigserial NOT NULL,
    usuario text NOT NULL,
    password text NOT NULL,
    estado boolean,
    CONSTRAINT usuario_pk PRIMARY KEY (id_usuario),
    CONSTRAINT usuario_persona_fk FOREIGN KEY (id_persona)
        REFERENCES lima.persona (id_persona) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE lima.usuario
    OWNER to postgres;
	
CREATE TABLE lima.empleado
(
    id_empleado bigserial NOT NULL,
    id_persona bigserial NOT NULL,
    correo text,
    telefono text,
    estado boolean,
    CONSTRAINT empleado_pk PRIMARY KEY (id_empleado),
    CONSTRAINT empleado_persona FOREIGN KEY (id_persona)
        REFERENCES lima.persona (id_persona) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE lima.empleado
    OWNER to postgres;
	
CREATE TABLE lima.proyecto
(
    id_proyecto bigserial NOT NULL,
    nombre text NOT NULL,
    descripcion text,
    fecha_inicio date NOT NULL,
    fecha_fin date,
    estado boolean NOT NULL,
    CONSTRAINT proyecto_pk PRIMARY KEY (id_proyecto)
)

TABLESPACE pg_default;

ALTER TABLE lima.proyecto
    OWNER to postgres;
	
CREATE TABLE lima.proyecto_empleado
(
    id_proyecto_empleado bigserial NOT NULL,
    id_proyecto bigserial NOT NULL,
    id_empleado bigserial NOT NULL,
    estado boolean NOT NULL,
    CONSTRAINT proyecto_empleado_pk PRIMARY KEY (id_proyecto_empleado),
    CONSTRAINT proyecto_empleado_proyecto_pk FOREIGN KEY (id_proyecto)
        REFERENCES lima.proyecto (id_proyecto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT proyecto_empleado_empleado_pk FOREIGN KEY (id_empleado)
        REFERENCES lima.empleado (id_empleado) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE lima.proyecto_empleado
    OWNER to postgres;

/*--===================-- QUECHUA SCHEMA --===================--*/

CREATE SCHEMA quechua
    AUTHORIZATION postgres;
	
CREATE TABLE quechua.persona
(
    id_persona bigserial NOT NULL,
    nombres text COLLATE pg_catalog."default",
    apellidos text COLLATE pg_catalog."default",
    fecha_nacimiento date,
    estado boolean,
    CONSTRAINT "persona_pk" PRIMARY KEY (id_persona)
)

TABLESPACE pg_default;

ALTER TABLE quechua.persona
    OWNER to postgres;
	
CREATE TABLE quechua.usuario
(
    id_usuario bigserial NOT NULL,
    id_persona bigserial NOT NULL,
    usuario text NOT NULL,
    password text NOT NULL,
    estado boolean,
    CONSTRAINT usuario_pk PRIMARY KEY (id_usuario),
    CONSTRAINT usuario_persona_fk FOREIGN KEY (id_persona)
        REFERENCES quechua.persona (id_persona) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE quechua.usuario
    OWNER to postgres;
	
CREATE TABLE quechua.empleado
(
    id_empleado bigserial NOT NULL,
    id_persona bigserial NOT NULL,
    correo text,
    telefono text,
    estado boolean,
    CONSTRAINT empleado_pk PRIMARY KEY (id_empleado),
    CONSTRAINT empleado_persona FOREIGN KEY (id_persona)
        REFERENCES quechua.persona (id_persona) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE quechua.empleado
    OWNER to postgres;
	
CREATE TABLE quechua.proyecto
(
    id_proyecto bigserial NOT NULL,
    nombre text NOT NULL,
    descripcion text,
    fecha_inicio date NOT NULL,
    fecha_fin date,
    estado boolean NOT NULL,
    CONSTRAINT proyecto_pk PRIMARY KEY (id_proyecto)
)

TABLESPACE pg_default;

ALTER TABLE quechua.proyecto
    OWNER to postgres;
	
CREATE TABLE quechua.proyecto_empleado
(
    id_proyecto_empleado bigserial NOT NULL,
    id_proyecto bigserial NOT NULL,
    id_empleado bigserial NOT NULL,
    estado boolean NOT NULL,
    CONSTRAINT proyecto_empleado_pk PRIMARY KEY (id_proyecto_empleado),
    CONSTRAINT proyecto_empleado_proyecto_pk FOREIGN KEY (id_proyecto)
        REFERENCES quechua.proyecto (id_proyecto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT proyecto_empleado_empleado_pk FOREIGN KEY (id_empleado)
        REFERENCES quechua.empleado (id_empleado) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE quechua.proyecto_empleado
    OWNER to postgres;
	

/*

--===================-- DEPRECATE --===================--

ALTER TABLE lima.usuario
    ALTER COLUMN id_persona DROP NOT NULL;
ALTER TABLE lima.usuario DROP CONSTRAINT usuario_persona_fk;



ALTER TABLE quechua.usuario
    ALTER COLUMN id_persona DROP NOT NULL;
ALTER TABLE quechua.usuario DROP CONSTRAINT usuario_persona_fk;

*/

/*--===================-- DATA --===================--*/


INSERT INTO lima.persona(
	nombres, apellidos, fecha_nacimiento, estado)
	VALUES ('Admin Lima', '', null, true);

INSERT INTO quechua.persona(
	nombres, apellidos, fecha_nacimiento, estado)
	VALUES ('Admin Quechua', '', null, true);

INSERT INTO lima.usuario(
	id_persona, usuario, password, estado)
	VALUES (1, 'admin.lima','$2y$12$iT4l4fGjyz8u22lRmLZ9c.uV5U4P9sLmDhPqUmtmvx7IpOuptV0Ai', true);
	
INSERT INTO quechua.usuario(
	id_persona, usuario, password, estado)
	VALUES (1, 'admin.quechua','$2y$12$iT4l4fGjyz8u22lRmLZ9c.uV5U4P9sLmDhPqUmtmvx7IpOuptV0Ai', true);
