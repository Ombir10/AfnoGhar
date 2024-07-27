<%@page import="utils.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.UserModel"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    
    
      
<%
String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheets/header.css">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheets/home.css">	
</head>
<body>
	<jsp:include page="<%=StringUtils.PAGE_URL_HEADER%>" />	
<sql:setDataSource var="dbConnection" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/afnoghar" user="root"
		password="" />

	<sql:query var="rooms" dataSource="${dbConnection}">
	SELECT HouseNumber, Address, HostNumber, UnitPrice FROM room WHERE Address LIKE "%a%"
	</sql:query>
	
<div class="userprofile">
		<div class="users">
			<c:forEach var="room" items="${rooms.rows}">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">HouseNumber:${room.HouseNumber}
							 </h4>
						<h4>UnitPrice: ${room.UnitPrice}</h4>
						<h4>Host Number: ${room.HostNumber}</h4>
						<h5 class="card-text"> Address: ${room.Address}</h5>
					</div>
					<form method="post"
						action="${pageContext.request.contextPath}/modify">
						<input type="hidden" name="updateId" value="${room.HouseNumber}" />
						
					</form>
					
				</div>
				
			</c:forEach>
		</div>
	</div>
	
	
	

</body>
</html>