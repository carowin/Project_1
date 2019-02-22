package services;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import bdConnection.Database;

import org.json.JSONException;
import jsonMessage.ServiceTools;
import tools.ConnectionTools;
import tools.UserTools;

public class CreateUserS {

	/**
	 * Methode de création d'un utilisateur. Verifie les paramètres passé en argument, et insertion
	 * du nouvel utilisateur dans la base de donnée
	 * @param login, login choisis par l'utilisateur
	 * @param password, mot de passe choisis
	 * @return JONObject 
	 * @throws SQLException 
	 * NORMALEMENT : createUser(String prenom, String nom, String login, String password)
	 * 				 return {}
	 * */
	public static JSONObject createUser(String login, String password, String mail, String nom, String prenom) throws JSONException, SQLException{
		Connection connection = Database.getMySQLConnection();
		JSONObject json = new JSONObject();
		if(login == null || password == null || password == null || password == null) {
			return ServiceTools.serviceRefused("Wrong Argument", 1);
		}
		if (UserTools.checkUser(login, connection)) {
			return ServiceTools.serviceRefused("User name already exist", 1000);
		}
		if (!UserTools.insertUser(login, password, connection)) {
			return ServiceTools.serviceRefused("Could not insert user", 1000);		
		}
		connection.close();
		json.put("Status", "succes");
		
		return json;
		}
	
	

}
