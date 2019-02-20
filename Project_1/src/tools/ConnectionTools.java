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
	 * Géneration d'une clef de 32 caractères
	 * @return la valeur de la clef
	 */
	public static String generateKey() {
		String key = UUID.randomUUID().toString();
		return key;
	}
	
	/**
	 * Accesseur à la clé d'un utilisateur, retourne la clé en cas de succes sinon retourne "ERROR"
	 * @param id d'un utilisateur
	 * @param c, une connexion
	 * @return
	 */
	public static String getKey(int id, Connection c) throws SQLException {
		String query =  "SELECT session_key FROM session WHERE user_id="+ id +";";
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery(query);
		
		String key;
		if(result.next()) {
			key = result.getString("session_key");
		}else {
			key = "Error";
		}
		st.close(); 
		result.close();
		
		return key;

	}
	
	/**
	 * Accesseur du login d'un utilisateur à partir de la cle de connexion
	 * @param key, clé de connexion
	 * @param c, une connexion
	 * @return le login de l'utilisateur
	 */
	public static String getLogin_withKey(String key, Connection c) throws SQLException {
		String query = "SELECT user_session FROM session WHERE session_key = '"+key+"';";
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery(query);
		String user_login;
		
		if(result.next()) {
			user_login = result.getString("user_login");
		}else {
			user_login = "Error";
		}
		st.close();
		result.close();
		
		return user_login;
	}
	
	/**
	 * Verifie si un utilisateur est connecte
	 * @param key, clé de l'utilisateur
	 * @param c, connexion 
	 * @return: true si l'utilisateur est connecté, false sinon
	 */
	public static boolean isConnected(String key, Connection c) throws SQLException {
		String query =  "SELECT *"
						+" FROM session "
						+" WHERE session_root=true"
						+" AND session_key='"+key+"';";

			Statement st = c.createStatement();
			ResultSet result = st.executeQuery(query);
			boolean connected;
			
			if(result.next()) {
				connected = true;
			}else {
				connected = false;
			}
			st.close();
			result.close();

		return connected;
	}
	
	
	/**
	 * Insertion dans la table session de la connexion d'un user
	 * @param id, id de l'utilisateur
	 * @param key, la clé de l'utilisateur
	 * @param c, connexion
	 * @return true si insertion reussie, false sinon
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
	 * Retire la connexion d'un utilisateur de la table session
	 * @param key, cle de l'utilisateur
	 * @param c, connexion
	 * @return true en cas de succes false sinon
	 * @throws SQLException 
	 */
	public static boolean removeConnection(String key, Connection c) throws SQLException {
		String update = "DELETE FROM session where session_key ="+key +";";
		Statement st = c.createStatement();
		int result = st.executeUpdate(update);
		boolean delete_right;
		
		if (result == 1){
			delete_right = true;
		}else{
			delete_right = false;
		}
		st.close();
		
		return delete_right;
		
	}
}