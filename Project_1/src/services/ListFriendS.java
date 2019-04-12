package services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import bdConnection.Database;
import jsonMessage.ServiceTools;
import tools.ConnectionTools;
import tools.FriendsTools;

public class ListFriendS {

	public static JSONObject listFriend(String key) throws SQLException, JSONException {
		JSONObject json = null;
		Connection connection = Database.getMySQLConnection();
		
		if(key==null){
			return ServiceTools.serviceRefused("Missing Parameter",-1);
		}
		int user_id = ConnectionTools.getId_withKey(key, connection);
		json = FriendsTools.getFriendsName(user_id, connection);
		
		return json;
	}
}
