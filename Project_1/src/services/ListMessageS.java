package services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.client.MongoCollection;

import bdConnection.DBStatic;
import bdConnection.Database;
import jsonMessage.ServiceTools;
import tools.ConnectionTools;
import tools.FriendsTools;
import tools.MessageTools;

public class ListMessageS {

	public static JSONObject listMessage(String key, ArrayList<Integer> tab_iduser) throws SQLException, JSONException {
		JSONObject json = null;
		Connection c = Database.getMySQLConnection();
		
		if(key == null && tab_iduser == null) {
			
		}
		if(key != null && tab_iduser == null) {
			int id = ConnectionTools.getId_withKey(key, c);
			ArrayList<Integer> listFriend = FriendsTools.getFriend(id, c);
			json = MessageTools.listMessageOfIds(listFriend);
		}
		if(key == null && tab_iduser != null) {
			json = MessageTools.listMessageOfIds(tab_iduser);
		}
		return json;
	}
}
