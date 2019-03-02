package tests;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.DeleteCommentS;


public class DeleteCommentTest {

	public static void main(String[] args) {
		try {
			JSONObject json = DeleteCommentS.deleteComment("33343bf8-9e7c-4751-9dda-dae1522de121","5c7b0ba18df4223667f9de9a");
			System.out.println(json.toString());
		}catch(JSONException jex) {
			jex.printStackTrace();
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
  
}
