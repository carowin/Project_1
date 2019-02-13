package Services;

import java.sql.Connection;

import org.json.JSONException;
import org.json.JSONObject;

import BdConnexion.ConnectionTools;
import JsonMessage.ServiceTools;

public class LogoutS {
	/**
	 * Methode permettant la deconnexion d'un utilisateur. 
	 * @param key, duree de la clef de connexion
	 * @return JSONObject
	 */
	public static JSONObject logout(String key)throws JSONException{

		Connection connection;
					/*???*/
		//connection = Database.getMySQLConnection();
		
		
		
		//verification que la cle ne soit pas nulle(pas d'autorisation de connexion)
		if(key==null){
			return ServiceTools.serviceRefused("Wrong Parameter",-1);
		}
		//Verification connection
		if(!ConnectionTools.isConnected((new Integer(key)), connection)){
			return ServiceTools.serviceRefused("No Connection", -1);
		}
		
		//ConnectionTools.removeConnection(key, connection);
		return ServiceTools.serviceAccepted();
	}
	
}
