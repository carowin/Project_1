package services;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import bdConnection.Database;
import jsonMessage.ServiceTools;
import tools.ConnectionTools;
import tools.FriendsTools;

public class FriendsIdS {
	public static JSONObject friendId(String key) throws SQLException, JSONException {
		JSONObject json = null;
		Connection connection = Database.getMySQLConnection();
		
		if(key==null){
			return ServiceTools.serviceRefused("Missing Parameter",-1);
		}
		int user_id = ConnectionTools.getId_withKey(key, connection);
		json = FriendsTools.getFriendsId(user_id, connection);
		
		return json;
	}
}
