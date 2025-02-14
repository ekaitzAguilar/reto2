package agenciaViajes.bbdd.gestores;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import agenciaViajes.bbdd.entidad.Aeropuerto;

class GestorAeropuertoTest {
	
	private GestorAeropuerto gestorAeropuerto;
	private Connection connection; 

	/**
	 * Crea la conexión y la tabla con datos para realizar la prueba
	 * @throws SQLException
	 */
	@Test
	void setUp() throws SQLException {
		connection = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "");
		gestorAeropuerto = new GestorAeropuerto();
        
        // Crear  tabla temporal
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE aeropuerto (cod_aeropuerto VARCHAR(10), ciudad VARCHAR(50));");
        
        // Metemos dos datos de prueba en el arrayList
        statement.execute("INSERT INTO aeropuerto (cod_aeropuerto, ciudad) VALUES ('A1', 'Madrid');");
        statement.execute("INSERT INTO aeropuerto (cod_aeropuerto, ciudad) VALUES ('A2', 'Barcelona');");
	}
	
	/**
	 * Se ejecuta el método, se verifica el resultado no sea nulo y que sean los correctos
	 * @throws SQLException
	 */
	@Test
	void testBuscarAeropuerto() throws SQLException {
		
		
        ArrayList<Aeropuerto> aeropuertos = gestorAeropuerto.buscarAeropuerto();

  
        assertNotNull(aeropuertos);
        
        
        assertEquals(2, aeropuertos.size());
        
        
        assertEquals("A1", aeropuertos.get(0).getCod_aeropuerto());
        assertEquals("Madrid", aeropuertos.get(0).getCiudad());
        assertEquals("A2", aeropuertos.get(1).getCod_aeropuerto());
        assertEquals("Barcelona", aeropuertos.get(1).getCiudad());
	}
	
	/**
	 * Se vacía la tabla y se verifica si está vacía
	 * @throws SQLException
	 */
	@Test
    void testBuscarAeropuertoSinResultados() throws SQLException {
        
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM aeropuerto;");

        ArrayList<Aeropuerto> aeropuertos = gestorAeropuerto.buscarAeropuerto();

        
        assertNotNull(aeropuertos);
        assertEquals(0, aeropuertos.size());
    }

}
