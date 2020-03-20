<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign MAR</title>
</head>
<body>
<form action="/mac/FacilityController?action=updateMar&marNumber=${MARS.marnumber}" method="post">
<table>
<tr>
<td>MAR Number: </td>
<td ><c:out value="${MARS.marnumber}" /></td>
</tr>

<tr>
<td>Facility Name: </td>
<td><c:out value="${MARS.facilityname}" /></td>
</tr>

<tr>
<td>Description: </td>
<td><c:out value="${MARS.description}" /></td>
</tr>

<tr>
<td>Reported By: </td>
<td><c:out value="${MARS.reportedby}" /></td>
</tr>

<tr>
<td>Date: </td>
<td><c:out value="${MARS.date}" /></td>
</tr>

<tr>
<td>Time: </td>
<td><c:out value="${MARS.time}" /></td>
</tr>

<tr>
<td>AssignedTo: </td>
<td>
<select name="assignedTo">
        <c:forEach items="${ASSIGNEDTO}" var="item">
            <option ><c:out value="${item}"/></option>
        </c:forEach>
</select>
</td>
</tr>

<tr>
<td>Estimate date of repair: </td>
<td> 
 <select name="estimateOfRepair">
  <option value="Multiple days">Multiple days</option>
  <option value="One day">One day</option>
  <option value="Multiple hours">Multiple hours</option>
  <option value="One hours">One hours</option>
  <option value="30 minutes">30 minutes</option>
 </select> 
</td>
</tr>


</table><input type="submit" value="Assign">
	</form>
<input name="error"  value="<c:out value='${ERRORMSGS.descriptionerror}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled">

</body>
</html>