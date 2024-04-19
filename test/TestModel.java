package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import scr.model.Director;
import scr.model.Pelicula;
import scr.model.statics.Genero;

public class TestModel {

    @Test
    public void testCreateDirector() {
        Director director = new Director(1, "pepe");

        assertEquals(director.getId(),1);
        assertEquals(director.getNombre(),"pepe");
        
    }
    

    @Test
    public void testCreatePelicula() {

        Director director = new Director(1, "pepe");
        boolean animacion = false;

        Pelicula peli = new Pelicula("titanic", director, "1990", Genero.ACCION, animacion);

        assertEquals(peli.getTitulo(), "titanic");
        assertEquals(peli.getDirector().getNombre(), "pepe");
        assertEquals(peli.getFecha(), "1990");
        assertEquals(peli.getGenero(), Genero.ACCION);
        assertEquals(peli.esAnimacion(), false);

    }
}
