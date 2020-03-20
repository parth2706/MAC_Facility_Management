<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mac login page</title>
</head>
<body>
<h1>MAC Facility Report Form</h1>
<input name="errMsg"  value="<c:out value='${sucMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<ul>
	<li><a href="/mac/SystemUserController?action=login">Login</a></li>
	<li><a href="/mac/SystemUserController?action=registerUser"  target="_top"">Register</a></li>
</ul>
</body>
</html>