<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Specific User form</title>
</head>
    <div class="header_resize">
      
      <div class="menu_nav">
      </div>
  </div>
<body>

<table>
  <tr>
   <td>
         <table border="1" class="myTable"> 
    <tr>
    <td> Facility Name: </td>
    <td> <c:out value="${Facilities[0].getFacilityName()}" /> </td>
    </tr>

    <tr>
    <td> Facility Type: </td>
    <td> <c:out value="${Facilities[0].getFacilityType()}" /> </td>
    </tr>

    <tr>
    <td> Interval: </td>
    <td> <c:out value="${Facilities[0].getInterval()}" /> </td>
    </tr>

    <tr>
    <td> Duration: </td>
    <td> <c:out value="${Facilities[0].getDuration()}" /> </td>
    </tr>
    
    <tr>
    <td> Venue: </td>
    <td> <c:out value="${Facilities[0].getVenue()}" /> </td>
    </tr>
        <tr>
    </tr>
    </table>
</td>
</tr>
</table>
<a href="fmHomepage.jsp">Back to home page</a>
</body>
</html>