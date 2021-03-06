package tools;
   
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserTools {


	// REVOIR l'initialisation de id, peut etre initialisé par rapport au nombre d'elem dans la bdd
	
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
		
		String query = "SELECT * FROM user WHERE user_login = '"+login+"' AND user_password = '"+password+"';";
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery(query);
		boolean exist;
		
		if(result.next()) {
			exist = true;
		}else {
			exist = false;
		}
		System.out.println(exist);
		st.close();
		result.close();
		
		return exist;
	}
	
	/** 
	 * Methode d'insertion d'un utilisateur dans la base de donnee.
	 * @param login, le login de l'utilisateur
	 * @param password, son mot de passe
	 * @param mail, le mail associé à l'utilisateur
	 * @param name, le nom
	 * @param firstName, le prenom
	 * @param c, une connexion
	 * @return true si insertion réussie, false sinon.
	 */
	public static boolean insertUser(String login, String password, String mail, String name, String firstName, Connection c)throws SQLException{

		String update = "INSERT INTO user(user_login,user_password,user_mail,user_name,user_firstName)"
				+ " VALUES ('"+login+"','"+password+"','"+mail+"','"+name+"','"+firstName+"');";
		Statement st = c.createStatement();
		int result = st.executeUpdate(update);
		boolean exist;
		
		if(result == 1) {
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
		String query = "SELECT * FROM user WHERE user_login = '"+login+"';";
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
		
		String query = "SELECT * FROM user WHERE user_id = "+id+";";
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
	 * Retourne le nom d'un utilisateur à partir de son id
	 */
	public static String getUserName(int id, Connection c) throws SQLException {
		
		String query = "SELECT * FROM user WHERE user_id = "+id+";";
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery(query);
		String user_name;
		
		if(result.next()) {
			user_name = result.getString("user_name");
		}else {
			user_name = "Error";
		}
		st.close();
		result.close();
		
		return user_name;
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
	
	
	/**
	 * Retourne la liste des utilisateurs inscrit sur le site
	 * @throws SQLException 
	 */
	public static ArrayList<Integer> getListUsers(Connection c) throws SQLException{
		
		String query = "SELECT * FROM user";
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery(query);
		ArrayList<Integer> listUsers = new ArrayList<Integer>();
		
		while(result.next()) {
			listUsers.add(result.getInt("user_id"));
		}
		return listUsers;
	}
}

