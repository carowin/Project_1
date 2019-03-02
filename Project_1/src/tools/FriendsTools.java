package tools;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
			String query = "SELECT * FROM follow WHERE id_user1="+ id +";";
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery(query);
			
			ArrayList<Integer> listFriend = new ArrayList<Integer>();
			while(result.next()) {
				listFriend.add(result.getInt("id_user2"));
			}
			return listFriend;
		}
}
