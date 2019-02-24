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
	
	
	/** 
	 * Suppression d'un ami dans la liste des amis de l'utilisateur. 
	 * MAJ de la bdd.
	 * @param key, la cle de connexion
	 * @param id_friend, l'id de l'ami à ajouter
	 * @return json
	 */
	public static JSONObject removeFriend(String key, int id_friend) throws JSONException, SQLException{
		Connection connection = Database.getMySQLConnection();
		int id_user = ConnectionTools.getId_withKey(key, connection);
		String login_user = UserTools.getUserLogin(id_user, connection);
		String login_friend = UserTools.getUserLogin(id_friend, connection);
		
		if (key == null || id_friend == -1) {
			return ServiceTools.serviceRefused("Wrong Parameter", -1);
		}
		if(!UserTools.checkUser(login_user, connection)) {
			return ServiceTools.serviceRefused("User don't exist", -1);
		}
		if(!UserTools.checkUser(login_friend, connection)) {
			return ServiceTools.serviceRefused("User Friend don't exist", -1);
		}
		
		if(!FriendsTools.isFriend(id_user, id_friend, connection)) {
			return ServiceTools.serviceRefused("Not Friend", -1);
		}
		if(!FriendsTools.unfollowAccount(id_user, id_friend, connection)) {
			return ServiceTools.serviceRefused("Couldn't unfollow", -1);
		}
	
		JSONObject json=new JSONObject();
		json.put("Success", "ok");
		return json;
		
	}
}
