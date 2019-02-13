package services;

import org.json.JSONException;
import org.json.JSONObject;

import jsonMessage.ServiceTools;

public class AddCommentS {
	
	/**
	 * Methode permettant d'ajouter un commentaire sur son profil. Verification des paramètres.
	 * @param key, duree de la clef de l'utilisateur
	 * @param text, commentaire à inserer
	 * @return JSONObject
	 */
	public static JSONObject addComment(String key, String text)throws JSONException{
		
		if(key == null || text == null) {
			return ServiceTools.serviceRefused("Wrong Parameter", -1);
		}
		JSONObject json=new JSONObject();
		
		return json;
	}
	
}
