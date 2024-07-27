<%@page import="utils.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.RoomModel" %>
<%@page import="controller.database.DBController" %>
<%
String contextPath = request.getContextPath();
DBController controller = new DBController();
ArrayList<RoomModel> roomList = controller.getAllRoomInfo();
request.setAttribute("roomList",roomList);
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheets/adminheader.css">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheets/home.css">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheets/Room2.css">	
<title>Insert title here</title>
</head>
<body>
<jsp:include page="<%=StringUtils.PAGE_URL_ADMIN%>" />
<sql:setDataSource var="dbConnection" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/afnoghar" user="root"
		password="" />

	<sql:query var="rooms" dataSource="${dbConnection}">
	SELECT HouseNumber, Address, HostNumber, UnitPrice FROM room WHERE Address LIKE "%a%"
	</sql:query>

<div class="container">

<div class="table">
  <section class="player-list">
<h2>Room List</h2>
    <table id ="roomTable" border ="4">
        <thead>
            <tr>
                <th><h4>House Number</h4></th>
                <th><h4>Address</h4></th>
                <th><h4>Host Number</h4></th>
                <th><h4>Unit Price</h4></th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% if (roomList == null || roomList.isEmpty()) { %>
                <tr>
                    <td colspan="5">No rooms found.</td>
                </tr>
            <% } else { %>
                <% for (RoomModel room : roomList) { %>
                    <tr>
                        <td><%= room.getHouse_number() %></td>
                        <td><%= room.getAddress() %></td>
                        <td><%= room.getHost_number() %></td>
                        <td><%= room.getUnit_price() %></td>
                        
                        <td><a href="<%= contextPath%>/pages/update.jsp?houseNo=<%=room.getHouse_number()%>">Edit</a>
                            <form id="deleteForm_<%=room.getHouse_number() %>"action="<%= contextPath + StringUtils.SERVLET_URL_MODFIY %>" method="post">
                                <input type="hidden" name="deleteId" value="<%= room.getHouse_number() %>">
                                <button type="submit" onclick="return confirm('<%=room.getHouse_number() %>')">Delete<%=room.getHouse_number() %></button>
                            </form>
                        </td>
                    </tr>
                <% } %>
            <% } %>
        </tbody>
    </table>
		</section>
		</div>
</div>
<script>
document.addEventListener("DOMContentLoaded", function() {
    var table = document.getElementById("roomTable");
    table.addEventListener("click", function(e) {
        var target = e.target;
        if (target.tagName.toLowerCase() === "td") {
            var row = target.parentNode;
            document.getElementById("houseNumberInput").value = row.cells[1].innerHTML;

            document.getElementById("addressInput").value = row.cells[2].innerHTML;
            document.getElementById("hostNumberInput").value = row.cells[3].innerHTML;
            document.getElementById("unitPriceInput").value = row.cells[4].innerHTML;
        }
    });
});
</script>
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