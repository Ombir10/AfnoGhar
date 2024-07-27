<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="utils.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.UserModel"%>

    
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
					<img src="http://localhost:8080/images/${room.image}"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h4 class="card-title">${room.HouseNumber}
							${room.HostNumber} ${room.UnitPrice}</h4>
						<h5 class="card-text">${room.Address}</h5>
					</div>
					<form method="post"
						action="${pageContext.request.contextPath}/modify">
						<input type="hidden" name="updateId" value="${room.HouseNumber}" />
						<button type="submit">Update</button>
					</form>
					<form id="deleteForm-${user.Email}" method="post"
						action="${pageContext.request.contextPath}/ModifyServlet">
						<input type="hidden" name="deleteId" value="${user.Email}" />
						<button type="button"
							onclick="confirmDelete('${user.Email}')">Delete</button>
					</form>
				</div>
				
			</c:forEach>
		</div>
	</div>
	
	
	

</body>
</html>

</body>
</html>