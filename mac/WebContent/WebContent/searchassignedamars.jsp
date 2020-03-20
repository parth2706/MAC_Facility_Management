<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Assigned MARS form</title>
</head>
<body>
<input name="errMsg"  value="<c:out value='${Message.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="searchassignedmarform" action="/mac/FacilityController?viewassignedmar" method="post">
    <table style="width: 1200px; ">

    <tr>
    <td> Dates : </td>
    <td>
    <select name="date">
    <c:forEach var="line" items="${MARS}">
        <option><c:out value="${line}"/></option>
    </c:forEach>
    </select>
    </td> 
    </tr>
    
    </table>
    <input name="action" value="viewassignedmar" type="hidden">
    <input type="submit" value="View Assigned MAR">
    </form>
</td>
</tr>
</table>
</body>
</html>