package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.CreateUserS;


/**
 * Servlet implementation class CreateUser
 */
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateUser() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json = null;
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
	 	response.setContentType( " text / plain " );
		PrintWriter out = response.getWriter ();
		
		try {
			json = CreateUserS.createUser(login, password, mail, nom, prenom);
			out.println(json.toString());
		} catch (JSONException e) {
			out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
