<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Problem Report form</title>
</head>
<body>
<h1>Create Problem Report</h1>
<input name="errMsg"  value="<c:out value='${Message.errorMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
  <tr>
   <td>
    <form name="createproblemreportform" action="/mac/MarController?createMAR" method="post">
    <table style="width: 1200px; ">
    <tr>
    <td> MAR Number : </td>
    <td> <input name="marnumber" value="<c:out value='${CreateReportDetailsMARNumber}'/>" type="text" maxlength="16">
    </tr>

    <tr>
    <td> Facility Name : </td>
    <td>
    <select name="facilityname">
        <c:forEach items="${CreateReportDetailsFacilityNames}" var="fnames">
            <option ><c:out value="${fnames}"/></option>
        </c:forEach>
    </select>
    </td> 
    </tr>

    <tr>
    <td> Description :</td>
    <td> <input name="description" value="<c:out value='${mar.description}'/>" type="text" style ="height:50px; width: 140px" maxlength="256">  </td>
  	<td> <input name="descriptionerror"  value="<c:out value='${Message.descriptionerror}'/>" type="text"  style ="background-color: white; color: red; border: none; width: 800px"   disabled="disabled" maxlength="60"> </td>
    </tr>

    <tr>
    <td> Reported By :</td>
    <!--  <td> <input name="reportedby" value="<c:out value='${SystemUserSession}'/>" type="text" maxlength="16">-->
    <td> <input name="reportedby" value="<c:out value='${systemuser.username}'/>" type="text" maxlength="16">
    </tr>
    </table>
    <input name="action" value="createMAR" type="hidden">
    <input type="submit" value="Create MAR">
    </form>
</td>
</tr>
</table>
<a href="userhomepage.jsp"  target="_top"><span>BackToHomePage</span></a>
</body>
</html>