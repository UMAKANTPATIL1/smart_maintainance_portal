package com.project.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.database.DatabaseConnectivityDemo;
import com.project.department.GetterSetterData;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		String email,pass;
		email=request.getParameter("email");
		GetterSetterData.setEmail(email);
		
		
		pass=request.getParameter("password");
		GetterSetterData.setPassword(pass);
		
		try
		{
			Connection conn = DatabaseConnectivityDemo.connectDb();
			PreparedStatement ps1 = conn.prepareStatement("select * from user where email=? and password=?");
			ps1.setString(1,email);
			ps1.setString(2,pass);
			ResultSet rs = ps1.executeQuery();
			
			if(rs.next())
			{
				
				response.sendRedirect("user_index.html");
			}
			else
			{
				response.sendRedirect("user_login.html");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		} 

	}

}
