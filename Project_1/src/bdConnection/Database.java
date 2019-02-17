package bdConnexion;

import java.sql.Connection;
import java.sql.SQLException; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource;


/**
 * La BDD:
 * user(user_id, user_login, user_password) 
 * session(session_key, user_session*, session_root, session_start)
 * follow(id_user1*, id_user2*, follow_date)
 */


public class Database {
	private DataSource dataSource;
	
	public Database(String jndiname) throws SQLException {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/" + jndiname);
		} catch (NamingException e) { 
		// Handle error that it’s not configured in JNDI. 17
			throw new SQLException(jndiname + " is missing in JNDI! : "+e.getMessage()); 
		} 
	} 
		
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}

