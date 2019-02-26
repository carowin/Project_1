package tools;
 
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.DBCursor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import bdConnection.DBStatic;
import bdConnection.Database;

public class MessageTools {
	
	/**
	 * Methode permettant d'ajouter un message
	 * @param key
	 * @param c
	 * @return
	 */
	public static JSONObject addComment(int id_user, String login_user, String name_user,String text) throws UnknownHostException, JSONException{
		GregorianCalendar calendar = new java.util.GregorianCalendar();
		Date d = calendar.getTime();
		
		MongoCollection<Document> message = Database.getMongoCollection(DBStatic.collection_msg);
		Document query = new Document();
		JSONObject json = new JSONObject();
		ObjectId id_comment = new ObjectId();
		query.append("id_comment", id_comment);
		query.append("id_user", id_user);
		query.append("name", name_user);
		query.append("login", login_user);
		query.append("date", d);
		query.append("content", text);
		
		message.insertOne(query);
		
		json.put("Success", "OK");
		
		return json;
	}
	
/*	public static JSONObject removeComment(int id_user, String login_user, String name_user, String id_comment, String text) throws UnknownHostException, JSONException{
		Document document = new Document();
		MongoCollection<Document> message = Database.getMongoCollection(DBStatic.collection_msg);
		document.append("id_comment", id_comment);
		MongoCursor<Document> cursor = message.find().iterator();
		
		
		return new JSONObject();
	}*/
	

}
