package tests;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.CreateUserS;

public class CreateUserTest {

	public static void main(String[] args) {
		
		JSONObject json = null;
		
		try {
			json = CreateUserS.createUser("azerty", "1234567","azerty@gmail.com","uiop","azerty");
			json = CreateUserS.createUser("albert", "totot","coucou@gmail.com","to","albert");
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(json.toString());
	}
}
