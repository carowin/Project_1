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
	 * Insertion dans la table session de la connexion d'un user
	 * @param id, id de l'utilisateur
	 * @param key, la clé de l'utilisateur
	 * @param c, connection
	 * @return
	 */
	public static boolean insertConnection(int id, String key, Connection c) throws SQLException {
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {e.getMessage();}
		try {
			Connection connection = DriverManager.getConnection("jdbc.mysql://localhost:3306/mysql");
		}catch(SQLException e) {e.getMessage();}
		return false;*/	
		
		String update = "INSERT INTO session VALUES("+ key +","+ id +", true, true);";
		Statement st = c.createStatement();
		int result = st.executeUpdate(update);
		boolean insert_right;

		if (result == 1){
			insert_right = true;
		}else{
			insert_right = false;
		}
		st.close();
		return insert_right;
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