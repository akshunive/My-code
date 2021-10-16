<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<link type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/style.css" >
		
	<link type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" >
		
		
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
	</div>
</div>

<div style="color: green;">${message}</div>

<div id="container">
	<h3>Save Customer</h3>
		<form:form action="addCustomer" modelAttribute="customer" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>First Name:	&nbsp;&nbsp;</label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last Name:	&nbsp;&nbsp;</label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					<tr>
						<td><label>Email:	  &nbsp;&nbsp;</label></td>
						<td><form:input path="email"/></td>
					</tr>
					<tr>
						<td><label></label>
						<td><input type="submit" value="Add Customer" class="save"></td>
					</tr>
				</tbody>	
			</table>
		</form:form>
	
	<div style="clear;both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to Customer List</a>
		</p>
	
</div>
</body>
</html>