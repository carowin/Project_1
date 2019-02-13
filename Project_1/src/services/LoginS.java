package services;

import org.json.JSONException;
import org.json.JSONObject;

import bdConnexion.ConnectionTools;
import jsonMessage.ServiceTools;
import tools.UserTools;

public class LoginS {

	/**
	 * Methode permettant la connexion à l'application. Verification des valeurs des paramètres.
	 * Verifie le login de l'utilisateur dans la bdd ainsi que son password. Si tout ok connexion établie.
	 * @param login, le login de l'utilisateur
	 * @param password, le mot de passe associé
	 * @return JSONObject
	 */
	public static JSONObject login(String login, String password) throws JSONException{
		if(login==null || password==null) {
			return ServiceTools.serviceRefused("Wrong Argument", -1);
		}try {
			if(!UserTools.checkUser(login)){
				return ServiceTools.serviceRefused("Unkwnow User"+login, -1);
			}
			if(!UserTools.checkPassword(login,password)) {
				return ServiceTools.serviceRefused("Incorrect Password"+login, 2);
			}
			int user_id = UserTools.getUserId(login);
				//String key = ConnectionTools.generateKey();
			boolean c = ConnectionTools.insertConnection(user_id, false);
			if(c) {
				String key = ConnectionTools.generateKey();
				JSONObject json = new JSONObject();
				json.put("Succes", "OK");
				json.put("Login", login);
				json.put("User_Id", user_id);
				json.put("Key", key);
				return json;
			}
		}catch(JSONException e) {
			return ServiceTools.serviceRefused("Problème avec JSON", 100000);
		}
		catch (Exception e) {
			return ServiceTools.serviceRefused("Exception Problem", 10000);
		}
		return null;
	}
}
	
