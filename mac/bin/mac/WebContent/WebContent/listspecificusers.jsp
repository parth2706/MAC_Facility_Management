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
    <td> UserName: </td>
    <td> <input name="username" value="<c:out value="${USERS.username}" />" type="text" maxlength="16">  </td>
    </tr>

    <tr>
    <td> Password: </td>
    <td> <c:out value="${USERS.password}" /> </td>
    </tr>

    <tr>
    <td> UtaID: </td>
    <td> <c:out value="${USERS.utaid}" /> </td>
    </tr>

    <tr>
    <td> FirstName: </td>
    <td> <input name="firstname" value="<c:out value="${USERS.firstname}" />" type="text"  maxlength="16"> </td>
    </tr>
    
    <tr>
    <td> LastName: </td>
    <td> <input name="lastname" value="<c:out value="${USERS.lastname}" />" type="text"  maxlength="16"> </td>
    </tr>
    
    <tr>
    <td> Phone: </td>
    <td> <input name="phone" value="<c:out value="${USERS.phone}" />" type="text"  maxlength="16"> </td>
    </tr>

    <tr>
    <td> Email: </td>
    <td><input name="email" value=" <c:out value="${USERS.email}" />" type="text"  maxlength="16"> </td>
    </tr>
    
    <tr>
    <td> Address: </td>
    <td><input name="address" value="  <c:out value="${USERS.address}" />" type="text"  maxlength="16"> </td>
    </tr>
    
    <tr>
    <td> City: </td>
    <td><input name="city" value=" <c:out value="${USERS.city}" />" type="text"  maxlength="16"> </td>
    </tr>
    
    <tr>
    <td> State: </td>
    <td> <input name="state" value=" <c:out value="${USERS.state}" />" type="text"  maxlength="16"> </td>
    </tr>
    
    <tr>
    <td> ZipCode: </td>
    <td> <input name="zipcode" value=" <c:out value="${USERS.zipcode}" />" type="text"  maxlength="16"> </td>
    </tr>
    
    <tr>
    <td> Role: </td>
    <td> <c:out value="${USERS.role}" /> </td>
    <!--<td> <input name="role" value="<c:out value='${systemuser.role}'/>" type="text" maxlength="16"> </td>-->
    <td>
    <select name="role">
        <c:forEach items="${USERROLES}" var="rolenames">
            <option ><c:out value="${rolenames}"/></option>
        </c:forEach>
    </select>
    </td>
    </tr>
    
    <tr>
    </tr>
    </table>
     <input name="action" value="updateRole" type="hidden">
    <input type="submit" value="Update Role">
    <!--  <input name="action" value="updateUser" type="hidden">
    <input type="submit" value="Update User">-->
    <!-- <li><a href="/mac/SystemUserController?action=updateUser"  target="_top"><span>UpdateUser</span></a></li> -->
</td>
</tr>
</table>
</form>
</body>
</html>