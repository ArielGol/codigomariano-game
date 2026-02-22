create table CATEGORIAS(
	ID integer NOT NULL,
	Nombre varchar(255) NOT NULL,
	Key varchar(255) NOT NULL,
	PRIMARY KEY(ID)
);
create table OPCIONES(
	ID integer NOT NULL,
	Caracter char NOT NULL,
	PRIMARY KEY(ID)
);
create table OPCIONES_BINARIAS(
	ID integer NOT NULL,
	Letra char NOT NULL,
	Texto varchar(255) NOT NULL,
	Opcion boolean NOT NULL,
	PRIMARY KEY(ID)
);

create table USUARIOS(
	ID integer NOT NULL AUTO_INCREMENT,
	Email varchar(75) NOT NULL,
	Juego_id integer NOT NULL,
	PRIMARY KEY(ID)
);

create table JUEGOS(
	ID integer NOT NULL AUTO_INCREMENT,
	PRIMARY KEY(ID)
);

alter table USUARIOS add constraint USU$JUE foreign key(Juego_id) references JUEGOS(ID);

create table PREGUNTAS(
	ID integer NOT NULL AUTO_INCREMENT,
	Codigo varchar(255) NOT NULL,
	Texto text(65535)NOT NULL,
	Puntaje integer,
	Opciones varchar(255) NOT NULL,
	Correcta varchar(255) NOT NULL,
	Categoria_id integer NOT NULL,
	PRIMARY KEY(ID)
);

alter table PREGUNTAS add constraint PRE$CAT foreign key(Categoria_id) references CATEGORIAS(ID);

create table PREGUNTAS_JUEGOS(
	Pregunta_id integer NOT NULL,
	Juego_id integer NOT NULL,
	PRIMARY KEY(Pregunta_id,Juego_id)
);

alter table PREGUNTAS_JUEGOS add constraint PJ$PRE foreign key(Pregunta_id) references PREGUNTAS(ID);
alter table PREGUNTAS_JUEGOS add constraint PJ$JUE foreign key(Juego_id) references JUEGOS(ID);

create table MULTIPLES(
	ID integer NOT NULL,
	Opcion_id integer NOT NULL,
	PRIMARY KEY(ID)
);

alter table MULTIPLES add constraint MUL$PRE foreign key(ID) references PREGUNTAS(ID);
alter table MULTIPLES add constraint MUL$OPC foreign key(Opcion_id) references OPCIONES(ID);

create table BINARIAS(
	ID integer NOT NULL,
	Opcion_binaria_id integer NOT NULL,
	PRIMARY KEY(ID)
);
alter table BINARIAS add constraint BIN$PRE foreign key(ID) references PREGUNTAS(ID);
alter table BINARIAS add constraint BIN$OPB foreign key(Opcion_binaria_id) references OPCIONES_BINARIAS(ID);


