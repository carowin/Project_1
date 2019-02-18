package tools;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.mysql.jdbc.Connection;

public class FriendsTools {

		/**
		 * Methode permettant de follow un compte
		 * @param me, l'utilisateur
		 * @param account, le compte à suivre
		 * @param c, une connexion
		 * @return true en cas de reussite, false sinon
		 */
		public static boolean followAccount(String me, String friend, Connection c) throws SQLException{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		    LocalDateTime now = LocalDateTime.now(); 
			
			String update = "INSERT INTO follow(id_user1, id_user2, follow_date) "
					+ "values('"+ me +"','"+ friend +"','"+ now +"');";
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
		public static boolean unfollowAccount(String me, String friend, Connection c) throws SQLException{
		
			String update = "DELETE FROM follow WHERE"
					+ " id_user1 ='"+ me +"' AND id_user2 ='"+ friend +"';";
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
		
		
		//public static int nbFollower(String id, Connection c){}

		

}
