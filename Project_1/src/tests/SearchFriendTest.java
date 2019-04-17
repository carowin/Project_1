package tests;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.RemoveFriendS;
import services.SearchFriendS;

public class SearchFriendTest {
	public static void main(String[] args) {
		JSONObject json = null;
		
		try {
			json = SearchFriendS.searchFriend("a");
			
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(json.toString());
	}
}
