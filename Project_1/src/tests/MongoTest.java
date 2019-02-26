package tests;

import com.mongodb.MongoClient;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.DB;


public class MongoTest {

	public static void main(String[] args) {
		MongoClient mongo = new MongoClient("localhost",27017);
		System.out.println("Success connexion");
	}
}
