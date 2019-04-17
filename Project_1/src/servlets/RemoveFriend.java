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

import services.RemoveFriendS;

  
/**  
 * Servlet implementation class RemoveFriend
 */
@WebServlet("/RemoveFriend")
public class RemoveFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RemoveFriend() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String loginFriend = request.getParameter("loginFriend");
		
	 	response.setContentType( " text / plain " );
		PrintWriter out = response.getWriter ();
		try {
			JSONObject json = RemoveFriendS.removeFriend(key,loginFriend);
			out.println("create user sorti");
			out.println(json.toString());
		} catch (JSONException e) {
			out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
