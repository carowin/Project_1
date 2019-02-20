package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTools {

	// REVOIR l'initialisation de id, peut etre initialisé par rapport au nombre d'elem dans la bdd
	public static int id = 1; //Variable globale pour l'id d'un utilisateur
	
	
	/** 
	 * Methode permettant de verifier si un utilisateur est dans la
	 * base de donnée.
	 * @param login, le login de l'utilisateur
	 * @param c, une connexion
	 * @return true, si l'utilisateur existe, false sinon
	 * */
	public static boolean checkUser(String login, Connection c) throws SQLException {

		String query = "SELECT user_login FROM user WHERE user_login = '"+login+"';";
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery(query);
		boolean exist;
		
		if(result.next()) {
			exist = true;
		}else {
			exist = false;
		}
		st.close();
		result.close();
		
		return exist;
	
	}
	
	/**
	 * Methode de vérification du mot de passe entré par un utilisateur.
	 * Verification dans la base de donnée des informations.
	 * @param login, le login de l'utilisateur
	 * @param password, mot de passe de l'utilisateur
	 * @param c, une connexion
	 * @return true si tout est correct, false sinon
	 * */
	public static boolean checkPassword(String login, String password, Connection c) throws SQLException {
		
		String query = "SELECT user_login FROM user WHERE user_login = '"+login+"' AND user_password = '"+password+"';";
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery(query);
		boolean exist;
		
		if(result.next()) {
			exist = true;
		}else {
			exist = false;
		}
		st.close();
		result.close();
		
		return exist;
	}
	
	/** 
	 * Methode d'insertion d'un utilisateur dans la base de donnee.
	 * @param login, le login de l'utilisateur
	 * @param password, son mot de passe
	 * @param c, une connexion
	 * @return true si insertion réussie, false sinon.
	 */
	public static boolean insertUser(String login, String password, Connection c) throws SQLException{

		String update = "INSERT INTO user(user_id, user_login, user_password) values("+id+",'"+login+"','"+password+"');";
		Statement st = c.createStatement();
		int result = st.executeUpdate(update);
		boolean exist;
		
		if(result == 1) {
			id ++; //incrementation de l'id pour le prochain utilisateur
			exist = true;
		}else {
			exist = false;
		}
		st.close();
		
		return exist;
	}
	
	/**
	 * Retourne l'id d'un utilisateur à partir de son login
	 * @param login de l'utilisateur
	 * @param c, une connexion
	 * @return l'id de l'utilisateur s'il existe, sinon retourne -1 en cas d'erreur
	 */
	public static int getUserId(String login, Connection c) throws SQLException {
		String query = "SELECT user_login FROM user WHERE user_login = '"+login+"';";
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery(query);
		int user_id;
		
		if(result.next()) {
			user_id = result.getInt("user_id");
		}else {
			user_id = -1;
		}
		st.close(); 
		result.close();
		
		return user_id;
		
	}
	
	/**
	 * Retourne le login d'un utilisateur à partir de son id, s'il n'existe pas retourne "Error"
	 * @param login de l'utilisateur
	 * @param c, une connexion
	 * @return l'id de l'utilisateur, "Error" en cas de problème
	 * @throws SQLException 
	 */
	public static String getUserLogin(int id, Connection c) throws SQLException {
		
		String query = "SELECT user_login FROM user WHERE user_id = "+id+";";
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
	 * Retourne la cle d'un utilisateur, si l'id n'existe pas alors retourne -1
	 * @param id, id de l'utilisateur
	 * @param c, une connexion
	 * @return la cle d'un utilisateur
	 */
	public static int getUserKey(int id, Connection c) throws SQLException {
		
		String query = "SELECT session_key FROM session WHERE user_session ="+id+";";
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery(query);
		int key;
		
		if(result.next()) {
			key = result.getInt("session_key");
		}else {
			key = -1;
		}
		st.close();
		result.close();
		
		return key;
	}
}

