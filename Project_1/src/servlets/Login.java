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

import services.LoginS;
  

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json = null;
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
	 	response.setContentType( " text / plain " );
		PrintWriter out = response.getWriter ();
		
		try {
			json = LoginS.login(login, password);
			out.println(json.toString());
			
		} catch (JSONException e) {
			out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
