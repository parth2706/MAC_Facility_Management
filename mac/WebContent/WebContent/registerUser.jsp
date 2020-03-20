<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company form</title>
</head>
<body>
<h1>Register user</h1>

<input name="errMsg"  value="<c:out value='${UerrorMsgs.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="registerUserForm" action="SystemUserController?saveUser" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> Username (*): </td>
    <td> <input name="username" value="<c:out value='${systemuser.getUsername()}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="usernameError"  value="<c:out value='${UerrorMsgs.usernameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td> 
    </tr>
    
    <tr>
    <td> Password (*): </td>
    <td> <input name="password" value="<c:out value='${systemuser.getPassword()}'/>" type="text" maxlength="45">  </td>
 	<td> <input name="passwordError"  value="<c:out value='${UerrorMsgs.passwordError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <td> First Name (*): </td>
    <td> <input name="firstname" value="<c:out value='${systemuser.getFirstname()}'/>" type="text" maxlength="16"> </td>
  	<td> <input name="firstNameError"  value="<c:out value='${UerrorMsgs.firstNameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <td> Last Name (*): </td>
    <td> <input name="lastname" value="<c:out value='${systemuser.getLastname()}'/>" type="text" maxlength="16"> </td>
  	  <td> <input name="lastNameError"  value="<c:out value='${UerrorMsgs.lastNameError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td> 
    </tr>

    <tr>
    <td> UTA ID </td>
    <td> <input name="utaId" value="<c:out value='${systemuser.getUtaid()}'/>" type="text" maxlength="16">  </td>
  	<td> <input name="utaIdError"  value="<c:out value='${UerrorMsgs.utaIdError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td> Email (*): </td>
    <td> <input name="email" value="<c:out value='${systemuser.getEmail()}'/>" type="text" maxlength="45">  </td>
  	<td> <input name="emailError"  value="<c:out value='${UerrorMsgs.emailError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td> 
    </tr>
    
    <tr>
    <td> Phone </td>
    <td> <input name="phone" value="<c:out value='${systemuser.getPhone()}'/>" type="text" maxlength="16">  </td>
  	<td> <input name="phoneError"  value="<c:out value='${UerrorMsgs.phoneError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Address (*): </td>
    <td> <input name="address" value="<c:out value='${systemuser.getAddress()}'/>" type="text" maxlength="16"> </td>
    <td> <input name="addressError"  value="<c:out value='${UerrorMsgs.addressError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> City (*): </td>
    <td> <input name="city" value="<c:out value='${systemuser.getCity()}'/>" type="text" maxlength="16"> </td>
    <td> <input name="cityError"  value="<c:out value='${UerrorMsgs.cityError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> State (*): </td>
    <td> <input name="state" value="<c:out value='${systemuser.getState()}'/>" type="text" maxlength="16"> </td>
    <td> <input name="stateError"  value="<c:out value='${UerrorMsgs.stateError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Zip Code </td>
    <td> <input name="zipcode" value="<c:out value='${systemuser.getZipcode()}'/>" type="text" maxlength="16">  </td>
  	<td> <input name="zipcodeError"  value="<c:out value='${UerrorMsgs.zipcodeError}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"  disabled="disabled" maxlength="60"> </td>
    </tr>
    
    <tr>
    <td> Role </td>
    <td> 
    <tr class="myTableRow" style = "display: grid;">
			<td><input type="radio" id="user" name="role" value="user">User</input></td>
			<td><input type="radio" id="facilityManager" name="role" value="facility manager">Facility Manager</input></td>
			<td><input type="radio" id="admin" name="role" value="admin">Admin</input></td>		
			<td><input type="radio" id="repairer" name="role" value="repairer">Repairer</input></td>		
	</tr>
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
    <input name="action" value="saveUser" type="hidden">
    <input type="submit" value="Insert User">
    </form>
</td>
</tr>
</table>

</body>
</html>