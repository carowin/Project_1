package tests;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.AddFriendS;
 
public class AddFriendTest {

	public static void main(String[] args) {
		
		JSONObject json = null;
		
		try {
			json = AddFriendS.addFriend("27d302df-0e9a-4936-88c0-576fafdc6b54", 2);
			json = AddFriendS.addFriend("27d302df-0e9a-4936-88c0-576fafdc6b54", 3);
			json = AddFriendS.addFriend("27d302df-0e9a-4936-88c0-576fafdc6b54", 4);
			
			
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(json.toString());
	}
}

  
