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
			tab_idusers.add(1);
			tab_idusers.add(11);
			JSONObject json = ListMessageS.listMessage(null,tab_idusers);
			System.out.println(json.toString());
		}catch(JSONException jex) {
			jex.printStackTrace();
		}catch(SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
}
