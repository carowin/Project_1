package tools;
 
import java.awt.List;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import bdConnection.DBStatic;
import bdConnection.Database;

public class MessageTools {
	
	
	/**
	 * Methode permettant d'ajouter un message
	 * @param id_user, id de l'utilisateur
	 * @param login_user, login de l'utilisateur
	 * @param name_user, name de l'utilisateur
	 * @param text, à inserer
	 */
	public static JSONObject addComment(int id_user, String login_user, String name_user,String text) throws UnknownHostException, JSONException{
		GregorianCalendar calendar = new java.util.GregorianCalendar();
		Date d = calendar.getTime();
		
		MongoCollection<Document> message = Database.getMongoCollection(DBStatic.collection_msg);
		Document query = new Document();
		JSONObject json = new JSONObject();
		//ObjectId id_comment = new ObjectId();
		//query.append("id_comment", id_comment);
		query.append("id_user", id_user);
		query.append("name", name_user);
		query.append("login", login_user);
		query.append("date", d);
		query.append("content", text);
		
		message.insertOne(query);
		
		json.put("Success", "OK");
		
		return json;
	}
	
	
	/**
	 * Supprime un document de la collection, ce document contient les informations du messages à supprimer
	 * @param id_message, l'identifiant du message
	 */
	public static JSONObject removeComment(String id_message) throws UnknownHostException, JSONException{
			
		MongoCollection<Document> message = Database.getMongoCollection(DBStatic.collection_msg);
		Document query = new Document();
			
		query.append("id_message", new ObjectId(id_message));
		message.deleteOne(query);
		JSONObject json = null;
		json.put("Success", "OK");
		
		return json;
	}  
	
	
	/**
	 * Methode permettant de verifier d'un message existe
	 * @param id_message, l'id du message
	 * @return true s'il existe, false sinon
	 */
	public static boolean idMessageExist(String id_message) {
		MongoCollection<Document> message = Database.getMongoCollection(DBStatic.collection_msg);
		Document query = new Document();
		
		query.append("_id",new ObjectId(id_message));
		FindIterable<Document> fi = message.find(query);
		MongoCursor<Document> cursor = fi.iterator();
		boolean exist;
		if(cursor.hasNext()) {
			exist = true;
		}else {
			exist =false;
		}
		System.out.println(exist);
		return exist;
	}
	
	public static JSONObject listMessageOfIds(ArrayList<Integer> id) throws JSONException {
		MongoCollection<Document> message = Database.getMongoCollection(DBStatic.collection_msg);
		Document query =new Document();
		JSONObject json = null;
		for(int i=0; i<id.size();i++) {
			query.append("id_user", id);
			FindIterable<Document> fi = message.find(query);
			MongoCursor<Document> cursor = fi.iterator();
			
			while(cursor.next() != null) {
				Document obj = cursor.next();
				json.put("Message de "+id,obj.get("content"));
				
			}
		}
		return json;	
	}
	
	

}
