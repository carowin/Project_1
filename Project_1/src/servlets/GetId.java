package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.FriendsIdS;
import services.GetIdS;

/**    
 * Servlet implementation class AddComment
 */
@WebServlet("/GetId")
public class GetId extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GetId() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		
		response.setContentType( " text / plain " );
		PrintWriter out = response.getWriter ();
		
		try {
			JSONObject json = GetIdS.getId(login);
			out.println(json.toString());
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
	}
}