<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Facility Manager Homepage</title>
</head>
<body>
<h1>Facility Management System </h1>
<ul>
          <li><a href="/mac/FacilityController?action=listUnassignedMARs"  target="_top"><span>Show Unassigned MARs</span></a></li>
           <li><a href="/mac/FacilityController?action=addNewFacility"  target="_top"><span>Add new Facility</span></a></li>
           <li><a href="/mac/FacilityController?action=viewAllFacilities" target="_top"><span>View all Facilities</span></a></li>
       <!--   <li><a href="/mac/FacilityController?action=searchassignedrepaiers"  target="_top"><span>Search for Assigned MARS</span></a></li>   -->
          <li><a href="/mac/MarController?action=searchMAR"   target="_top"><span>Search MARs</span></a></li>
     
        </ul>
<li><a href="/mac/SystemUserController?action=logout"  target="_top"><span>Logout</span></a></li>        
</body>
</html>