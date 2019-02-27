package bdConnection;

public class DBStatic {  

	
//________________________SQL_________________________
	
	public static String mysql_host = "localhost";
	public static String mysql_bd = "huynh_rzeszutko";
	public static String mysql_user = "root";
	public static String mysql_password = "root";
	
	/**
	 * SI TEST LOCAL METTRE À FALSE
	 * SI TEST SERVEUR METTRE À TRUE
	 */
	public static boolean mysql_pooling = false;
	
	/**
	 * SI TRAVAILLE SUR MAC: ALORS AJOUTER LE PORT
	 * SI SUR PPTI: ENLEVER ET RECREER À CHAQUE FOIS LA BDD
	 */
	
	public static String mysql_port = "8889";


//________________________MONGO_______________________
	
	public static String mongo_host = "localhost";
	public static String mongo_bd = "huynh_rzeszutko";
	public static String collection_msg = "collection_message";
	public static String mongo_port = "27017";
	
}
