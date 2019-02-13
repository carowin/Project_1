package Services;

import org.json.JSONException;
import org.json.JSONObject;

import JsonMessage.ServiceTools;

public class RemoveFriendS {
	
	public static JSONObject removeFriend(String key, String id_friend) throws JSONException{
		if(id_friend == null || key == null) {
			return ServiceTools.serviceRefused("Wrong Parameter", -1);
		}
		JSONObject o = new JSONObject();
		return null;/*finir*/
	}
}
