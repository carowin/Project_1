package tests;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.DeleteCommentS;


public class RemoveCommentTest {

	public static void main(String[] args) {
		try {
			JSONObject json = DeleteCommentS.deleteComment("27d302df-0e9a-4936-88c0-576fafdc6b54","5c75ba21baa09644e191eb57");
			System.out.println(json.toString());
		}catch(JSONException jex) {
			jex.printStackTrace();
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}

}
