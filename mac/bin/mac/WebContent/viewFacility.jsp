<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Specific User form</title>
</head>
    <div class="header_resize">
      <div class="logo"><h1><a href="/mac">Mavericks Application Center</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>
<body>
<input name="errMsg"  value="<c:out value='${errorMsgs}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
     <div class="mainbar"><div class="submb"></div></div>
      
 <form action="/mac/FacilityController?action=ViewSpecificFacility" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow">
				<th class="myTableHead" style="padding-right: 30px; text-align: left"></th> 
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Facility Name</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Facility type</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Interval</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Duration</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Venue</th>
			</tr>

 		<c:forEach items="${Facilities}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td class="myTableCell" style="width: 20px; text-align: center"><input type="radio" id="radioUsers${status.count}" name="radioUsers" value="${status.count}"></td> 	
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.getFacilityName()}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.getFacilityName()}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.getInterval()}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.getDuration()}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.getVenue()}" /></td>
			<td> <a href="/mac/FacilityController?action=ViewSpecificFacility&id=${item.getFacilityName()}">View</a></td>
			</tr>
		</c:forEach>
 </table>
 </form>
</body>
</html>