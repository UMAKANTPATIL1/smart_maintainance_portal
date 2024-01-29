package com.project.controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.database.DatabaseConnectivityDemo;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		String email_id,pass;
		email_id=request.getParameter("email");
		pass=request.getParameter("password");
		
		try
		{
			Connection conn = DatabaseConnectivityDemo.connectDb();
			PreparedStatement ps2 = conn.prepareStatement("select * from admin_login where username=? and password=?");
			ps2.setString(1,email_id);
			ps2.setString(2,pass);
			ResultSet rs = ps2.executeQuery();
			
			if(rs.next())
			{
				
				response.sendRedirect("index.html");
			}
			else
			{
				response.sendRedirect("login.html");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		} 
	}

}
