<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company form</title>
</head>
<body>
<h1>Login Page</h1>

<table>
  <tr>
   <td>
    <form name="registerUserForm" action="SystemUserController?userLogin" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> Username (*): </td>
    <td> <input name="username" value="" type="text" maxlength="16"> </td>
  	
    </tr>
    
    <tr>
    <td> Password (*): </td>
    <td> <input name="password" value="" type="text" maxlength="45">  </td>
 	<input name="errMsg"  value="<c:out value='${failMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
    </tr>

	</table>
    <input name="action" value="userLogin" type="hidden">
    <input type="submit" value="Login User">
    </form>
</td>
</tr>
</table>