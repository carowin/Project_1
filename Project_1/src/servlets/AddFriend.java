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

import services.AddFriendS;
/**
 * Servlet implementation class AddFriend
 */

//http://localhost:8080/Project_1/Servlets/AddFriend?key=e09811b8-5acf-4de2-8009-6d971864bfe8&id=1
@WebServlet("/AddFriend")
public class AddFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddFriend() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		
	 	response.setContentType( " text / plain " );
		PrintWriter out = response.getWriter ();
		try {
			JSONObject json = AddFriendS.addFriend(key,id);
			out.println("create user sorti");
			out.println(json.toString());
		} catch (JSONException e) {
			out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
