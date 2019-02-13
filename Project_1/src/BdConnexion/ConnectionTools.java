package BdConnexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class ConnectionTools {
	
	/**
	 * 
	 * @param id
	 * @param val
	 * @return
	 */
	public static boolean insertConnection(int id, boolean val) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {e.getMessage();}
		try {
			/*FINIR*/
			Connection connection = DriverManager.getConnection("jdbc.mysql://localhost:3306/mysql");
		}catch(SQLException e) {e.getMessage();}
		return false;	
	}
	
	/**
	 * Géneration d'une clef de 32 caractères
	 * @return la valeur de la clef
	 */
	public static String generateKey() {
		String key = new String();
		return key;
	}
	
	public static boolean isConnected(int key, Connection c) {
		/*finir*/
		return false;
	}
	
}