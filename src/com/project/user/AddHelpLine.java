package com.project.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.database.DatabaseConnectivityDemo;

/**
 * Servlet implementation class AddHelpLine
 */
public class AddHelpLine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHelpLine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name=request.getParameter("name");
		String contact=request.getParameter("contact");
		int id=0;
		Connection con = DatabaseConnectivityDemo.connectDb();
		try
		{
			
			PreparedStatement ps = con.prepareStatement("insert into helpline values(?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, contact);
			int i=ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("help_line.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
