<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User HomePage</title>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">

<!-- TO MAKE THE URL REFERENCES WORK YOU MUST HAVE SESSION ID DISABLED IN URL - SEE WEB.XML -->

      <div class="logo"><h2><a href="<c:url value='/' />">User HomePage</a></h2></div>
  <div class="content">  

<input name="errMsg"  value="<c:out value='${sucMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
      <div class="menu_nav">
        <ul>
          <!--<li><a href="/company_management/CompanyController?action=listCompany"  target="_top"><span>List Companies</span></a></li>-->
          <li><a href="/mac/SystemUserController?action=viewprofile"  target="_top"><span>View Profile</span></a></li>  
          <li><a href="/mac/SystemUserController?action=updateprofile"  target="_top"><span>Update Profile</span></a></li>  
          <!--<li><a href="createproblemreport.jsp"  target="_top"><span>Create Problem Report</span></a></li>-->
          <li><a href="/mac/MarController?action=createproblemreport"  target="_top"><span>Create Problem Report</span></a></li>
          <li><a href="/mac/MarController?action=viewmars"  target="_top"><span>Search Problem Report</span></a></li>  
        </ul>
      </div>
    </div>
  </div>
  </div>
  </div>
  <!--  <input type="submit" value="Logout">-->  
  <li><a href="/mac/SystemUserController?action=logout"  target="_top"><span>Logout</span></a></li>
</body>
</html>