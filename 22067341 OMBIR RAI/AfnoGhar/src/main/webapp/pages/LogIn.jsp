<%@page import="utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%
String contextPath = request.getContextPath();
String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);
String email = (String) request.getAttribute(StringUtils.EMAIL);
String successParam = request.getParameter(StringUtils.SUCCESS);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel = "stylesheet" type="text/css" href="<%=contextPath %>/stylesheets/LogIn.css"/>
</head>
<body>
<div class="container">
    <div class="box">
      <div class="header">
        <span><b>Log In Or Sign Up</b></span>
      </div>
      <div class="content">
        <p><b>Welcome to AfnoGhar</b></p>
      </div>
      <div class="form-group">
        <form action="<%= contextPath + StringUtils.SERVLET_URL_LOGIN%>" method="post">
               <input type="text" id="Email" name="email" placeholder="Email Address...." value="<%if (email != null && !email.isBlank()) {
							out.println(email);
						}%>"
						required>
          <br> 
          <input type="password" id="Password" name="password" placeholder="Password...." required>
          <br>
          <button type= "button"> Forgot Password ? <a href="<%=contextPath + StringUtils.PAGE_URL_SIGNUP%>">Create a new account!</a></button>
           <button type="submit"> Log In</button>
             </form>
      </div>
    </div>
    <%
			if (errMsg != null) {
			%>
			<p class="error-msg">
				<%
				out.println(errMsg);
				%>
			</p>
			<%
			}
			
			if (successParam != null && successParam.equals(StringUtils.TRUE)) {
			    %>
			    <h2 class="success-msg">Registration Successful!</h2>
			    <%
			}
			%>
  </div>

</body>
</html>