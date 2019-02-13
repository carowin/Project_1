package jsonMessage;

import org.json.JSONException;
import org.json.JSONObject;

public class ServiceTools {
	
	/**
	 * Géneration d'un JSON en cas d'erreur du service
	 * @param message, msg à afficher
	 * @param id, code erreur
	 * @throws JSONException
	 */
	public static JSONObject serviceRefused(String message, int id) throws JSONException {
		JSONObject json = new JSONObject();
		json.put("Message", message);
		json.put("Id", id);
		return json;
	}
	
	/**
	 * Géneration d'un JSON correspondant à une bonne exécution d'un service
	 * @return JSONObject, format json status ok
	 */
	public static JSONObject serviceAccepted() throws JSONException{
		JSONObject json = new JSONObject();
		json.put("Status", "ok");
		return json;
	}
	
	
}

 