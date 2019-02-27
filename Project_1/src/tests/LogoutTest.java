package tests;
 
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.LogoutS;

public class LogoutTest {

	public static void main(String[] args) {
		
		JSONObject json = null;
		
		try {
			json = LogoutS.logout("92f91afe-48d8-4e90-9612-e650fbd0bfc1");
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(json.toString());
	}
}
  