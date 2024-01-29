package com.project.department;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;

import com.project.database.DatabaseConnectivityDemo;

/**
 * Servlet implementation class DepartmentLogin
 */
public class DepartmentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentLogin() {
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
		
		String dept,email,password;
		//dept=request.getParameter("dept");
		email=request.getParameter("email");
		password=request.getParameter("password");
		try
		{
			//GetterSetterData.setDept(dept);
			GetterSetterData.setEmail(email);
			GetterSetterData.setPassword(password);
			
			Connection con = DatabaseConnectivityDemo.connectDb();
			PreparedStatement ps =con.prepareStatement("select * from department where email=? and password=?");
		
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				
				response.sendRedirect("department_index.html");
			}
			else
			{
				response.sendRedirect("departmentLogin.html");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		} 
		}
	
}

