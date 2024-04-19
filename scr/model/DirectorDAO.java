package scr.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DirectorDAO {
    private String path;

    public DirectorDAO(String path) {
        this.path = path;
    }

    // Devuelve la lista de todos los directores en la DB
    public ArrayList<Director> dameTodos() throws SQLException {
        String sql = "SELECT id, nombre, url_foto, url_web FROM directores";

        Connection conn = new Utilidades().getConnection(path);
        Statement sentenciaSQL = conn.createStatement();
        ResultSet resultado = sentenciaSQL.executeQuery(sql);

        ArrayList<Director> listaDirectores = new ArrayList<>();

        while (resultado.next()) {
            Director nuevo = new Director(
                    resultado.getInt("id"), 
                    resultado.getString("nombre"), 
                    resultado.getString("url_foto"), 
                    resultado.getString("url_web"));

            listaDirectores.add(nuevo);
        }
        conn.close();
        return listaDirectores;
    }

    // Devuelve Director buscando por ID
    public Director buscaPorId(int id) throws SQLException {
        String sql = "SELECT id, nombre, url_foto, url_web FROM directores WHERE id = ?";

        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setInt(1, id);
        ResultSet resultado = sentenciaSQL.executeQuery();
        
        Director nuevo = null;

        while (resultado.next()) {
            nuevo = new Director(
                    resultado.getInt("id"), 
                    resultado.getString("nombre"), 
                    resultado.getString("url_foto"), 
                    resultado.getString("url_web"));

        }
        conn.close();
        return nuevo;

    }

    // Devuelve Director buscando por nombre
    public Director buscaPorNombre(String nombre) throws SQLException {
        String sql = "SELECT id, nombre, url_foto, url_web FROM directores WHERE nombre = ?";

        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setString(1, nombre);
        ResultSet resultado = sentenciaSQL.executeQuery();
        
        Director nuevo = null;

        while (resultado.next()) {
            nuevo = new Director(
                    resultado.getInt("id"), 
                    resultado.getString("nombre"), 
                    resultado.getString("url_foto"), 
                    resultado.getString("url_web"));

        }
        conn.close();
        return nuevo;
        
    }
    
    // Añade en la DB un Director
    public void inserta(Director director) throws SQLException {
        String sql = "INSERT INTO directores(id, nombre, url_foto, url_web) VALUES(?, ?, ?, ?)";

        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setInt(1, director.getId());
        sentenciaSQL.setString(2, director.getNombre());
        sentenciaSQL.setString(3, director.getUrlFoto());
        sentenciaSQL.setString(4, director.getUrlWeb());
        sentenciaSQL.executeUpdate();
        conn.close();
    }

    // Elimina de la DB el director por ID
    public void borra(int id) throws SQLException {
        String sql = "DELETE FROM directores WHERE id = ?";

        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setInt(1, id);
        sentenciaSQL.executeUpdate();
        conn.close();
    }

    // Modifica los datos de Director con esa ID
    public void modifica(Director director) throws SQLException {
        String sql = "UPDATE directores SET nombre = ?, url_foto = ?, url_web = ? WHERE id = ?";
    
        Connection conn = new Utilidades().getConnection(path);
        PreparedStatement sentenciaSQL = conn.prepareStatement(sql);
        sentenciaSQL.setString(1, director.getNombre());
        sentenciaSQL.setString(2, director.getUrlFoto());
        sentenciaSQL.setString(3, director.getUrlWeb());
        sentenciaSQL.setInt(4, director.getId());
        sentenciaSQL.executeUpdate();
        conn.close();

    }
}