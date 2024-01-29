package com.project.user;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.jdbc.Blob;
import com.project.database.DatabaseConnectivityDemo;
import com.project.department.GetterSetterData;

/**
 * Servlet implementation class UserComplaints
 */
//@WebServlet("/FileUploadDBServlet")
//@MultipartConfig(maxFileSize = 16177215)
public class UserComplaints extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserComplaints() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
		int id=0;
		InputStream inputStream = null;
		
		String email=GetterSetterData.getEmail();
		
		String title=request.getParameter("title");
		String disp=request.getParameter("disp");
		String dept = request.getParameter("department");
		Part filePart = request.getPart("cimg");
		GetSet.setDept(dept);
		
		String date = request.getParameter("date");
		String pass=GetterSetterData.getPassword();
		//String cimg="none";
		String cimg=request.getParameter("cimg");
		
		///InputStream is = cimg.getInputStream();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
//		if(filePart !=null)
//		{
//			inputStream = filePart.getInputStream();
//		}
		
		try {
			Date startDate = sdf.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			try 
			{
				
				Connection con = DatabaseConnectivityDemo.connectDb();
				PreparedStatement ps1 = con.prepareStatement("insert into user_complaint values(?,?,?,?,?,?,?,?,?)");
				ps1.setInt(1, id);
				ps1.setString(2,email);
				ps1.setString(3,title);
				ps1.setString(4, disp);
				ps1.setString(5,dept);
				ps1.setString(6, date);
				ps1.setString(7, cimg);
				ps1.setString(8, "Pending");
				ps1.setString(9, pass);
				int i=ps1.executeUpdate();
				if(i>0)
				{
					response.sendRedirect("user_index.html");
				}
			}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.err.println(e);
				}
		
			
		}
		
	}
