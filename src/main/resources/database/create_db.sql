create table CATEGORIAS(
	ID integer NOT NULL,
	Nombre varchar(255),
	Clave varchar(255),
	PRIMARY KEY(ID)
);
create table OPCIONES(
	ID bigint NOT NULL,
	Caracter char,
	PRIMARY KEY(ID)
);
create table OPCIONES_BINARIAS(
	ID bigint NOT NULL,
	Letra char,
	Texto varchar(255) ,
	Opcion boolean,
	PRIMARY KEY(ID)
);

create table USUARIOS(
	ID bigint NOT NULL AUTO_INCREMENT,
	Email varchar(75) NOT NULL,
	Juego_id bigint,
	PRIMARY KEY(ID)
);

create table JUEGOS(
	ID bigint NOT NULL AUTO_INCREMENT,
	PRIMARY KEY(ID)
);

alter table USUARIOS add constraint USU$JUE foreign key(Juego_id) references JUEGOS(ID);

create table PREGUNTAS(
	ID bigint NOT NULL AUTO_INCREMENT,
	Codigo varchar(255) NOT NULL,
	Texto text(65535),
	Puntaje integer,
	Opciones varchar(255),
	Correcta varchar(255),
	Categoria_id integer,
	PRIMARY KEY(ID)
);

alter table PREGUNTAS add constraint PRE$CAT foreign key(Categoria_id) references CATEGORIAS(ID);

create table PREGUNTAS_JUEGOS(
	Pregunta_id bigint NOT NULL,
	Juego_id bigint,
	PRIMARY KEY(Pregunta_id,Juego_id)
);

alter table PREGUNTAS_JUEGOS add constraint PJ$PRE foreign key(Pregunta_id) references PREGUNTAS(ID);
alter table PREGUNTAS_JUEGOS add constraint PJ$JUE foreign key(Juego_id) references JUEGOS(ID);

create table MULTIPLES(
	ID bigint NOT NULL,
	Opcion_id bigint,
	PRIMARY KEY(ID)
);

alter table MULTIPLES add constraint MUL$PRE foreign key(ID) references PREGUNTAS(ID);
alter table MULTIPLES add constraint MUL$OPC foreign key(Opcion_id) references OPCIONES(ID);

create table BINARIAS(
	ID bigint NOT NULL,
	Opcion_binaria_id bigint,
	PRIMARY KEY(ID)
);
alter table BINARIAS add constraint BIN$PRE foreign key(ID) references PREGUNTAS(ID);
alter table BINARIAS add constraint BIN$OPB foreign key(Opcion_binaria_id) references OPCIONES_BINARIAS(ID);


