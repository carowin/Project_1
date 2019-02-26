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
			json = CreateUserS.createUser("gilbert", "tatat","gilbert@gmail.com","tata","gilbert");
			json = CreateUserS.createUser("alphonse", "bobo","alphonse@gmail.com","bob","alphonse");
			json = CreateUserS.createUser("henry", "iv","henry@gmail.com","iv","henry");
			json = CreateUserS.createUser("charles", "charlie","cha@gmail.com","ly","charles");
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(json.toString());
	}
}
