package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.properties.DataBaseProperties;

public class JdbcUtils {
	private Connection con;
	private DataBaseProperties databaseProperties;
	
	public JdbcUtils() throws FileNotFoundException, IOException {
		databaseProperties = new DataBaseProperties();
	}
	
	public Connection connect() throws SQLException {
		String url = databaseProperties.getProperty("dbUrl");
		String name = databaseProperties.getProperty("username");
		String pass = databaseProperties.getProperty("password");
		
		con = DriverManager.getConnection(url, name, pass);
		return con;
	}
	
	public void disconnect() throws SQLException {
		con.close();
	}
}