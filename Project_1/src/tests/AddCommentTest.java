package tests;
  
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.AddCommentS;

public class AddCommentTest {
	public static void main(String[] args) {
		try {
			JSONObject json = AddCommentS.addComment("33343bf8-9e7c-4751-9dda-dae1522de121", "Message tres!!!!");
			System.out.println(json.toString());
		}catch(JSONException jex) {
			jex.printStackTrace();
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		} catch (java.net.UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
  