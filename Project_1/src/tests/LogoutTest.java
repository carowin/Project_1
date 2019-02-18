package tests;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.LogoutS;

public class LogoutTest {

	public static void main(String[] args) {
		
		JSONObject json = null;
		
		try {
			json = LogoutS.logout("44e128a5");
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(json.toString());
	}
}
