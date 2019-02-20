package services;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import bdConnection.Database;
import jsonMessage.ServiceTools;
import tools.ConnectionTools;
import tools.FriendsTools;
import tools.UserTools;

public class RemoveFriendS {
	
	public static JSONObject removeFriend(String key, String login_friend) throws JSONException, SQLException{
		Connection connection = Database.getMySQLConnection();
		String login_user = ConnectionTools.getLogin_withKey(key, connection);
		
		if (key == null || login_friend == null) {
			return ServiceTools.serviceRefused("Wrong Parameter", -1);
		}
		if(!UserTools.checkUser(login_friend, connection)) {
			return ServiceTools.serviceRefused("User don't exist", -1);
		}
		
		if(!FriendsTools.isFriend(login_user, login_friend, connection)) {
			return ServiceTools.serviceRefused("Not Friend", -1);
		}
		if(!FriendsTools.unfollowAccount(login_user, login_friend, connection)) {
			return ServiceTools.serviceRefused("Couldn't unfollow", -1);
		}
	
		JSONObject json=new JSONObject();
		json.put("Success", "ok");
		return json;
		
	}
}
