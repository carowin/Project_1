package tests;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.AddFriendS;
 
public class AddFriendTest {

	public static void main(String[] args) {
		
		JSONObject json = null;
		
		try {
			json = AddFriendS.addFriend("33343bf8-9e7c-4751-9dda-dae1522de121", 1);
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(json.toString());
	}
}

  
