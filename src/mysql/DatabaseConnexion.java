package mysql;

import java.sql.*;

public class DatabaseConnexion {
	
	private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL= "jdbc:mysql://localhost:3306/jdbcemploye";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	public DatabaseConnexion () {
		
		try {
			getClass();
			Class.forName(DRIVER_PATH);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("quelque chose d'anormal s'est passée");
		}
	}
	
	public Connection getConnection() throws SQLException {
		
		return  DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
	}
	
}
