package scr.model;

import java.util.ArrayList;

public class PeliculaDAO {

     //Devuelve la lista de todas las Peliculas  ***Debe devolver las películas ordenadas por genero, año descencing, titulo. ***
     public ArrayList<Pelicula> dameTodos() {
        return null;
    }

    //Devuelve Pelicula buscando por ID
    public Pelicula buscaPorId(int id) {
        return null;
    }

    //Devuelve Pelicula buscando por nombre
    public Pelicula buscaPorNombre(String nombre) {
        return null;
    }

    //Elimina de la DB el Pelicula por ID
    public void borra(int id) {

    }

    //Modifica los datos de Pelicula
    public void modifica(Pelicula pelicula) {

    }
    
}

/*
a. dameTodos. Debe devolver las películas ordenadas por genero, año
descencing, titulo.

b. El resto de métodos exactamente igual que los de arriba.

c. Recuerda que en películas debe figurar el género y el nombre del director.
Puedes resolver esto con joins o con más llamadas a la base de datos
usando el DAO de directores.
 */