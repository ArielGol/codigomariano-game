-- CATEGORIAS (sin cambios)
create table CATEGORIAS(
    ID integer NOT NULL,
    Nombre varchar(255),
    Clave varchar(255),
    PRIMARY KEY(ID)
);

-- OPCIONES_BINARIAS (con Texto y Opcion agregados)
create table OPCIONES_BINARIAS(
    ID bigint NOT NULL,
    Letra char,
    Texto varchar(255),
    Opcion boolean,
    PRIMARY KEY(ID)
);

-- USUARIOS (sin cambios)
create table USUARIOS(
    ID bigint NOT NULL AUTO_INCREMENT,
    Email varchar(75) NOT NULL,
    Juego_id bigint,
    PRIMARY KEY(ID)
);

-- JUEGOS (sin cambios)
create table JUEGOS(
    ID bigint NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(ID)
);

alter table USUARIOS add constraint USU$JUE 
    foreign key(Juego_id) references JUEGOS(ID);

-- PREGUNTAS (sin columnas Opciones ni Correcta)
create table PREGUNTAS(
    ID bigint NOT NULL AUTO_INCREMENT,
    Codigo varchar(255) NOT NULL,
    Texto text(65535),
    Puntaje integer,
    Categoria_id integer,
    PRIMARY KEY(ID)
);

alter table PREGUNTAS add constraint PRE$CAT 
    foreign key(Categoria_id) references CATEGORIAS(ID);

-- PREGUNTAS_JUEGOS (sin cambios)
create table PREGUNTAS_JUEGOS(
    Pregunta_id bigint NOT NULL,
    Juego_id bigint,
    PRIMARY KEY(Pregunta_id, Juego_id)
);

alter table PREGUNTAS_JUEGOS add constraint PJ$PRE 
    foreign key(Pregunta_id) references PREGUNTAS(ID);
alter table PREGUNTAS_JUEGOS add constraint PJ$JUE 
    foreign key(Juego_id) references JUEGOS(ID);

-- MULTIPLES (sin Opcion_id, solo hereda de PREGUNTAS)
create table MULTIPLES(
    ID bigint NOT NULL,
    PRIMARY KEY(ID)
);

alter table MULTIPLES add constraint MUL$PRE 
    foreign key(ID) references PREGUNTAS(ID);

-- RESPUESTAS (tabla nueva)
create table RESPUESTAS(
    ID bigint NOT NULL AUTO_INCREMENT,
    pregunta_id bigint NOT NULL,
    TEXTO varchar(255),
    CORRECTA boolean,
    PRIMARY KEY(ID)
);

alter table RESPUESTAS add constraint RES$MUL 
    foreign key(pregunta_id) references MULTIPLES(ID);

-- BINARIAS (sin cambios)
create table BINARIAS(
    ID bigint NOT NULL,
    Opcion_binaria_id bigint,
    PRIMARY KEY(ID)
);

alter table BINARIAS add constraint BIN$PRE 
    foreign key(ID) references PREGUNTAS(ID);
alter table BINARIAS add constraint BIN$OPB 
    foreign key(Opcion_binaria_id) references OPCIONES_BINARIAS(ID);