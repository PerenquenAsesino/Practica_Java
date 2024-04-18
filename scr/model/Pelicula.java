package scr.model;
import scr.model.statics.Genero;

public class Pelicula {

    private String titulo;
    private Director director;
    private String anyo;
    private Genero genero;
    private boolean animacion;
    

    public Pelicula(String titulo, Director director, String anyo, Genero genero, boolean animacion) {

        this.titulo = titulo;
        this.director = director;
        this.anyo = anyo;
        this.genero = genero;
        this.animacion = animacion;


    }


    public String getTitulo() {
        return titulo;
    }


    public Director getDirector() {
        return director;
    }


    public String getFecha() {
        return anyo;
    }


    public Genero getGenero() {
        return genero;
    }


    public boolean esAnimacion() {
        return animacion;
    }
    
}
