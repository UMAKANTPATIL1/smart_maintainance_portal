package com.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.database.DatabaseConnectivityDemo;

/**
 * Servlet implementation class DepartmentRegistration
 */
public class DepartmentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentRegistration() {
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
		
		String name,email,phone,address,deptname,taluka,dist,password;
		int srNo=0;
		
		name=request.getParameter("name");
		email=request.getParameter("email");
		phone=request.getParameter("phone");
		deptname=request.getParameter("deptname");
		address=request.getParameter("address");
		taluka=request.getParameter("taluka");
		dist=request.getParameter("dist");
		password=request.getParameter("password");
		
		Connection con = DatabaseConnectivityDemo.connectDb();
		try
		{
			PreparedStatement ps1 = con.prepareStatement("insert into department values(?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1, srNo);
			ps1.setString(2, name);
			ps1.setString(3, email);
			ps1.setString(4, phone);
			ps1.setString(5, deptname);
			ps1.setString(6, address);
			ps1.setString(7, taluka);
			ps1.setString(8, dist);
			ps1.setString(9, password);
			int i=ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("registration.html");
			}
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
	}

}
