<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Users List</title>
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
      
 <form action="/mac/SystemUserController?action=ViewSpecificUpdateUser" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th class="myTableHead" style="padding-right: 30px; text-align: left">UserName</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Password</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">UTAID</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">FirstName</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">LastName</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Phone</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Email</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Address</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">City</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">State</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">ZipCode</th>
				<th class="myTableHead" style="padding-right: 30px; text-align: left">Role</th>  
			</tr>

 		<c:forEach items="${USERS}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td class="myTableCell" style="width: 20px; text-align: center"><input type="radio" id="radioUsers${status.count}" name="radioUsers" value="${status.count}"></td> 	
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.username}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.password}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.utaid}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.firstname}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.lastname}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.phone}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.email}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.address}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.city}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.state}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.zipcode}" /></td>
			<td class="myTableCell" style="padding-right: 30px; "><c:out value="${item.role}" /></td>
             <td> <a href="/mac/SystemUserController?action=ViewSpecificUpdateUser&id=${item.username}">Edit</a></td>
			</tr>
		</c:forEach>
 </table>
 </form>
 <a href="adminhomepage.jsp"  target="_top"><span>BackToHomePage</span></a>
</body>
</html>