<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Companies List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<body>
    <div class="header_resize">
      <div class="logo"><h1><a href="/mac">My reserved Repairs</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>

<input name="errMsg"  value="<c:out value='${errorMsgs}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
     <div class="mainbar"><div class="submb"></div></div>
      
 <form action="/mac/MarController?action=listReservations" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="width: 20px; ">Select Company</th>
				<th class="myTableHead" style="padding-right: 20px; text-align: left">Mar number</th>
				<th class="myTableHead" style="padding-right: 35px; text-align: left">facility name</th> 
				<th class="myTableHead" style="padding-right: 20px; text-align: left">time</th> 
			</tr>

 		<c:forEach items="${RESERVATION}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td class="myTableCell" style="width: 20px; text-align: center"><input type="radio" id="radioCompany${status.count}" name="radioCompany" value="${status.count}"></td> 	
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.marnumber}" /></td>
			<td class="myTableCell" style="padding-right: 35px; "><c:out value="${item.facilityname}" /></td>
			<td class="myTableCell" style="padding-right: 20px; "><c:out value="${item.time}" /></td>
			</tr>
		</c:forEach>
 </table>
<input name="ListSelectedReservation" type="submit" value="Submit">
 </form>
 <a href="repairerhomepage.jsp"  target="_top"><span>BackToHomePage</span></a>
</body>
</html>