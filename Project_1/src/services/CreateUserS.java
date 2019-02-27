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
	 * Methode de création d'un utilisateur. Verification des paramètres passé en argument, et insertion
	 * du nouvel utilisateur dans la base de donnée
	 * @param login, login choisis par l'utilisateur
	 * @param password, mot de passe choisis
	 * @param mail, le mail associé à l'utilisateur
	 * @param name, le nom
	 * @param firstName, le prenom
	 * @return JONObject 
	 * @throws SQLException 
	 * */
	public static JSONObject createUser(String login, String password, String mail, String name, String firstName) throws JSONException, SQLException{
		System.out.println("Rentre dans create user");
		Connection connection = Database.getMySQLConnection();
		JSONObject json = new JSONObject();
		if(login == null || password == null || password == null || password == null) {
			return ServiceTools.serviceRefused("Wrong Argument", 1);
		}
		if (UserTools.checkUser(login, connection)) {
			return ServiceTools.serviceRefused("User name already exist", 1000);
		}
		System.out.println("ok check user");
		if (!UserTools.insertUser(login, password, mail, name, firstName, connection)) {
			return ServiceTools.serviceRefused("Could not insert user", 1000);		
		}
		System.out.println("ok insert user");
		connection.close();
		json.put("Status", "succes");
		
		return json;
		}
	
	

}
