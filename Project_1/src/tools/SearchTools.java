package tools;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONException;

public class SearchTools {

	public static ArrayList<String> searchFriend(String search, Connection c) throws SQLException{
		String query = "SELECT * FROM user WHERE user_login LIKE '"+ search +"%';";
		Statement st = c.createStatement();
		ResultSet result = st.executeQuery(query);
		ArrayList<String> searched = new ArrayList<String>();
		while(result.next()) {
			searched.add(result.getString("user_login"));
		}
		st.close();
		result.close();
		return searched;
	}  
}


