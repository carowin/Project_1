package tests;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.AddFriendS;
 
public class AddFriendTest {

	public static void main(String[] args) {
		
		JSONObject json = null;
		
		try {
			json = AddFriendS.addFriend("9f5a7a86-00d0-4ba5-8266-632acc721161", 2);
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(json.toString());
	}
}

  
