package services;

import org.json.JSONException;
import org.json.JSONObject;

import bdConnection.Database;

import java.sql.Connection;
import java.sql.SQLException;

import jsonMessage.ServiceTools;
import tools.ConnectionTools;
import tools.UserTools;

public class LoginS {

	/**
	 * Methode permettant la connexion à l'application. Verification des valeurs des paramètres.
	 * Verifie le login de l'utilisateur dans la bdd ainsi que son password. Si tout ok connexion établie.
	 * @param login, le login de l'utilisateur
	 * @param password, le mot de passe associé
	 * @return JSONObject
	 * @throws SQLException 
	 */
	public static JSONObject login(String login, String password) throws JSONException, SQLException{
		
		Connection connection = Database.getMySQLConnection();
		JSONObject json = new JSONObject();
		if(login==null || password==null) {
			return ServiceTools.serviceRefused("Wrong Argument", -1);
		}
		
		if(!UserTools.checkUser(login, connection)){
			return ServiceTools.serviceRefused("Unkwnow User"+login, -1);
		}
		
		if(!UserTools.checkPassword(login,password, connection)) {
			return ServiceTools.serviceRefused("Incorrect Password"+login, 2);
		}
		int user_id = UserTools.getUserId(login, connection);
		String key = ConnectionTools.generateKey();
		ConnectionTools.insertConnection(user_id, key, connection);

		json.put("Succes", "OK");
		json.put("Login", login);
		json.put("User_Id", user_id);
		json.put("Key", key);
	
		return json;

	}
}
	
