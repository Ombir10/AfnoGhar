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
	href="<%=contextPath%>/stylesheets/adminheader.css">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheets/home.css">
</head>
<body>
<jsp:include page="<%= StringUtils.PAGE_URL_ADMIN%>" />
<sql:setDataSource var="dbConnection" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/afnoghar" user="root"
		password="" />

	<sql:query var="users" dataSource="${dbConnection}">
	SELECT FirstName, LastName, Category FROM userprofile WHERE Email LIKE "%a%"
	</sql:query>

	<div class="userprofile">
		<div class="users">
			<c:forEach var="user" items="${users.rows}">
				<div class="card">
					<img src="http://localhost:8080/images/${user.image}"
						class="card-img-top" alt="...">
					<div class="card-body">
						<h4 class="card-title">${user.FirstName}
							${user.LastName}</h4>
						<h5 class="card-text">${user.Category}</h5>
					</div>
					<form method="post"
						action="${pageContext.request.contextPath}/ModifyServlet">
						<input type="hidden" name="updateId" value="${user.Email}" />
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