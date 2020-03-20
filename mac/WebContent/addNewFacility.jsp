<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company form</title>
</head>
<body>
<h1>Add New Facility</h1>

<input name="errMsg"  value="<c:out value='${FerrorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="registerUserForm" action="/mac/FacilityController?action=saveFacility" method="post" >
	    <table style="width: 1200px; ">
	    
	    
	    <tr>
	    <td> Facility Type: (*): </td>
	    <td> <input name="facilitytype" value="<c:out value='${facility.getFacilityType()}'/>" type="text" maxlength="45">  </td>
	 	<td> <input name="facilitytypeError"  value="<c:out value='${FerrorMsgs.facilitytypeError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
	    </tr>
	    
	    <tr>
	    <td> Facility Name: (*): </td>
	    <td> <input name="facilityName" value="<c:out value='${facility.getFacilityName()}'/>" type="text" maxlength="16"> </td>
	  	<td> <input name="facilitynameError"  value="<c:out value='${FerrorMsgs.facilitynameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td> 
	    </tr>
	    
	    <tr>
	    <td> Interval (*): </td>
	    <td>
	    <select name="interval">
	        <option value="30 min">30 Mins</option>
	        <option value="1 hour">1 Hour</option>
	        <option value="2 hour">2 Hours</option>
	    </select>
	    </td>
	    </tr>
	    
	    
	    <tr>
	    <td> Duration (*): </td>
	    <td>
	    <select name="duration">
	        <option value="same day">Same Day</option>
	        <option value="seven day">Seven Day</option>
	    </select>
	    </td>
	    </tr>
	    
		<!-- 
	    <tr>
	    <td> Venue: </td>
	    <td> <input name="venue" value="<c:out value='${systemuser.getUtaid()}'/>" type="text" maxlength="16">  </td>
	  	<td> <input name="utaIdError"  value="<c:out value='${UerrorMsgs.utaIdError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
	    </tr>
	     -->
	    <tr>
	    <td> Venue </td>
	    <td> 
	    <select name="venue">
	        <option value="indoor">Indoor</option>
	        <option value="outdoor">Outdoor</option>
	    </select>
	   <!-- <select>
	    	<option name = "role" value="student">Student</option>
		  <option name = "role" value="facilityManager">Facility Manager</option>
		  <option name = "role" value="admin">Admin</option>
	    </select>  --> 
	    </td>
	    </tr>
	    
	    <tr>
	    <td colspan="2">(*) Mandatory field</td>
	    </tr>
	    </table>
	    
	    <input type="submit" value="saveFacility">
    </form>
</td>
</tr>
</table>
</body>
</html>