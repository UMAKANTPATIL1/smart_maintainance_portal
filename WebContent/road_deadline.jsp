<%@page import="com.project.department.GetterSetterData"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
--> 
<%@ page import="java.sql.*" %>
<%@ page import="com.project.database.*" %>
<!DOCTYPE html>
<head>
<title>Smart Maintenance Portal | Road Deadline </title>


<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<link rel="stylesheet" href="css/morris.css" type="text/css"/>
<!-- calendar -->
<link rel="stylesheet" href="css/monthly.css">
<!-- //calendar -->
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
<script src="js/raphael-min.js"></script>
<script src="js/morris.js"></script>
</head>
<body>
<section id="container">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">
    <a href="index.html" class="logo">
    <h4>Municipal corporation</h4>
      <h5> <span>Portal</span></h5> 
    </a>
    
    
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>

<!--logo end-->

<div class="top-nav clearfix">
    <!--search & user info start-->
    <ul class="nav pull-right top-menu">
        <li>
            <input type="text" class="form-control search" placeholder=" Search">
        </li>
        <!-- user login dropdown start-->
        <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                <img alt="" src="#">
                <span class="username">Department</span>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="#"><i class=" fa fa-suitcase"></i>Profile</a></li>
                <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
                <li><a href="departmentLogin.html"><i class="fa fa-key"></i> Log Out</a></li>
            </ul>
        </li>
        <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>
<!--header end-->
<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
       <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a class="active" href="department_index.html">
                        <i class="fa fa-dashboard"></i>
                        <span>Dashboard</span>
                    </a>
                </li>

                        <li>
                    <a href="roadService.jsp">
                        <i class="fa fa-bullhorn"></i>
                        <span>View Department Complaint </span>
                     </a>
                     <ul class="sub">
                        <li><a href="displayComments.jsp">View Own Department Comments</a></li>
                    </ul>
                      <ul class="sub">
                        <li><a href="roadService.jsp">View Own Department</a></li>
                    </ul>
                 
                   
                </li>
                 <li>
                    <a href="pendingTask.jsp">
                        <i class="fa fa-bullhorn"></i>
                        <span>View Pending Task </span>
                     </a>  
                </li>
                   <li>
                    <a href="completedTask.jsp">
                        <i class="fa fa-bullhorn"></i>
                        <span>View Completed Task </span>
                     </a>  
                </li>
                <li>
                    <a href="road_deadline.jsp">
                        <i class="fa fa-bullhorn"></i>
                        <span>View Deadline Of Task </span>
                     </a>  
                </li>
           
             
                <li>
                    <a href="departmentLogin.html">
                        <i class="fa fa-user"></i>
                        <span>Logout </span>
                    </a>
                </li>
            </ul>          
         </div>
        <!-- sidebar menu end-->
    </div>
</aside>

<!--sidebar end-->

<section id="main-content">
	<section class="wrapper">
	
        <!-- page start-->
        <!-- page start-->
        <div class="row">
            <div class="col-lg-16">
                    

<div class="container">
<section class="panel">
 <header class="panel-heading">
                            View Deadline of task
                        </header> 
                          <div class="form-group">
                          <form class="road_deadline.jsp" >
                                    <label >Department</label>
								     <select name="select" >
									    <option value="Select Department">Select Department </option>
									     <button>OK</button>
									    <% 
									    try
									    {
									    	Connection con =DatabaseConnectivityDemo.connectDb();
									    	PreparedStatement ps1 = con.prepareStatement("select * from department");
									    	ResultSet rs = ps1.executeQuery();
									    	while(rs.next())
									    	{
									    		%>
									    		<option ><%=rs.getString("department_name")%> </option>
									    		<%
									    	}									    	
									    }
									    catch(Exception e)
									    {
									    	e.printStackTrace();
									    }
									    %>
							</form>
								        	
								    </select> 
								    <button>OK</button>
											</div>
											  <table class="table table-bordered">
											    <thead>
											      <tr>
											        <th class="cell100 column1">Serial No.</th>
														<th>Road Name</th>
														<th>Location </th>
														<th>Department Name </th>
														<th>Deadline</th>
											      </tr>
											    </thead>
										               
									    <% 
									    
									    String department_name= request.getParameter("select"); 
									    Connection con = DatabaseConnectivityDemo.connectDb();
                                    if(department_name !=null)
                                    {
									    try
									    {
									    	GetterSetterData.getDep();
									    	PreparedStatement ps2 = con.prepareStatement("select * from road where department_name=? ");
									    	ps2.setString(1,department_name);
									    	ResultSet rs2 = ps2.executeQuery();
									    	while(rs2.next())
									    	{
									   %>
									    	
									    		 <tbody>
												      <tr>
												        <td><%=rs2.getInt(1)%></td>
												        <td><%=rs2.getString(2)%></td>
												        <td><%=rs2.getString(3)%></td>
												      
												        <td><%=rs2.getString(4) %></td>
												        <td><%=rs2.getString(5)%></td>
												      
												     
												       
											
												      </tr>
												  </tbody>
												  
									    		<% 	
									    	}
									    }

                                    
                                    
									    catch(Exception e)
									    {
									    	e.printStackTrace();
									    }
                                    }
									    %>
					


  </table>
</div>    
                        
                
        </section>

        </div>
        </div>
 <!-- footer -->

<!--main content end-->
</section>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
<!-- morris JavaScript -->	
<script>
	$(document).ready(function() {
		//BOX BUTTON SHOW AND CLOSE
	   jQuery('.small-graph-box').hover(function() {
		  jQuery(this).find('.box-button').fadeIn('fast');
	   }, function() {
		  jQuery(this).find('.box-button').fadeOut('fast');
	   });
	   jQuery('.small-graph-box .box-close').click(function() {
		  jQuery(this).closest('.small-graph-box').fadeOut(200);
		  return false;
	   });
	   
	    //CHARTS
	    function gd(year, day, month) {
			return new Date(year, month - 1, day).getTime();
		}
		
		graphArea2 = Morris.Area({
			element: 'hero-area',
			padding: 10,
        behaveLikeLine: true,
        gridEnabled: false,
        gridLineColor: '#dddddd',
        axes: true,
        resize: true,
        smooth:true,
        pointSize: 0,
        lineWidth: 0,
        fillOpacity:0.85,
			data: [
				{period: '2015 Q1', iphone: 2668, ipad: null, itouch: 2649},
				{period: '2015 Q2', iphone: 15780, ipad: 13799, itouch: 12051},
				{period: '2015 Q3', iphone: 12920, ipad: 10975, itouch: 9910},
				{period: '2015 Q4', iphone: 8770, ipad: 6600, itouch: 6695},
				{period: '2016 Q1', iphone: 10820, ipad: 10924, itouch: 12300},
				{period: '2016 Q2', iphone: 9680, ipad: 9010, itouch: 7891},
				{period: '2016 Q3', iphone: 4830, ipad: 3805, itouch: 1598},
				{period: '2016 Q4', iphone: 15083, ipad: 8977, itouch: 5185},
				{period: '2017 Q1', iphone: 10697, ipad: 4470, itouch: 2038},
			
			],
			lineColors:['#eb6f6f','#926383','#eb6f6f'],
			xkey: 'period',
            redraw: true,
            ykeys: ['iphone', 'ipad', 'itouch'],
            labels: ['All Visitors', 'Returning Visitors', 'Unique Visitors'],
			pointSize: 2,
			hideHover: 'auto',
			resize: true
		});
		
	   
	});
	</script>
<!-- calendar -->
	<script type="text/javascript" src="js/monthly.js"></script>
	<script type="text/javascript">
		$(window).load( function() {

			$('#mycalendar').monthly({
				mode: 'event',
				
			});

			$('#mycalendar2').monthly({
				mode: 'picker',
				target: '#mytarget',
				setWidth: '250px',
				startHidden: true,
				showTrigger: '#mytarget',
				stylePast: true,
				disablePast: true
			});

		switch(window.location.protocol) {
		case 'http:':
		case 'https:':
		// running on a server, should be good.
		break;
		case 'file:':
		alert('Just a heads-up, events will not work when run locally.');
		}

		});
	</script>
	<!-- //calendar -->
</body>
</html>
