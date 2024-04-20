package scr.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import scr.model.statics.Genero;

public class PeliculaDAO {
    private String path;

    public PeliculaDAO(String path) {
        this.path = path;
    }

     //Devuelve la lista de todas las Peliculas  
     public ArrayList<Pelicula> dameTodos() throws SQLException {
        String sql = "SELECT p.id, p.titulo, p.año, p.url_caratula, es_animacion, d.id AS director_id, d.nombre AS director_nombre, g.descripcion, g.id AS id_genero FROM peliculas p JOIN directores d ON p.id_director = d.id JOIN generos g ON p.id_genero = g.id;";
    
        Connection conn = new Utilidades().getConnection(path);
        Statement sentenciaSQL = conn.createStatement();
        ResultSet resultado = sentenciaSQL.executeQuery(sql);
    
        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
    
        while (resultado.next()) {
            Director director = new Director(resultado.getInt("director_id"), resultado.getString("director_nombre"));
    
            Pelicula pelicula = new Pelicula(
                resultado.getInt("id"),
                resultado.getString("titulo"),
                director,
                resultado.getInt("año"),
                resultado.getString("url_caratula"),
                Genero.getById(resultado.getInt("id_genero")),
                resultado.getBoolean("es_animacion"));
            
    
            listaPeliculas.add(pelicula);
        }
    
        conn.close();
        return listaPeliculas;
    }

    //Devuelve Pelicula buscando por ID
    public Pelicula buscaPorId(int id) throws SQLException {
        String sql = "SELECT p.id, p.titulo, p.año, p.url_caratula, es_animacion, d.id AS director_id, d.nombre AS director_nombre, g.descripcion, g.id AS id_genero FROM peliculas p JOIN directores d ON p.id_director = d.id JOIN generos g ON p.id_genero = g.id WHERE p.id = ?;";

        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setInt(1, id);
        ResultSet resultado = sentenciaSQL.executeQuery();

        Pelicula nuevo = null;

        while (resultado.next()) {
            Director director = new Director(resultado.getInt("director_id"), resultado.getString("director_nombre"));
    
            nuevo = new Pelicula(
                resultado.getInt("id"),
                resultado.getString("titulo"),
                director,
                resultado.getInt("año"),
                resultado.getString("url_caratula"),
                Genero.getById(resultado.getInt("id_genero")),
                resultado.getBoolean("es_animacion"));
            
        }
    
        conn.close();
        return nuevo;
    }

    //Devuelve Pelicula buscando por nombre
    public Pelicula buscaPorNombre(String titulo) throws SQLException {
        String sql = "SELECT p.id, p.titulo, p.año, p.url_caratula, es_animacion, d.id AS director_id, d.nombre AS director_nombre, g.descripcion, g.id AS id_genero FROM peliculas p JOIN directores d ON p.id_director = d.id JOIN generos g ON p.id_genero = g.id WHERE p.titulo = ?;";
       
        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setString(1, titulo);
        ResultSet resultado = sentenciaSQL.executeQuery();

        Pelicula nuevo = null;

        while (resultado.next()) {
            Director director = new Director(resultado.getInt("director_id"), resultado.getString("director_nombre"));
                
            nuevo = new Pelicula(
            resultado.getInt("id"),
            resultado.getString("titulo"),
            director,
            resultado.getInt("año"),
            resultado.getString("url_caratula"),
            Genero.getById(resultado.getInt("id_genero")), 
            resultado.getBoolean("es_animacion"));
    }
    
        conn.close();
        return nuevo;
    }
    
    // Inserta nueva Pelicula en la DB.
    public void inserta(Pelicula pelicula) throws SQLException {
        String sql = "INSERT INTO peliculas(id, titulo, id_director, año, url_caratula, id_genero, es_animacion) VALUES(?,?,?,?,?,?,?)";
    
        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setInt(1, pelicula.getId());
        sentenciaSQL.setString(2, pelicula.getTitulo());
        sentenciaSQL.setInt(3, pelicula.getDirector().getId());
        sentenciaSQL.setInt(4, pelicula.getAnyo());
        sentenciaSQL.setString(5, pelicula.getUrlCaratula());
        sentenciaSQL.setInt(6, pelicula.getGenero().getId());
        sentenciaSQL.setBoolean(7, pelicula.isAnimacion());
        sentenciaSQL.executeUpdate();
        conn.close();
    }

    //Elimina de la DB la Pelicula por ID
    public void borra(int id) throws SQLException {
        String sql = "DELETE FROM peliculas WHERE id = ?";

        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setInt(1, id);
        sentenciaSQL.executeUpdate();
        conn.close();
    }


    //Modifica los datos de Pelicula con esa ID
    public void modifica(Pelicula pelicula) throws SQLException {
        String sql = "UPDATE peliculas SET titulo = ?, id_director = ?, año = ?, url_caratula = ?, id_genero = ?, es_animacion = ? WHERE id = ?";
    
        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        
        sentenciaSQL.setString(1, pelicula.getTitulo());
        sentenciaSQL.setInt(2, pelicula.getId());
        sentenciaSQL.setInt(3, pelicula.getAnyo());
        sentenciaSQL.setString(4, pelicula.getUrlCaratula());
        sentenciaSQL.setInt(5, pelicula.getGenero().getId());
        sentenciaSQL.setBoolean(6, pelicula.isAnimacion());
        sentenciaSQL.setInt(7, pelicula.getId());
        sentenciaSQL.executeUpdate();
        conn.close();

    }
    
}
