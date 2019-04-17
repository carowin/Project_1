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
import tools.MessageTools;
import tools.UserTools;

public class PrivateMessageS {
	public static JSONObject getMyPrivateMessage(String log) throws SQLException, JSONException {
		JSONObject json = null;
		Connection connection = Database.getMySQLConnection();
		
		if(log==null) {
			return ServiceTools.serviceRefused("Missing Parameter", -1);
		}
		
		json = MessageTools.getAllPrivateMessage(log);
		
		return json;
	}
	
	public static JSONObject sendAPrivateMessage(String log, String myfriend, String content) throws SQLException, JSONException {
		JSONObject json = null;
		Connection connection = Database.getMySQLConnection();
		
		if(log==null && myfriend==null && content==null) {
			return ServiceTools.serviceRefused("Missing Parameter", -1);
		}
		
		json = MessageTools.sendPrivateMessage(log, myfriend, content);
		
		return json;
	}
}
