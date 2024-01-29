package com.project.user;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.database.DatabaseConnectivityDemo;

/**
 * Servlet implementation class UserRegistration
 */
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistration() {
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
		
		String email,name,phone,address,password;
		int srNo=0;
		name=request.getParameter("name");
		email=request.getParameter("email");
		phone=request.getParameter("phone");
		address=request.getParameter("address");
		password=request.getParameter("password");
		
		Connection con = DatabaseConnectivityDemo.connectDb();
		try
		{
			PreparedStatement ps1 = con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			ps1.setInt(1, srNo);
			ps1.setString(2, name);
			ps1.setString(3, email);
			ps1.setString(4, phone);
			
			ps1.setString(5, address);
			ps1.setString(6, password);
			int i =	ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("user_login.html");
			}
			else
			{
				response.sendRedirect("user_registration.html");
			}
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}			
	}

}
