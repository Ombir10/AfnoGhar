<%@page import="utils.StringUtils" %>>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	String contextPath = request.getContextPath();
    	int houseNo = Integer.parseInt(request.getParameter("houseNo"));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="update">
  <h1>Update Room Data</h1>
  <form action="<%= contextPath + StringUtils.SERVLET_URL_MODFIY %>" method="post">
  <input type = "hidden", id="houseNumberInput" name = "${StringUtils.UPDATE_ID}" value="<%= houseNo %>">

    <label for="address"><h4>Address:</h4></label><br>
    <input type="text" id="addressInput" name="house_address" required>

    <label for="hostNumber"><h4>Host Number:</h4></label><br>
    <input type="text" id="hostNumberInput" name="host_number" required>

    <label for="unitPrice"><h4>Unit Price:</h4></label><br>
    <input type="text" id="unitPriceInput" name="price" required>

   <button type ="submit" > Submit</button>
   <a href = "<%=contextPath + StringUtils.PAGE_URL_ROOM2%>"> Back</a>
 </form>
</div>

</body>
</html>