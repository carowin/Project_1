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
import tools.UserTools;

public class ListMessageS {

	public static JSONObject listMessage(String key, ArrayList<Integer> tab_iduser) throws SQLException, JSONException {
		JSONObject json = null;
		Connection connection = Database.getMySQLConnection();
		
		//Si pas de clé ni de liste d'id alors retourne l'ensemble des messages de tout les users
		if(key == null && tab_iduser == null) {
			ArrayList<Integer> listUsers = UserTools.getListUsers(connection);
			json = MessageTools.listMessageOfIds(listUsers);
		}
		
		//Si pas de cle mais une liste de users alors retourner la liste des users indiqué
		if(key == null && tab_iduser != null) {
			json = MessageTools.listMessageOfIds(tab_iduser);
		}
		
		/*Si key est donné et pas la liste alors on retourne tout les msg des amis de l'user si les deux sont renseignés alors 
		 * alors renvoyer messages de user et ses amis
		 */
		if(key != null) {
			int id = ConnectionTools.getId_withKey(key, connection);
			System.out.println("MyId"+id);
			ArrayList<Integer> listFriend = FriendsTools.getFriends(id, connection);
			
			if(tab_iduser == null) {
				json = MessageTools.listMessageOfIds(listFriend);
			}else {
				ArrayList<Integer> listIds = UserTools.getListUsers(connection);
				listIds.addAll(listFriend);
				json = MessageTools.listMessageOfIds(listIds);
			}
		}
		
		return json;
	}
}
