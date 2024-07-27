<%@page import="utils.StringUtils"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String contextPath = request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheets/adminheader.css">
</head>
  <body>
    <header>
    <div class = "taskbar">
      <span class = "logo">
        <img src ="../resources/logo.png">
      </span>
      <span class="menu-container">
      <a class ="Home" href="<%=contextPath +StringUtils.URL_HOME %>"> HOME</a>
          <a class="User" href="<%=contextPath + StringUtils.PAGE_URL_USER %>"> USER</a>
        <a class="Room" href ="<%= contextPath + StringUtils.PAGE_URL_ROOM2 %>"> ROOM </a>
      </span>
      <br>
      <span class="searchbox"> 
        <input type="text" placeholder="Search..." class="button">
      </span>
      <hr>
      </div>
      </header>
    <span class ="add">
      <a href = "<%=contextPath + StringUtils.PAGE_URL_ADDROOM%>">ADD ROOM</a>
      </span>
<% 
      String userSession = (String) session.getAttribute(StringUtils.USERNAME);
      
      String cookieUsername = null;
      String cookieSessionID = null;
      Cookie [] cookies = request.getCookies();
      if(cookies != null){
      		for (Cookie cookie : cookies){
      			if(cookie.getName().equals(StringUtils.USERNAME)) cookieUsername = cookie.getValue();
      			if(cookie.getName().equals(StringUtils.JSESSIONID)) cookieSessionID = cookie.getValue();
      		}
      }
%><div class="welcome-container">
	<h1> Hell0<%= cookieUsername %>. Welcome to our page!</h1>
	<a href="<%=contextPath %>/home.jsp">
	<button class = "home-button">Continue to Home Page</button>
	</a>
  </body>
</html>