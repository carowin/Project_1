package tests;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.LoginS;
 

public class LoginTest {

	public static void main(String[] args) {
		
		JSONObject json = null;
		
		try {
			/*json = LoginS.login("azerty", "1234567");
			json = LoginS.login("albert", "totot");
			json = LoginS.login("alphonse", "bobo");
			json = LoginS.login("chapelin", "hahaha");*/
			
			json= LoginS.login("colin", "linlinlin");
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(json.toString());
	}
}


  