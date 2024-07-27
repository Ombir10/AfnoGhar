<%@ page import = "utils.StringUtils" %>
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
<link rel = "stylesheet" type="text/css" href="<%=contextPath %>/stylesheets/addRoom.css"/>
</head>
<body>
<div class="container">
    <div class="box">
      <span><h2> Details For Room Registration</h2></span>
      <hr>
      <div class="form-group">
        <form action="<%=contextPath + StringUtils.SERVLET_URL_ROOM%>" method ="post">
		        
		        <label for="number" class= "number">House Number</label>
		        <input type="text" id="house_number" name="house_number" placeholder="House Number...."  required>
		        
		        <label for="address">Address</label>
		        <input type="text" id="address" name="house_address" placeholder="Address...." value="">
		        
		        <label for="number">Host Number</label>
		        <input type="text" id="number" name="host_number" placeholder="Host Number...." value="">
		        
		        <label for="unitprice">Unit Price</label>
		        <input type="text" id="price" name="price" placeholder="Unit Price...." value="">
		        <br>        
           <button type="submit">Submit</button>
        </form>
        
      </div>
          </div>
  </div>
</body>
</html>