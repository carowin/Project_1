package services;

import org.json.JSONException;
import org.json.JSONObject;

import jsonMessage.ServiceTools;

public class AddFiendS {
	/** 
	 * Ajout d'un ami dans la liste des amis de l'utilisateur. 
	 * MAJ de la bdd.
	 * @param key
	 * @param id_friend, l'id de l'ami à ajouter
	 * @return
	 * @throws JSONException 
	 */
	public static JSONObject addFriend(String key, String id_friend) throws JSONException {
		if (key == null || id_friend == null) {
			return ServiceTools.serviceRefused("Wrong Parameter", -1);
		}
		
		JSONObject json=new JSONObject();
		return json;
		
	}
}
