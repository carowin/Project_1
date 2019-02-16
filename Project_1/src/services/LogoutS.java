package services;
import jsonMessage.ServiceTools;
import bdConnexion.ConnectionTools;
import bdConnexion.Database;
import java.sql.Connection;

import org.json.JSONException;
import org.json.JSONObject;
import java.sql.SQLException;
import bdConnexion.ConnectionTools;
import jsonMessage.ServiceTools;

public class LogoutS {
	/**
	 * Methode permettant la deconnexion d'un utilisateur. 
	 * @param key, duree de la clef de connexion
	 * @return JSONObject
	 */
	public static JSONObject logout(String key)throws JSONException, SQLException {

		Connection connection;
		
					/*???*/
		connection = ConnectionTools.getMySQLConnection();
		
		
		
		//verification que la cle ne soit pas nulle(pas d'autorisation de connexion)
		if(key==null){
			return ServiceTools.serviceRefused("Wrong Parameter",-1);
		}
		//Verification connection
		if(!ConnectionTools.isConnected(key, connection)){
			return ServiceTools.serviceRefused("No Connection", -1);
		}
		
		//ConnectionTools.removeConnection(key, connection);
		return ServiceTools.serviceAccepted();
	}
	
}
