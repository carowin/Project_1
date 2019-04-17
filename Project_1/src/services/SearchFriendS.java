package services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import bdConnection.Database;
import jsonMessage.ServiceTools;
import tools.SearchTools;

public class SearchFriendS {

	public static JSONObject searchFriend(String query) throws JSONException, SQLException{
		Connection connection = Database.getMySQLConnection();
		JSONObject json = new JSONObject();
		
		if(query == null) {
			return ServiceTools.serviceRefused("Missing Argument", -1);
		}
		
		ArrayList<String> list = SearchTools.searchFriend(query, connection);
		json.put("search", list);
		
		return json;
		
	}
}
