package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.ListMessageS;
import services.SearchFriendS;
import tools.SearchTools;

public class SearchFriend extends HttpServlet {


    public SearchFriend() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		
		response.setContentType( " text / plain " );
		PrintWriter out = response.getWriter ();
		
		try {
			JSONObject json = SearchFriendS.searchFriend(search);
			out.println(json.toString());
		} catch (JSONException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
