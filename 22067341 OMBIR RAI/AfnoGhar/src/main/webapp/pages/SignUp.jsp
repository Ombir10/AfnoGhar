<%@page import="utils.StringUtils" %>
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
<link rel = "stylesheet" type="text/css" href="<%=contextPath %>/stylesheets/SignUp.css"/>
</head>
<body>

  <div class="container">
    <div class="box">
      <div class="header">
        <span><h2>Log In Or Sign Up</h2></span>
      </div>
      <div class="content">
        <b>Welcome to AfnoGhar</b>
      </div>
      <div class="form-group">
        <form action="<%=contextPath + StringUtils.SERVLET_URL_SIGNUP%>"method ="post">
          <input type="text" id="fname" name="firstName" placeholder="First Name...." required>
          <input type="text" id="lname" name="lastName" placeholder="Last Name...." required>
          <br>
          <input type="text" id="uname" name="userName" placeholder="User Name...." required>
          <input type="text" id="number" name="number" placeholder="Contact Number...." required>
          <br> <!-- Added line break to separate rows -->
          <input type="text" id="address" name="address" placeholder="Address...." required>
			<input type="date" id="birth" name="dob" required>

          <br> <!-- Added line break to separate rows -->
          <select id = "category" name="category" required> 
          <option value = "customer">Customer</option>
          <option value = "admin">Admin</option>
          </select> 
          <input type="text" id="Email" name="email" placeholder="Email Address...." required>
          <br> <!-- Added line break to separate rows -->
          <input type="password" id="Password" name="password" placeholder="Password...."required>
          <input type="password" id="Re-password" name="retype" placeholder="Retype Password...." required>
           <button type="submit">Submit</button> 
        </form>
      </div>
    </div>
    <%
		String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
		String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);
		if (errMsg != null) {
			// print
		%>
		<h4 class="error-msg">
			<%
			out.println(errMsg);
			%>
		</h4>
		<%
		}
		if (successMsg != null) {
		// print
		%>
		<h4 class="success-msg">
			<%
			out.println(successMsg);
			%>
		</h4>
		<%
		}
		%>
  </div>

</body>
</html>