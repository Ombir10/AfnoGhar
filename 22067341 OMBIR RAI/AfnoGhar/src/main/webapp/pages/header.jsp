<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="utils.StringUtils"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>

<%
    // Get the session and request objects
    HttpSession userSession = request.getSession();
    String currentUser = (String) userSession.getAttribute("username");
    String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheets/header.css">
</head>
<body>
<div class="taskbar">
			<span class="logo"> <img
				src="<%=contextPath %>/resources/logo.png">
			</span> 
			
			<span class="menu-container">
			<a class = "Home" href ="<%=contextPath + StringUtils.PAGE_URL_HOME%>"> Home</a>
			<a class="Signup" href="<%=contextPath + StringUtils.PAGE_URL_SIGNUP %>"> Sign Up</a>
        <a class="Login" href="<%=contextPath + StringUtils.PAGE_URL_LOGIN %>"> Log In</a>
        <a class = "Room" href ="<%=contextPath + StringUtils.PAGE_URL_ROOM %>"> Room</a>
        <a class = "Profile" href ="<%=contextPath + StringUtils.PAGE_URL_PROFILE %>"> Profile</a>
			</span> 
	
			<br> 
			<span class="searchbox"> 
			<span class="button" >Search</span> 
					<span class="button" >check indate</span> 	
					<span class="button" >check outdate</span>
			</span>
			<hr>
			<form action = "<% if(currentUser != null) {
				out.println("Logout");
			}else{
				out.print("Login");
			}%>"></form>
		</div>

</body>
</html>