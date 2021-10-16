<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
	</div>
</div>

<div id="container">
	<div id="content">
	
	
	<input type="button" value="Add Customer" 
		onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
	
	
	<form:form action="search" method="GET">
	Search Customer: <input type="text" name="theSearchName">
	<input type="submit" value="Search" class="add-button">
	<a href="${pageContext.request.contextPath}/customer/list">Customer List</a>
	</form:form>
			
	
	<table>
			<tr>
				<th> First Name &nbsp; </th>
				<th> Last Name 	&nbsp; </th>
				<th> Email 		&nbsp; </th>
				<th> Action		</th>		
			</tr>
			
			
			<c:forEach var="customer" items="${theCustomers}">
				
				<c:url value="/customer/showFormForUpdate" var="updateLink">
					<c:param value="${customer.id}" name="customerId"></c:param>
				</c:url>
				<c:url value="/customer/deleteCustomer" var="delete">
					<c:param value="${customer.id}" name="customerId"></c:param>
				
				</c:url>
				
				
				<tr>
					<td> ${customer.firstName} </td>
					<td> ${customer.lastName} </td>
					<td> ${customer.email} </td>
					<td> <a href="${updateLink}">Update</a> | <a href="${delete}" onclick="if(!(confirm('Are you sure you want to delete this customer?')))return false"> Delete</a>
				</tr>
			</c:forEach>
			
		</table>
	</div>

</div>

</body>
</html>