package tests;

import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import services.DeleteCommentS;
import services.ListMessageS;

public class ListMessageTest {

	public static void main(String[] args) {
		try {
			ArrayList<Integer> tab_idusers = new ArrayList<Integer>();
			JSONObject json = ListMessageS.listMessage("27d302df-0e9a-4936-88c0-576fafdc6b54",null);
			System.out.println(json.toString());
		}catch(JSONException jex) {
			jex.printStackTrace();
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
}
