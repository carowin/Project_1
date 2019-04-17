package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.ListMessageS;
import services.PrivateMessageS;

public class MyPrivateMessages {

	public MyPrivateMessages() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		response.setContentType( " text / plain " );
		PrintWriter out = response.getWriter ();
		
		try {
			JSONObject json = PrivateMessageS.getMyPrivateMessage(login);
			out.println(json.toString());
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
	}
}
