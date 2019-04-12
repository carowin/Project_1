package tests;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import services.GetIdS;

public class GetIdTest {

	public static void main(String[] args) {
		
		JSONObject json = null;
		try {
			json = GetIdS.getId("azerty");
		} catch (SQLException | JSONException e) {
			e.printStackTrace();
		}
		System.out.println(json.toString());
	}
}
