package test;

import org.junit.Test;

import scr.model.DirectorDAO;
import scr.model.Utilidades;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;



public class TestDAO {

    @Test
    public void testJDBCConecta() {

        boolean laClaseJDBCExiste = false;
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Todo ha ido bien");
            laClaseJDBCExiste = true;
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC no encontrado");
            e.printStackTrace();
        }
        
        assertTrue(laClaseJDBCExiste);
    }

    @Test
    public void testCrearConexion() throws SQLException {
        Utilidades utils = new Utilidades();

        Connection conn = utils.getConnection("./data/catalogo_peliculas.sqlite");
        assertNotNull(conn);
        conn.close();

        conn = utils.getConnection("./lolailoylere/qwerty_tests.sqlite");
        assertNull(conn);
    }
    
    @Test
    public void testDameTodosDirector() throws SQLException {
        DirectorDAO dao = new DirectorDAO();
        
    }

}
