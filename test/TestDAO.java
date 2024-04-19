package test;

import org.junit.Test;

import scr.model.Director;
import scr.model.DirectorDAO;
import scr.model.Utilidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;



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
        //Se instancia la clase para guardar los datos de la DB en un array y comprobarlos
        DirectorDAO dao = new DirectorDAO("./data/catalogo_peliculas.sqlite");
        ArrayList<Director> directores = dao.dameTodos();

        //Se verifica que todos los valores de una fila de la DB coincidan
        assertEquals(1, directores.size());
        assertEquals(1, directores.get(0).getId());
        assertEquals("www.foto", directores.get(0).getUrlFoto());
        assertEquals("www.web", directores.get(0).getUrlWeb());
        assertEquals("Jesucristo", directores.get(0).getNombre());

    }

    @Test
    public void testBuscaPorIdDirector() throws SQLException {
        DirectorDAO dao = new DirectorDAO("./data/catalogo_peliculas.sqlite");
        Director director = dao.buscaPorId(1);

        //Se verifica que todos los valores de una fila de la DB coincidan
        assertEquals(1, director.getId());
        assertEquals("www.foto", director.getUrlFoto());
        assertEquals("www.web", director.getUrlWeb());
        assertEquals("Jesucristo", director.getNombre());

    }

    @Test
    public void testBuscaPorNombreDirector() throws SQLException {
        DirectorDAO dao = new DirectorDAO("./data/catalogo_peliculas.sqlite");
        Director director = dao.buscaPorNombre("Jesucristo");

        //Se verifica que todos los valores de una fila de la DB coincidan
        assertEquals(1, director.getId());
        assertEquals("www.foto", director.getUrlFoto());
        assertEquals("www.web", director.getUrlWeb());
        assertEquals("Jesucristo", director.getNombre());
    }

    @Test   
    public void testInsertaDirector() throws SQLException {
        DirectorDAO dao = new DirectorDAO("./data/catalogo_peliculas.sqlite");
        //Se inserta el siguiente Director
        Director director = new Director(2, "CR7", "www.selfie", "www.tinder");
        dao.inserta(director);

        //Se verifica que todos los valores de una fila de la DB coincidan
        assertEquals(2, director.getId());
        assertEquals("www.selfie", director.getUrlFoto());
        assertEquals("www.tinder", director.getUrlWeb());
        assertEquals("CR7", director.getNombre());

        // TEST DE METODO borra() de DirectorDAO
        // Se borra el registro creado para no alterar la DB con los test
        // Elimina de la DB el director que concuerda con la ID introducida
        dao.borra(2);
    }


    @Test
    public void testModificaDirector() throws SQLException {
        DirectorDAO dao = new DirectorDAO("./data/catalogo_peliculas.sqlite");
        //Se modifica los datos del Director con esa ID
        Director director = new Director(1, "CR7", "www.selfie", "www.tinder");
        dao.modifica(director);

        //Se verifica que todos los valores de la fila de la DB coincidan
        assertEquals(1, director.getId());
        assertEquals("www.selfie", director.getUrlFoto());
        assertEquals("www.tinder", director.getUrlWeb());
        assertEquals("CR7", director.getNombre());

        // Se restaura el Director con ID 1 como estaba inicialmente para no afectar la DB
        Director restauraDirector = new Director(1, "Jesucristo", "www.foto", "www.web");
        dao.modifica(restauraDirector);
        
    }
    
}
