<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify MAR</title>
</head>
<body>

<form  action="/mac/MarController?action=searchAndShowListOfReservationForModify" method="post">
<h2>Modify Reserved MARs</h2>
<table>

<tr>
<td> Start Date:
</td>
<td>
<select name="startdate">
 <option value="0">Same Day</option>
 <option value="1">Last 7 Days</option>
</select>
</td>

<td> Facility Type:
</td>
<td>  
<select name="facilitytype">
      <c:forEach items="${FACILITYTYPES}" var="ftypes">
        <option><c:out value="${ftypes}"></c:out></option>
      </c:forEach>
   </select>
</td>
<td> Facility Name:
</td>
<td>
<select name="facilityname">
        <c:forEach items="${FACILITYNAMES}" var="fnames">
            <option ><c:out value="${fnames}"/></option>
        </c:forEach>
    </select>
</td>
</tr>

</table>
<input type="submit" value="Search MAR">
    </form>
    
<form action="/mac/MarController?action=editMarToReserve" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th style="width: 20px; ">Select MAR</th>
				<th  style="padding-right: 20px; text-align: left">MAR Number</th>
				<th  style="padding-right: 20px; text-align: left">Assigned Date</th>
				<th  style="padding-right: 35px; text-align: left">Assigned Time</th> 
				<th  style="padding-right: 20px; text-align: left">Facility Type</th>
				<th  style="padding-right: 30px; text-align: left">Facility Name</th> 
				<th  style="padding-right: 30px; text-align: left">Start Time</th>
				<th  style="padding-right: 30px; text-align: left">End Time</th>
				 
			</tr>

 		<c:forEach items="${MARFACILITY}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td  style="width: 20px; text-align: center"><input type="radio" id="${item.marno}" name="radioMar" value="${item.marno}"></td> 	
			<td  style="padding-right: 20px; "><c:out value="${item.marno}" /></td>
			<td  style="padding-right: 20px; "><c:out value="${item.assignedDate}" /></td>
			<td  style="padding-right: 35px; "><c:out value="${item.assignedTime}" /></td>
			<td  style="padding-right: 20px; "><c:out value="${item.facilityType}" /></td>
			<td  style="padding-right: 30px; "><c:out value="${item.facilityName}" /></td>
			<td  style="padding-right: 30px; "><c:out value="${item.startTime}" /></td>
			<td  style="padding-right: 30px; "><c:out value="${item.endTime}" /></td>
		</tr>
		</c:forEach>
 </table>
<input name="ListSelectedCompanyButton" type="submit" value="Modify">
 </form>
</body>
</html>