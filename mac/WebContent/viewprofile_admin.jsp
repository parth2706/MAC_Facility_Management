<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Specific User form</title>
</head>
    <div class="header_resize">
      <div class="logo"><h1><a href="/mac/SystemUserController?gotohomepage" method="post">Mavericks Application Center</a></h1></div>
      <div class="menu_nav">
      </div>
  </div>
<body>
<form name="updatesystemuserform" action="/mac/SystemUserController?viewprofile" method="post">
<table>
  <tr>
   <td>
         <table border="1" class="myTable"> 
    <tr>
    <td> UserName: </td>
    <td> <c:out value="${USER1.username}" /> </td>
    </tr>

    <tr>
    <td> Password: </td>
    <td> <c:out value="${USER1.password}" /> </td>
    </tr>

    <tr>
    <td> UtaID: </td>
    <td> <c:out value="${USER1.utaid}" /> </td>
    </tr>

    <tr>
    <td> FirstName: </td>
    <td> <c:out value="${USER1.firstname}" /> </td>
    </tr>
    
    <tr>
    <td> LastName: </td>
    <td> <c:out value="${USER1.lastname}" /> </td>
    </tr>
    
    <tr>
    <td> Phone: </td>
    <td> <c:out value="${USER1.phone}" /> </td>
    </tr>

    <tr>
    <td> Email: </td>
    <td> <c:out value="${USER1.email}" /> </td>
    </tr>
    
    <tr>
    <td> Address: </td>
    <td> <c:out value="${USER1.address}" /> </td>
    </tr>
    
    <tr>
    <td> City: </td>
    <td> <c:out value="${USER1.city}" /> </td>
    </tr>
    
    <tr>
    <td> State: </td>
    <td> <c:out value="${USER1.state}" /> </td>
    </tr>
    
    <tr>
    <td> ZipCode: </td>
    <td> <c:out value="${USER1.zipcode}" /> </td>
    </tr>
    
    <tr>
    <td> Role: </td>
    <td> <c:out value="${USER1.role}" /> </td>
    <!--<td> <input name="role" value="<c:out value='${systemuser.role}'/>" type="text" maxlength="16"> </td>-->
    </tr>
   
    <tr>
    </tr>
    </table>
</td>
</tr>
</table>

</form>
 <a href="adminhomepage.jsp"  target="_top"><span>BackToHomePage</span></a>
</body>
</html>