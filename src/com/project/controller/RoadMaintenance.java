package com.project.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.database.DatabaseConnectivityDemo;

import javafx.scene.chart.PieChart.Data;

/**
 * Servlet implementation class RoadMaintenance
 */
public class RoadMaintenance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoadMaintenance() {
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
		String road_name,location,department_name;
		int srNo=0;
		road_name=request.getParameter("rname");
		
		location=request.getParameter("rlocation");
		department_name=request.getParameter("dept");
		
		String date = request.getParameter("rdate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//surround below line with try catch block as below code throws checked exception

		try
		{
			Date startDate = sdf.parse(date);
			Connection con = DatabaseConnectivityDemo.connectDb();
			PreparedStatement ps1 = con.prepareStatement("insert into road values(?,?,?,?,?)");
			ps1.setInt(1, srNo);
			ps1.setString(2,road_name);
			ps1.setString(3,location);
			ps1.setString(4,department_name);
			ps1.setString(5, date);
			int i=ps1.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("roadMaintenance.jsp");
			}
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
