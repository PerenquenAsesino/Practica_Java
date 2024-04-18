CREATE TABLE "directores" (
	"id"	INTEGER,
	"nombre"	TEXT NOT NULL,
	"url_foto"	TEXT,
	"url_web"	INTEGER,
	PRIMARY KEY("id")
);

CREATE TABLE "artistas" (
	"id"	INTEGER,
	"nombre"	TEXT NOT NULL,
	"url_foto"	TEXT,
	"url_web"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);

CREATE TABLE "generos" (
	"id"	INTEGER,
	"descripcion"	TEXT NOT NULL,
	PRIMARY KEY("id")
);

CREATE TABLE "peliculas" (
	"id"	INTEGER,
	"titulo"	TEXT NOT NULL,
	"id_director"	INTEGER,
	"año"	INTEGER,
	"url_caratula"	TEXT,
	"id_genero"	INTEGER,
	"es_animacion"	INTEGER,
	FOREIGN KEY("id_genero") REFERENCES "generos"("id"),
	FOREIGN KEY("id_director") REFERENCES "directores"("id"),
	PRIMARY KEY("id" AUTOINCREMENT)
);

CREATE TABLE "repartos" (
	"id_pelicula"	INTEGER,
	"id_artista"	INTEGER,
	FOREIGN KEY("id_pelicula") REFERENCES "peliculas"("id"),
	FOREIGN KEY("id_artista") REFERENCES "artistas"("id"),
	PRIMARY KEY("id_pelicula","id_artista")
);



