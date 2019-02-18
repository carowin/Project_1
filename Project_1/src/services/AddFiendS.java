package services;

import java.sql.Connection;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import bdConnection.Database;
import jsonMessage.ServiceTools;
import tools.FriendsTools;
import tools.UserTools;

public class AddFiendS {
	/** 
	 * Ajout d'un ami dans la liste des amis de l'utilisateur. 
	 * MAJ de la bdd.
	 * @param key
	 * @param id_friend, l'id de l'ami à ajouter
	 * @return json
	 */
	public static JSONObject addFriend(String key, String login_friend) throws JSONException, SQLException {
		
		Connection connection = Database.getMySQLConnection();
		//login_user = ConnectionTools.getId(key_user, c);
		
		if (key == null || login_friend == null) {
			return ServiceTools.serviceRefused("Wrong Parameter", -1);
		}
		if(!UserTools.checkUser(login_friend, connection)) {
			return ServiceTools.serviceRefused("User don't exist", -1);
		}
		
		/*if(FriendTools.isFriend(login_user, login_friend, connection)) {
			return ServiceTools.serviceRefused("Already Friend", -1);
		}
		if(!FriendsTools.followAccount(login_user, login_friend, connection)) {
			return ServiceTools.serviceRefused("Can't follow", -1);
		}
		*/
		JSONObject json=new JSONObject();
		return json;
		
	}
}
