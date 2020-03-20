<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Users form</title>
</head>
<body>
<input name="errMsg"  value="<c:out value='${Message.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="searchusersform" action="/mac/SystemUserController?viewselecteduser" method="post">
    <table style="width: 1200px; ">

    <tr>
    <td> Enter User Name : </td>
    <td> <input name="user" value="<c:out value='${systemuser.user}'/>" type="text" style ="height:50px; width: 140px" maxlength="256">  </td>
  	<td> <input name="userError"  value="<c:out value='${Message.userError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    <td>
    
    </td> 
    </tr>
    
    </table>
    <input name="action" value="viewselecteduser" type="hidden">
    <input type="submit" value="View Selected User">
    </form>
</td>
</tr>
</table>
<a href="adminhomepage.jsp"  target="_top"><span>BackToHomePage</span></a>
</body>
</html>