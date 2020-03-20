<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company form</title>
</head>
    <div class="header_resize">
      <div class="logo"><h1><a href="/mac"></a>Reservation</h1></div>
      <div class="menu_nav">
      </div>
  </div>
<body>
<table>
  <tr>
   <td>
         <table border="1" class="myTable"> 
    <tr>
    <td> MAR Number: </td>
    <td> <c:out value="${RESERVATION.marnumber}" /> </td>
    </tr>

    <tr>
    <td> Facility Name: </td>
    <td> <c:out value="${RESERVATION.facilityname}"/> </td>
    </tr>

    <tr>
    <td> Reported By: </td>
    <td> <c:out value="${RESERVATION.reportedby}" /> </td>
    </tr>

    <tr>
    <td> description: </td>
    <td> <c:out value="${RESERVATION.description}" /> </td>
    </tr>
    
    <tr>
    <td> Date: </td>
    <td> <c:out value="${RESERVATION.date}" /> </td>
    </tr>
    
    <tr>
    <td> Time: </td>
    <td> <c:out value="${RESERVATION.time}" /> </td>
    </tr>
    
    <tr>
    <td> Assigned to: </td>
    <td> <c:out value="${RESERVATION.assignedto}" /> </td>
    </tr>
    
    <tr>
    <td> Assigned Date: </td>
    <td> <c:out value="${RESERVATION.assigneddate}" /> </td>
    </tr>
     
    <tr>
    <td> Estimate Time of Repair  </td>
    <td> <c:out value="${RESERVATION.estimateofrepair}" /> </td>
    </tr>
    
     <tr>
    <td> Assigned Date: </td>
    <td> <c:out value="${RESERVATION.startTime}" /> </td>
    </tr>
     
    <tr>
    <td> Estimate Time of Repair  </td>
    <td> <c:out value="${RESERVATION.endTime}" /> </td>
    </tr>

    <tr>
    </tr>
    </table>
</td>
</tr>
</table>
 <li><a href="repairerhomepage.jsp"  target="_top"><span>Back To Homepage</span></a></li>
 <li><a href="/mac/SystemUserController?action=logout"  target="_top"><span>Logout</span></a></li>
   
</body>
</html>