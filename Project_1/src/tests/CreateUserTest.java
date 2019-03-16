package tests;
 
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.CreateUserS;

public class CreateUserTest {

	public static void main(String[] args) {
		
		JSONObject json = null;
		
		try {
			/*json = CreateUserS.createUser("azerty", "1234567","azerty@gmail.com","uiop","azerty");
			json = CreateUserS.createUser("albert", "totot","coucou@gmail.com","to","albert");
			json = CreateUserS.createUser("gilbert", "tatat","gilbert@gmail.com","tata","gilbert");
			json = CreateUserS.createUser("alphonse", "bobo","alphonse@gmail.com","bob","alphonse");
			json = CreateUserS.createUser("henry", "iv","henry@gmail.com","iv","henry");
			json = CreateUserS.createUser("charles", "charlie","cha@gmail.com","ly","charles");
			CreateUser?login=aby&password=hy&mail=aby@yahoo.com&name=hy&firstName=aby
			CreateUser?login=aly&password=lyly&mail=aly@yahoo.com&name=ly&firstName=aly*/  
			
			json = CreateUserS.createUser("colin", "linlinlin","colmia@hotmail.com","mia","colin");
			
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(json.toString());
	}
}
  

//http://localhost:8080/Twister/Servlets/CreateUser?login=arnaud&password=qsdf&mail=arnaud@msn.com&name=le&prenom=arnaud
//http://localhost:8080/Twister/Servlets/Login?login=arnaud&password=qsdf

//http://localhost:8080/Twister/Servlets/AddComment?key=27d302df-0e9a-4936-88c0-576fafdc6b54&content=PIZZAAA