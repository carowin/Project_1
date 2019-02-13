package services;

import org.json.JSONException;
import org.json.JSONObject;

import jsonMessage.ServiceTools;
import tools.UserTools;

public class CreateUserS {

	/**
	 * Methode de création d'un utilisateur. Verifie les paramètres passé en argument, et insertion
	 * du nouvel utilisateur dans la base de donnée
	 * @param login, login choisis par l'utilisateur
	 * @param password, mot de passe choisis
	 * @return JONObject 
	 */
	
	/* POUR + TARD:
	 * ajouter les argument nom, prenom, mail ...
	 * */
	public static JSONObject createUser(String login, String password) throws JSONException{
		if(login == null || password == null) {
			return ServiceTools.serviceRefused("Wrong Argument", 1);
		}
		if (UserTools.checkUser(login)) {
			return ServiceTools.serviceRefused("User name already exist", 1000);
		}
		if (!UserTools.insertUser(login, password)) {
			return ServiceTools.serviceRefused("Could not insert user", 1000);		
			}
		//INSERT USER
		
		
		return new JSONObject();
		}
	
	

}
