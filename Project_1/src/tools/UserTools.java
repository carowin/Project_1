package tools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bdConnexion.ConnectionTools;

public class UserTools {

	/** 
	 * Methode permettant de verifier si un utilisateur est dans la
	 * base de donnée.
	 * @param login, le login de l'utilisateur
	 * @return true, si l'utilisateur existe, false sinon
	 * @throws SQLException 
	 * */
	public static boolean checkUser(String login) throws SQLException {
		/* Connexion dans la base
		 * Parcours de la base pour chercher existance du login
		 * Valeur de retour
		 * Si ok return true sinon false
		 */
		Connection c = ConnectionTools.getMySQLConnection();
		String query = "SELECT user_login FROM user WHERE user_login = "+login+";";
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery(query);	
		
		String user_login =rs.getString("user_login");
		if(user_login != null) {
			return true;
		}
		return false;
	
	}
	
	/**
	 * Methode de vérification du mot de passe entré par un utilisateur.
	 * Verification dans la base de donnée des informations.
	 * @param login, le login de l'utilisateur
	 * @param password, mot de passe de l'utilisateur
	 * @return true si tout est correct, false sinon
	 * */
	public static boolean checkPassword(String login, String password) {
		/* Connexion dans la base 
		 * Verification du login et du password
		 * Check valeur de retour
		 * si ok return true sinon false 
		 */
		
		return false;
		
	}
	
	/** 
	 * Methode d'insertion d'un utilisateur dans la base de donnee.
	 * @param login, le login de l'utilisateur
	 * @param password, son mot de passe
	 * @return true si insertion réussie, false sinon.
	 */
	public static boolean insertUser(String login, String password){
		/* Connexion dans la base, verification avec checkUser si pas ok message erreur et return false
		 * Sinon maj de la bdd et return true 
		 * */
		return false;
	
	}
	
	/**
	 * @param login de l'utilisateur
	 * @return l'id de l'utilisateur
	 */
	public static int getUserId(String login) {
		return 1;
		
	}
}

