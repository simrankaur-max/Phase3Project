<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Admin login</h1>
<h2>User List</h2>
 <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>E-mail</th>
            
        </tr>
        <c:forEach items="${listUser}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getEmail()}</td>
        </tr>
        </c:forEach>
    </table>
    <br/>
    <br/>
    <h2>Product Purchase Report</h2>
    <form action="product-filter" method="post">
		
		Date: <input type="date" name="date" value="${ dateFilter }" /> <br/> <br/>
		<input type="submit" value="Set Filter" />
		
	</form>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Ball</th>
            <th>Bat</th>
            <th>Football</th>
            <th>Helmet</th>
            <th>Created Date</th>
            <th>User Name</th>
        </tr>
        <c:forEach items="${listProduct}" var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getBall()}</td>
            <td>${product.getBat()}</td>
            <td>${product.getFootball()}</td>
            <td>${product.getHelmet()}</td>
            <td>${product.getDate()}</td>
            <td>${product.getUser().getName()}</td>
        </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>