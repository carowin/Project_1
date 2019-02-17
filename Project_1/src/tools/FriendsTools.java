package tools;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class FriendsTools {

		/**
		 * Methode permettant de follow un compte
		 * @param me, l'utilisateur
		 * @param account, le compte à suivre
		 * @param c, une connexion
		 * @return true en cas de reussite, false sinon
		 */
		public static boolean followAccount(String me, String account, Connection c) throws SQLException{
			return false;
		}
		
		/**
		 * Methode permettant de unfollow un compte
		 * @param me, l'utilisateur
		 * @param account, le compte à suivre
		 * @param c, une connexion
		 * @return true en cas de reussite, false sinon
		 */
		public static boolean unfollowAccount(String me, String account, Connection c) throws SQLException{
			return false;
		}
		
		
		//public static int nbFollower(String id, Connection c)

		

}
