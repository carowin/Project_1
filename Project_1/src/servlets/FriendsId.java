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

import services.DeleteCommentS;
import services.FriendsIdS;
import services.ListFriendS;
import services.LoginS;

/**    
 * Servlet implementation class AddComment
 */
@WebServlet("/FriendsId")
public class FriendsId extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FriendsId() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		
		response.setContentType( " text / plain " );
		PrintWriter out = response.getWriter ();
		
		try {
			JSONObject json = FriendsIdS.friendId(key);
			out.println(json.toString());
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
	}

}
