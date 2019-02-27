package services;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import bdConnection.Database;
import jsonMessage.ServiceTools;
import tools.ConnectionTools;
import tools.MessageTools;
import tools.UserTools;

public class DeleteCommentS {
	
	public static JSONObject deleteComment(String key, String id_message) throws SQLException, JSONException {
		Connection c = Database.getMySQLConnection();
		
		if(key == null || id_message == null) {
			return ServiceTools.serviceRefused("Wrong Parameter", -1);
		}
		if(!ConnectionTools.isConnected(key,c)){
			return ServiceTools.serviceRefused("Not connected",-1);
		}
		if(!MessageTools.idMessageExist(id_message)) {
			return ServiceTools.serviceRefused("Message doesn't exist", -1);
		}
		
		int id_user = ConnectionTools.getId_withKey(key, c);
		String login_user = UserTools.getUserLogin(id_user, c);
		String name_user = UserTools.getUserName(id_user, c);
		
		JSONObject json=new JSONObject();
		
		System.out.println("OK partie avant try");
		try {
			System.out.println("Rentre try");
			json = MessageTools.removeComment(id_message);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return json;
		}
}
 