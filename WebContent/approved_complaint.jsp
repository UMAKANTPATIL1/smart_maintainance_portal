<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="com.project.database.*" %>   
 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Smart maintenance portal||Delete Record</title>
</head>
<body>

<%
Connection con = DatabaseConnectivityDemo.connectDb();

int srNo=Integer.parseInt(request.getParameter("sr_No"));
try
{
	PreparedStatement ps = con.prepareStatement("update user_complaint set status=? where id=?");
	ps.setString(1, "Approved");
	ps.setInt(2, srNo);
	int i = ps.executeUpdate();
	if(i>0)
	{
		response.sendRedirect("completedTask.jsp");
	}
	
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
</body>
</html>