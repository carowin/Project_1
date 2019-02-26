package bdConnection;

public class DBStatic {  

	public static String mysql_host = "localhost";
	public static String mysql_bd = "huynh_rzeszutko";
	public static String mysql_user = "root";
	public static String mysql_password = "root";
	public static boolean mysql_pooling = true;
	
	/**
	 * SI TRAVAILLE SUR MAC: ALORS AJOUTER LE PORT
	 * SI SUR PPTI: ENLEVER ET RECREER À CHAQUE FOIS LA BDD
	 */
	
	public static String mysql_port = "8889";
	
	public static String mongo_bd = "mongo_hr";
	public static String collection_msg = "collection_message";
}
