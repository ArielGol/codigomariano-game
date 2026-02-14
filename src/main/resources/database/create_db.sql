create table USUARIOS(
	ID integer NOT NULL AUTO_INCREMENT,
	Email varchar(75) NOT NULL,
	PRIMARY KEY(ID)
);

create table JUEGOS(
	ID integer not null,
	PRIMARY KEY(ID)
);

alter table USUARIOS add constraint USU$JUE foreign key(ID) references JUEGOS(ID);

create table PREGUNTAS(
	ID integer NOT NULL AUTO_INCREMENT,
	Codigo varchar(255),
	Texto text(65535),
	Puntaje integer,
	Opciones varchar(255),
	Correcta varchar(255),
	Categoria_id integer NOT NULL,
	PRIMARY KEY(ID)
);

create table PREGUNTAS_JUEGOS(
	Pregunta_id integer NOT NULL,
	Juego_id integer NOT NULL,
	PRIMARY KEY(Pregunta_id,Juego_id)
);

alter table PREGUNTAS_JUEGOS add constraint PJ$PRE foreign key(Pregunta_id) references PREGUNTAS(ID);

alter table PREGUNTAS_JUEGOS add constraint PJ$JUE foreign key(Juego_id) references JUEGOS(ID);

create table CATEGORIAS(
	ID integer NOT NULL,
	Nombre varchar(255) NOT NULL,
	Key varchar(255) NOT NULL,
	PRIMARY KEY(ID)
);
create table MULTIPLES(
	ID integer NOT NULL,
	Opcion_id integer NOT NULL,
	PRIMARY KEY(ID)
);

alter table MULTIPLES add constraint MUL$PRE foreign key(ID) references PREGUNTAS(ID);

create table OPCIONES(
	ID integer NOT NULL,
	Caracter char NOT NULL,
	PRIMARY KEY(ID)
);

create table BINARIAS(
	ID integer NOT NULL,
	Opcion_binaria_id integer NOT NULL,
	PRIMARY KEY(ID)
);

alter table BINARIAS add constraint BIN$PRE foreign key(ID) references PREGUNTAS(ID);

create table OPCIONES_BINARIAS(
	ID integer NOT NULL,
	Letra char NOT NULL,
	Texto varchar(255) NOT NULL,
	Opcion boolean NOT NULL,
	PRIMARY KEY(ID)
);
