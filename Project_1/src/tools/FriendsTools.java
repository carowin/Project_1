package tools;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import bdConnection.DBStatic;
import bdConnection.Database;

import java.sql.Connection;

public class FriendsTools {
  
		/**
		 * Methode permettant de follow un compte
		 * @param me, l'utilisateur
		 * @param account, le compte à suivre
		 * @param c, une connexion
		 * @return true en cas de reussite, false sinon
		 */
		public static boolean followAccount(int me, int friend, Connection c) throws SQLException{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		    LocalDateTime now = LocalDateTime.now(); 
			
			String update = "INSERT INTO follow(id_user1, id_user2, follow_date) "
					+ "values("+ me +","+ friend +",'"+ now +"');";
			Statement st = c.createStatement();
			int result = st.executeUpdate(update);
			boolean add_right;
			
			if(result == 1) {
				add_right = true;
			}else {
				add_right = false;
			}
			st.close();
			
			return add_right;
		}
		
		/**
		 * Methode permettant de unfollow un compte
		 * @param me, l'utilisateur
		 * @param account, le compte à suivre
		 * @param c, une connexion
		 * @return true en cas de reussite, false sinon
		 */
		public static boolean unfollowAccount(int me, int friend, Connection c) throws SQLException{
			String update = "DELETE FROM follow WHERE"
					+ " id_user1 ="+ me +" AND id_user2 ="+ friend +";";
			Statement st = c.createStatement();
			int result = st.executeUpdate(update);
			boolean delete_right;
			
			if (result == 1){
				delete_right = true;
			}else{
				delete_right = false;
			}
			st.close();
			
			return delete_right;
		}
		
		/**
		 * Methode permettant de déterminer si 2 personnes sont amis. Retourne vrai si c'est la cas, false sinon
		 * @param me, un utilisateur
		 * @param friend, un autre utilisateur
		 * @param c, une connexion
		 * @return true si les 2 sont amis, false sinon
		 */
		public static boolean isFriend(int me, int friend, Connection c) throws SQLException{
			String query = "SELECT * from follow WHERE id_user1='"+ me +"' AND id_user2='"+ friend+"';";
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery(query);
			boolean isFriend;
			
			if(result.next()) {
				isFriend = true;			
			}else {
				isFriend = false;
			}
			st.close(); 
			result.close();
			
			return isFriend;
		}
		
		public static ArrayList<Integer> getFriends(int id, Connection c) throws SQLException{
			String query = "SELECT * FROM follow WHERE id_user1="+ id +" OR id_user2="+id+";";
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery(query);
			
			ArrayList<Integer> listFriend = new ArrayList<Integer>();
			while(result.next()) {
				if(result.getInt("id_user1") == id) {
					listFriend.add(result.getInt("id_user2"));
				}else {
					listFriend.add(result.getInt("id_user1"));
				}
			}
			st.close();
			result.close();
			return listFriend;
		}
		
		
		public static JSONObject getFriendsName(int id, Connection c) throws JSONException, SQLException {
			JSONObject json = new JSONObject();
			JSONArray listFriendName = new JSONArray();
			
			ArrayList<Integer> listFriend = getFriends(id, c);

			for(Integer idFriend: listFriend) {
				String query = "SELECT * FROM user WHERE user_id="+ idFriend +";";
				Statement st = c.createStatement();
				ResultSet result = st.executeQuery(query);
				while(result.next()) {
					json.put("name",result.getString("user_login"));
					listFriendName.put(json.toString());
				}
			}
			JSONObject res = new JSONObject();
			return res.put("AmisName", listFriendName);	
		}
		
		public static JSONObject getFriendsId(int id, Connection c) throws JSONException, SQLException {
			JSONObject json = new JSONObject();
			JSONArray listFriendId = new JSONArray();
			
			ArrayList<Integer> listFriend = getFriends(id, c);

			for(Integer idFriend: listFriend) {
				String query = "SELECT * FROM user WHERE user_id="+ idFriend +";";
				Statement st = c.createStatement();
				ResultSet result = st.executeQuery(query);
				while(result.next()) {
					json.put("id",result.getString("user_id"));
					listFriendId.put(json.toString());
				}
			}
			JSONObject res = new JSONObject();
			return res.put("AmisId", listFriendId);	
		}
		
}
