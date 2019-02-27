package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.DeleteCommentS;
import services.ListMessageS;

public class ListMessage extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public ListMessage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String idusers = request.getParameter("id_users");
		
		String str[] =idusers.split(",");
		ArrayList<String> list_users = new ArrayList<String>();
		ArrayList<Integer> tab_iduser = new ArrayList<Integer>();
		for(int i=0; i<list_users.size();i++) {
			tab_iduser.add(Integer.parseInt(list_users.get(i)));
		}
		response.setContentType( " text / plain " );
		PrintWriter out = response.getWriter ();
		
		try {
			JSONObject json = ListMessageS.listMessage(key, tab_iduser);
			out.println(json.toString());
		} catch (JSONException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
