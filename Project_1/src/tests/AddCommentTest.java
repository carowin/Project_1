package tests;
  
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.AddCommentS;

public class AddCommentTest {
	public static void main(String[] args) {
		try {
			JSONObject json = AddCommentS.addComment("27d302df-0e9a-4936-88c0-576fafdc6b54", "BONJOUR TOUT LE MONDE !!!!");
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
