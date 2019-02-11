package Tools;

public class UserTools {

	/** 
	 * Methode permettant de verifier si un utilisateur est dans la
	 * base de donnée.
	 * @param login, le login de l'utilisateur
	 * @return true, si l'utilisateur existe, false sinon
	 * */
	public static boolean checkUser(String login) {
		/* Connexion dans la base
		 * Parcours de la base pour chercher existance du login
		 * Valeur de retour
		 * Si ok return true sinon false
		 */
		return false;
	
	}
	
	/**
	 * Methode de vérification du mot de passe entré par un utilisateur.
	 * Verification dans la base de donnée des informations.
	 * @param login, le login de l'utilisateur
	 * @param password, mot de passe de l'utilisateur
	 * @return true si tout est correct, false sinon
	 * */
	public static boolean checkPassword(String login, String password) {
		/* Connexion dans la base 
		 * Verification du login et du password
		 * Check valeur de retour
		 * si ok return true sinon false 
		 */
		return false;
		
	}
	
	/** 
	 * Methode d'insertion d'un utilisateur dans la base de donnee.
	 * @param login, le login de l'utilisateur
	 * @param password, son mot de passe
	 * @return true si insertion réussie, false sinon.
	 */
	public static boolean insertUser(String login, String password){
		/* Connexion dans la base, verification avec checkUser si pas ok message erreur et return false
		 * Sinon maj de la bdd et return true 
		 * */
		return false;
	
	}
	
	/**
	 * @param login de l'utilisateur
	 * @return l'id de l'utilisateur
	 */
	public static int getUserId(String login) {
		
	}
}

