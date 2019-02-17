package services;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;
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
	 */
	
	/* POUR + TARD:
	 * ajouter les argument nom, prenom, mail ...
	 * */
	public static JSONObject createUser(String login, String password) throws JSONException, SQLException{
		
		Connection connection = ConnectionTools.getMySQLConnection();
		JSONObject json = new JSONObject();
		if(login == null || password == null) {
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
