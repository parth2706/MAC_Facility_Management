<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View MARs List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
    <div class="header_resize">
      <div class="logo"><h1><a href="/company_management">Mavericks Activity Center Application</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>

<input name="errMsg"  value="<c:out value='${errorMsgs}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
     <div class="mainbar"><div class="submb"></div></div>
      
 <form action="/mac/MarController?action=ViewSpecificMAR" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="padding-right: 30px; text-align: left">MARnumber</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">FacilityName</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Description</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Reportedby</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Date</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Time</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Assignedto</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">AssignedDate</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">EstimateofRepair</th>  
			</tr>

 		<c:forEach items="${MARS}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td class="myTableCell" style="width: 20px; text-align: center"><input type="radio" id="radioUsers${status.count}" name="radioUsers" value="${status.count}"></td> 	
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.marnumber}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.facilityname}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.description}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.reportedby}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.date}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.time}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.assignedto}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.assigneddate}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.estimateofrepair}" /></td>
			<td> <a href="/mac/MarController?action=ViewSpecificMAR&id=${system.username}">View</a></td>
			</tr>
		</c:forEach>
 </table>
 </form>
</body>
</html>