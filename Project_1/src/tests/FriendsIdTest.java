package tests;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.FriendsIdS;

public class FriendsIdTest {
	
	public static void main(String[] args) {
		
		JSONObject json = null;
		try {
			json = FriendsIdS.friendId("2ac661cd-da19-47e0-aceb-e142c3833463");
		} catch (SQLException | JSONException e) {
			e.printStackTrace();
		}
		System.out.println(json.toString());
	}

}
