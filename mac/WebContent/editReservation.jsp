<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reserve A Facility</title>
</head>
<body>
<body>
<form action="/mac/MarController?action=reserveMar" method="post">
<table>
<tr>
<td>MAR Number: </td>
<td>
<input  type="text" name="marnumber" value="<c:out value='${MARS.marnumber}'/>" />
</td>

</tr>

<tr>
<td>Facility Name: </td>
<td><input  type="text" name="facilityname" value="<c:out value='${MARS.facilityname}'/>"  />
</td>
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
<td>Assigned To: </td>
<td><c:out value="${MARS.assignedto}" /></td>
</tr>

<tr>
<td>Assigned Date: </td>
<td><c:out value="${MARS.assigneddate}" /></td>
</tr>

<tr>
<td>Estimate date of repair: </td>
<td><c:out value="${MARS.estimateofrepair}" /></td>
</tr>

<tr>
<td>Start Time: </td>
<td><input type="time" name="starttime" value="<c:out value='${MARS.startTime}'/>">
</td>
</tr>

<tr>
<td>End Time: </td>
<td><input type="time" name="endtime" value="<c:out value='${MARS.endTime}'/>"></td>
</tr>

</table><input type="submit" value="Reserve">
	</form>
	<input name="error"  value="<c:out value='${ERRORMSGS.descriptionerror}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled">
	
</body>
</body>
</html>