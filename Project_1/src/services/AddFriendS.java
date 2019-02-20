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

public class AddFriendS {
	
	/** 
	 * Ajout d'un ami dans la liste des amis de l'utilisateur. 
	 * MAJ de la bdd.
	 * @param key
	 * @param id_friend, l'id de l'ami à ajouter
	 * @return json
	 */
	public static JSONObject addFriend(String key, int id_friend) throws JSONException, SQLException {
		
		Connection connection = Database.getMySQLConnection();
		String login_user = ConnectionTools.getLogin_withKey(key, connection);
		String login_friend = UserTools.getUserLogin(id_friend, connection);
		
		if (key == null || id_friend == -1) {
			return ServiceTools.serviceRefused("Wrong Parameter", -1);
		}
		if(!UserTools.checkUser(login_friend, connection)) {
			return ServiceTools.serviceRefused("User don't exist", -1);
		}
		
		if(FriendsTools.isFriend(login_user, login_friend, connection)) {
			return ServiceTools.serviceRefused("Already Friend", -1);
		}
		if(!FriendsTools.followAccount(login_user, login_friend, connection)) {
			return ServiceTools.serviceRefused("Can't follow", -1);
		}
	
		JSONObject json=new JSONObject();
		json.put("Success", "ok");
		return json;
		
	}
}
