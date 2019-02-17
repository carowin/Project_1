package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.mysql.jdbc.Driver;

import bdConnection.DBStatic;
import bdConnection.Database;

public class ConnectionTools {
	
	/**
	 * 
	 * @param id
	 * @param val
	 * @return
	 */
	// A REVOIR: les parametres
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
		String key = UUID.randomUUID().toString();
		return key;
	}
	
	/*Verifie si un utilisateur est connecte 
	 * et on suppose que 'key' et 'c' sont deja alloue ???*/
	public static boolean isConnected(String key, Connection c) {
		if ((c != null)&&(key != null)) {
			String query =  "SELECT *"
							+" FROM session "
							+" WHERE session_root=true"
							+" AND session_key='"+key+"';";
			Statement st;
			ResultSet rs;
			try {
				st = c.createStatement();
				rs = st.executeQuery(query);
				if(rs.first()) {
					rs.close();
					return true;
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}	
}