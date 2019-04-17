package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.PrivateMessageS;

public class SendPrivateMessages {
	public SendPrivateMessages() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String me = request.getParameter("me");
		String friend = request.getParameter("friend"); 
		String content = request.getParameter("content"); 
		response.setContentType( " text / plain " );
		PrintWriter out = response.getWriter ();
		
		try {
			JSONObject json = PrivateMessageS.sendAPrivateMessage(me, friend, content);
			out.println(json.toString());
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
	}
}
