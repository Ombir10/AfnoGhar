<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="utils.StringUtils"%>
<%@page import="model.UserModel" %>
<%@page import="controller.database.DBController" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String contextPath = request.getContextPath();
    HttpSession userSession = request.getSession();
    userSession.getAttribute(StringUtils.EMAIL);	
    String userName = (String) userSession.getAttribute(StringUtils.USERNAME);
    UserModel users = (UserModel)session.getAttribute("email");
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel = "stylesheet" type="text/css" href="<%=contextPath %>/stylesheets/profile.css"/>
</head>
<body>

<div class="container">
  <img src = "../resources/userlogo.png" width ="300" height= "300">
    <div class="box">
    	 <div class="form-group">
	         <form action = "<%= contextPath + StringUtils.SERVLET_URL_PROFILE%>" method ="post">
	         <input type ="hidden" id ="userName" name ="${StringUtils.UPDATE_ID}" value ="<%= session.getAttribute("email") %>">
	         
		        <label for="fname">First Name:</label>
		        <input type="text" id="fname" name="firstName" placeholder="First Name...." value="<%= users.getFirstName() %>" required>
		        
		        <label for="lname">Last Name:</label>
		        <input type="text" id="lname" name="lastName" placeholder="Last Name...." value="<%= users.getLastName() %>" required>
		        
		        <label for="uname">User Name:</label>
		        <input type="text" id="uname" name="userName" placeholder="User Name...." value="<%= users.getUSERNAME()%>">
		        
		        <label for="number">ContactNo.:</label>
		        <input type="text" id="number" name="number" placeholder="ContactNumber...." value="<%= users.getPhoneNumber()%>">
		        
		        <label for="address">Address:</label>
		        <input type="text" id="address" name="address" placeholder="Address...." value="<%= users.getAddress()%>">
		        
		        <label for="birth">Date of Birth:</label>
		        <input type="date" id="birth" name="dob" placeholder="Date of Birth...." value="<%= users.getDob() %>" required>
		        
		        <label for="Email">Email:</label>
		        <input type="text" id="Email" name="email" placeholder="Email Address...." value="<%= users.getEmail() %>">
		        <br>
		        
		        <a class="Back" href="<%=contextPath + StringUtils.URL_HOME %>"> Back</a>
		        <button type ="submit">Submit</button> 

          		</form>
          		<form id="deleteForm_<%= users.getUSERNAME() %>" action="<%= contextPath + StringUtils.SERVLET_URL_PROFILE %>" method="post">
    <input type="hidden" name="${StringUtils.DELETE_ID}" value="<%= users.getUSERNAME() %>">
    <button type="button" onclick="confirmDelete('<%= users.getUSERNAME() %>')">Remove Account??</button>
</form>
      </div>
    </div>
  </div>

</body>
  <script>
    function confirmDelete(userName) {
        var formId = "deleteForm_" + userName;
        var form = document.getElementById(formId);
        if (form) {
            if (confirm("Are you sure you want to delete this user: " + userName + "?")) {
                form.submit();
            }
        } else {
            alert("Error: Form not found.");
        }
    }
</script>
</html>