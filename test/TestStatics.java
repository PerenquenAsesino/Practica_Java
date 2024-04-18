package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import scr.model.statics.Genero;

public class TestStatics {


    @Test
    public void testCrearGenero() {
        Genero accion = Genero.ACCION;
        assertEquals(Genero.ACCION, accion);
    }


    @Test
    public void testGeneroID() {
        Genero accion = Genero.ACCION;
        Genero aventura = Genero.AVENTURA;
        Genero comedia = Genero.COMEDIA;
        Genero drama = Genero.DRAMA;
        Genero fantasia = Genero.FANTASIA;
        Genero terror = Genero.TERROR;
        Genero cienciaFiccion = Genero.CIENCIA_FICCION;
        Genero musicalDanza = Genero.MUSICAL_DANZA;
        Genero suspense = Genero.SUSPENSE;
        Genero western = Genero.WESTERN;
        Genero documental = Genero.DOCUMENTAL;
        Genero biografico = Genero.BIOGRAFICO;
        Genero romance = Genero.ROMANCE;

        assertEquals(accion.getId(), 1);
        assertEquals(aventura.getId(), 2);
        assertEquals(comedia.getId(), 3);
        assertEquals(drama.getId(), 4);
        assertEquals(fantasia.getId(), 5);
        assertEquals(terror.getId(), 6);
        assertEquals(cienciaFiccion.getId(), 7);
        assertEquals(musicalDanza.getId(), 8);
        assertEquals(suspense.getId(), 9);
        assertEquals(western.getId(), 10);
        assertEquals(documental.getId(), 11);
        assertEquals(biografico.getId(), 12);
        assertEquals(romance.getId(), 13);
    }
    
}
