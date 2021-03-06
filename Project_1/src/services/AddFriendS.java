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
	public static JSONObject addFriend(String key, String login_friend) throws JSONException, SQLException {
		
		Connection connection = Database.getMySQLConnection();
		int id_user = ConnectionTools.getId_withKey(key, connection);
		String login_user = UserTools.getUserLogin(id_user, connection);
		int id_friend = UserTools.getUserId(login_friend, connection);
		
		if (key == null || login_friend == null) {
			return ServiceTools.serviceRefused("Wrong Parameter", -1);
		}
		if(!ConnectionTools.connectionOneHour(key,connection)){
			return ServiceTools.serviceRefused("Connection expired",-1);
		}
		if(!UserTools.checkUser(login_user, connection)) {
			return ServiceTools.serviceRefused("User don't exist", -1);
		}
		if(!UserTools.checkUser(login_friend, connection)) {
			return ServiceTools.serviceRefused("User Friend don't exist", -1);
		}
		if(FriendsTools.isFriend(id_user, id_friend, connection)) {
			return ServiceTools.serviceRefused("Already Friend", -1);
		}
		if(!FriendsTools.followAccount(id_user, id_friend, connection)) {
			return ServiceTools.serviceRefused("Can't follow", -1);
		}

	
		JSONObject json=new JSONObject();
		json.put("Success", "ok");
		return json;
		
	}
}
