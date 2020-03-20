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
<form name="updatesystemuserform" action="/mac/SystemUserController?updateRole" method="post">
<table>
  <tr>
   <td>
         <table border="1" class="myTable"> 
    <tr>
    <td> MarNumber: </td>
    <td> <input name="username" value="<c:out value="${SPECIFICMARS.marnumber}" />" type="text" maxlength="16">  </td>
    </tr>

    <tr>
    <td> FacilityName: </td>
    <td> <c:out value="${SPECIFICMARS.facilityname}" /> </td>
    </tr>

    <tr>
    <td> Description: </td>
    <td> <c:out value="${SPECIFICMARS.description}" /> </td>
    </tr>

    <tr>
    <td> ReportedBy: </td>
    <td> <c:out value="${SPECIFICMARS.reportedby}" /> </td>
    </tr>
    
    <tr>
    <td> Date: </td>
    <td> <c:out value="${SPECIFICMARS.date}" /> </td>
    </tr>
    
    <tr>
    <td> Time: </td>
    <td> <c:out value="${SPECIFICMARS.time}" /> </td>
    </tr>

    <tr>
    <td> AssignedTo: </td>
    <td> <c:out value="${SPECIFICMARS.assignedto}" /> </td>
    </tr>
    
    <tr>
    <td> AssignedDate: </td>
    <td> <c:out value="${SPECIFICMARS.assigneddate}" /> </td>
    </tr>
    
    <tr>
    <td> EstimateofRepair: </td>
    <td> <c:out value="${SPECIFICMARS.estimateofrepair}" /> </td>
    </tr>
    
    <tr>
    </tr>
    </table>
</td>
</tr>
</table>
</form>
</body>
</html>