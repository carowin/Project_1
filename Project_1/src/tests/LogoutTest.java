package tests;
 
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.LogoutS;

public class LogoutTest {

	public static void main(String[] args) {
		
		JSONObject json = null;
		
		try {
			json = LogoutS.logout("de008883-bd14-4867-be4e-42ddf3de0687");
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(json.toString());
	}
}
  