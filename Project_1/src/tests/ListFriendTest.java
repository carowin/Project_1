package tests;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.ListFriendS;
import services.ListMessageS;

public class ListFriendTest {
	
	public static void main(String[] args) {
		
		JSONObject json = null;
		try {
			json = ListFriendS.listFriend("2ac661cd-da19-47e0-aceb-e142c3833463");
		} catch (SQLException | JSONException e) {
			e.printStackTrace();
		}
		System.out.println(json.toString());
	}

}
