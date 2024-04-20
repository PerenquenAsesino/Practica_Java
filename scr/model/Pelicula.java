package scr.model;

import scr.model.statics.Genero;

public class Pelicula {

    private String titulo;
    private int anyo;
    private Genero genero;
    private boolean animacion;
    private int id;
    private String urlCaratula;
    private Director directores;

    public Pelicula(int id, String titulo, Director directores, int anyo, String urlCaratula, Genero genero, boolean animacion) {

        this.titulo = titulo;
        this.directores = directores;
        this.anyo = anyo;
        this.genero = genero;
        this.animacion = animacion;
        this.id = id;
        this.urlCaratula = urlCaratula;

    }
    
    public int getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public Director getDirector() {
        return directores;
    }
    public Genero getGenero() {
        return genero;
    }
    public int getAnyo() {
        return anyo;
    }
    public boolean isAnimacion() {
        return animacion;
    }
    public String getUrlCaratula() {
        return urlCaratula;
    }
  
}

