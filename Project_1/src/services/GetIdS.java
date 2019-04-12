package services;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import bdConnection.Database;
import jsonMessage.ServiceTools;
import tools.UserTools;

public class GetIdS {
	@SuppressWarnings("null")
	public static JSONObject getId(String login) throws SQLException, JSONException {
		JSONObject json=new JSONObject();;
		Connection connection = Database.getMySQLConnection();
		
		if(login==null){
			return ServiceTools.serviceRefused("Missing Parameter",-1);
		}
		int id = UserTools.getUserId(login, connection);
		json.put("id", id);
		return json;
	}

}
