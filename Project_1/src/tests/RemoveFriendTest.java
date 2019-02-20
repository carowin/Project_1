package tests;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.RemoveFriendS;

public class RemoveFriendTest {

	public static void main(String[] args) {
		
		JSONObject json = null;
		
		try {
			json = RemoveFriendS.removeFriend("44e128a5", 1);
			
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(json.toString());
	}
}
