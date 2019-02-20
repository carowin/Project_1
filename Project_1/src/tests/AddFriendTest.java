package tests;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.AddFriendS;

public class AddFriendTest {

	public static void main(String[] args) {
		
		JSONObject json = null;
		
		try {
			json = AddFriendS.addFriend("44e128a5", "azertyuiop");
			
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(json.toString());
	}
}


