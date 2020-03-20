<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assigned MARs</title>
</head>
<body>
<form action="/mac/FacilityController?action=listSpecificMar" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th  style="padding-right: 20px; text-align: left">MAR Number</th>
				<th  style="padding-right: 35px; text-align: left">Facility Name</th> 
				<th  style="padding-right: 20px; text-align: left">Description</th>
				<th  style="padding-right: 30px; text-align: left">Reported By</th> 
				<th  style="padding-right: 30px; text-align: left">Assigned To</th> 
			</tr>

 		<c:forEach items="${MARS}" var="item" varStatus="status">
			<tr class="myTableRow"> 	
			<td  style="padding-right: 20px; "><c:out value="${item.marnumber}" /></td>
			<td  style="padding-right: 35px; "><c:out value="${item.facilityname}" /></td>
			<td  style="padding-right: 20px; "><c:out value="${item.description}" /></td>
			<td  style="padding-right: 30px; "><c:out value="${item.reportedby}" /></td>
			<td  style="padding-right: 30px; "><c:out value="${item.assignedto}" /></td>
           
			</tr>
		</c:forEach>
 </table>
 </form>
</body>
</html>