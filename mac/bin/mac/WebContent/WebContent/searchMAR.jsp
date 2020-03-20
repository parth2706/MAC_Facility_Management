<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Search MAR</h1>

<form  action="/mac/MarController?action=searchAndShowListOfMar" method="post">
<table>
<tr>
<td> Start Date:
</td>
<td><input type="date" name="dateToSearchMAR" value="<c:out value="${DATE}" />"  >
</td>
<td><c:out value="${DATE}" />  
</td>
<td> Start Time:
</td>
<td><input type="time" name="timeToSearchMAR" value="<c:out value="${TIME}" />">
</td>
</tr>

<tr>
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
<tr>
<td> Assigned To:
</td>
<td> 
<select name="assignedto">
      <c:forEach items="${ASSIGNEDTO}" var="ato">
         <option><c:out value="${ato}"></c:out></option>
      </c:forEach>
   </select>
</td>
<td> MAR No:
</td>
<td>
<select name="marno">
        <c:forEach items="${MARNO}" var="mno">
            <option ><c:out value="${mno}"/></option>
        </c:forEach>
    </select>
</td>
</tr>
</table>
<input type="submit" value="Search MAR">
    </form>
    
<form action="/mac/MarController?action=viewMarToEdit" method="post">          
       <table border="1" class="myTable"> 
			<tr class="myTableRow"> 
				<th style="width: 20px; ">Select MAR</th>
				<th  style="padding-right: 20px; text-align: left">MAR Number</th>
				<th  style="padding-right: 20px; text-align: left">Start Date</th>
				<th  style="padding-right: 35px; text-align: left">Start Time</th> 
				<th  style="padding-right: 20px; text-align: left">Facility Type</th>
				<th  style="padding-right: 30px; text-align: left">Facility Name</th>  
			</tr>

 		<c:forEach items="${MARFACILITY}" var="item" varStatus="status">
			<tr class="myTableRow">
			<td  style="width: 20px; text-align: center"><input type="radio" id="${item.marno}" name="radioMar" value="${item.marno}"></td> 	
			<td  style="padding-right: 20px; "><c:out value="${item.marno}" /></td>
			<td  style="padding-right: 20px; "><c:out value="${item.assignedDate}" /></td>
			<td  style="padding-right: 35px; "><c:out value="${item.assignedTime}" /></td>
			<td  style="padding-right: 20px; "><c:out value="${item.facilityType}" /></td>
			<td  style="padding-right: 30px; "><c:out value="${item.facilityName}" /></td>
		</tr>
		</c:forEach>
 </table>
<input name="ListSelectedCompanyButton" type="submit" value="View">
 </form>    
    
 <a href="fmHomepage.jsp"  target="_top"><span>BackToHomePage</span></a>
</body>
</html>