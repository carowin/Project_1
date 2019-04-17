package tools;
 
import java.awt.List;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

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
		JSONObject json = new JSONObject();
		MongoCollection<Document> message = Database.getMongoCollection(DBStatic.collection_msg);
		Document query = new Document();	
		query.append("_id", new ObjectId(id_message));
		message.deleteOne(query);
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
		return exist;
	}
	
	/**
	 * Liste les message des id indiqués en paramètres
	 * @param id, tableau d'id
	 * retourne un json
	 */
	public static JSONObject listMessageOfIds(ArrayList<Integer> id) throws JSONException {
		MongoClient mongo = MongoClients.create("mongodb://" + DBStatic.mongo_host + ":" + DBStatic.mongo_port);
		MongoDatabase db =  mongo.getDatabase(DBStatic.mongo_bd);
		MongoCollection<Document> message = db.getCollection(DBStatic.collection_msg);
		//MongoCollection<Document> message = Database.getMongoCollection(DBStatic.collection_msg);
		Document query =new Document();
		
		//JSONArray msg = new JSONArray();
		ArrayList <JSONObject> msg = new ArrayList<JSONObject>();
		MongoCursor<Document> cursor = null;

		for(int i=0; i<id.size();i++) {
			query.append("id_user", id.get(i));
			FindIterable<Document> fi = message.find(query);
			cursor = fi.iterator();
			
			while(cursor.hasNext()) {
				JSONObject json = new JSONObject();
				Document obj = cursor.next();
				json.put("id_user",obj.get("id_user"));
				json.put("login",obj.get("login"));
				json.put("text",obj.get("content"));
				msg.add(json);
			}
		}
		
		if(cursor!=null) {
			cursor.close();
		}
		JSONObject res = new JSONObject();
		mongo.close();

		return res.put("Messages", msg);	
	}
	
	public static JSONObject sendPrivateMessage(String me, String friendId, String myMessage) throws JSONException {
		GregorianCalendar calendar = new java.util.GregorianCalendar();
		Date d = calendar.getTime();
		
		MongoCollection<Document> message = Database.getMongoCollection(DBStatic.collection_privateMessage);
		Document query = new Document();
		JSONObject json = new JSONObject();
		
		query.append("send", me);
		query.append("receive", friendId);
		query.append("date", d);
		query.append("content", myMessage);
		
		message.insertOne(query);
		
		json.put("Success", "OK");
		
		return json;
	}
	
	
	public static JSONObject getAllPrivateMessage(String me) throws JSONException {
		MongoClient mongo = MongoClients.create("mongodb://" + DBStatic.mongo_host + ":" + DBStatic.mongo_port);
		MongoDatabase db =  mongo.getDatabase(DBStatic.mongo_bd);
		MongoCollection<Document> message = db.getCollection(DBStatic.collection_privateMessage);
		Document query =new Document();
		ArrayList <JSONObject> msg = new ArrayList<JSONObject>();
		
		query.append("myfriend", me);
		FindIterable<Document> fi = message.find(query);
		MongoCursor<Document> cursor = fi.iterator();
		
		while(cursor.hasNext()) {
			JSONObject json = new JSONObject();
			Document obj = cursor.next();
			json.put("send",obj.get("send"));
			json.put("receive",obj.get("receive"));
			json.put("msg",obj.get("content"));
			msg.add(json);
		}
		
		if(cursor!=null) {
			cursor.close();
		}
		JSONObject res = new JSONObject();
		mongo.close();

		return res.put("Messages", msg);
			
	}
	
	

}
