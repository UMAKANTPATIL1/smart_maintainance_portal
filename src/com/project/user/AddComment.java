package com.project.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.database.DatabaseConnectivityDemo;
import com.project.department.GetterSetterData;

/**
 * Servlet implementation class AddComment
 */
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComment() {
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
		String comment;
		String email=GetterSetterData.getEmail();
		String password=GetterSetterData.getPassword();
		String department=GetSet.getDept();
		comment=request.getParameter("comment");
		int id=0;
		try
		{
			Connection con = DatabaseConnectivityDemo.connectDb();
			PreparedStatement ps = con.prepareStatement("insert into comment values(?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, comment);
			ps.setString(3, email);
			ps.setString(4, department);
			ps.setString(5, password);
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("viewComment.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
