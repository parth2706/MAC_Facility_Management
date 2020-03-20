<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin HomePage</title>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
<input name="errMsg"  value="<c:out value='${sucMsg}'/>" type="text"  style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<!-- TO MAKE THE URL REFERENCES WORK YOU MUST HAVE SESSION ID DISABLED IN URL - SEE WEB.XML -->

      <div class="logo"><h2><a href="<c:url value='/' />">Admin HomePage</a></h2></div>
      

  <div class="content">  

	
      <div class="menu_nav">
        <ul>
          <!--<li><a href="/company_management/CompanyController?action=listCompany"  target="_top"><span>List Companies</span></a></li>-->
          <li><a href="/mac/SystemUserController?action=viewprofile_admin"  target="_top"><span>View Profile</span></a></li>  
          <li><a href="/mac/SystemUserController?action=updateprofile_admin"  target="_top"><span>Update Profile</span></a></li>  
          <li><a href="/mac/SystemUserController?action=viewusers"  target="_top"><span>Change User Role</span></a></li>
          <li><a href="/mac/SystemUserController?action=viewupdateusers"  target="_top"><span>Edit User Profile</span></a></li>  
          <li><a href="/mac/SystemUserController?action=searchusers"  target="_top"><span>View Users</span></a></li>
        </ul>
      </div>
    </div>
  </div>
  </div>
  </div>
  <!--  <input type="submit" value="logout">-->
  <li><a href="/mac/SystemUserController?action=logout"  target="_top"><span>Logout</span></a></li>  
</body>
</html>