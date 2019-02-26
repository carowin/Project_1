package services;

import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;

import tools.ConnectionTools;
import tools.MessageTools;
import tools.UserTools;
import bdConnection.DBStatic;
import bdConnection.Database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import jsonMessage.ServiceTools;
  

public class AddCommentS {
	
	/**
	 * Methode permettant d'ajouter un commentaire sur son profil. Verification des paramètres.
	 * @param key, duree de la clef de l'utilisateur
	 * @param text, commentaire à inserer
	 * @return JSONObject
	 * @throws SQLException 
	 * @throws UnknownHostException 
	 */
	public static JSONObject addComment(String key, String content)throws JSONException, SQLException, UnknownHostException{
		Connection c = Database.getMySQLConnection();
		
		if(key == null || content == null) {
			return ServiceTools.serviceRefused("Wrong Parameter", -1);
		}
		if(!ConnectionTools.isConnected(key,c)){
			return ServiceTools.serviceRefused("Not connected",-1);
		}
		
		int id_user = ConnectionTools.getId_withKey(key, c);
		String login_user = UserTools.getUserLogin(id_user, c);
		String name_user = UserTools.getUserName(id_user, c);
		
		JSONObject json=new JSONObject();
		try {
			json = MessageTools.addComment(id_user, login_user, name_user, content);
		}catch(UnknownHostException unknown) {
			unknown.printStackTrace();
		}
		return json;
	}

}
