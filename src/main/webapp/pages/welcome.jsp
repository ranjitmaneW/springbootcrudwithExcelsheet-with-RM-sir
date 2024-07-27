<html>





<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
    
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

body{
background-color:green;


}
</style>
</head>
<body>

<center>
<h1>welcome</h1>

<table border="2px">
<tr>
<th>ID</th>
<th>FULLNAME</th>
<th>SEMAIL</th>
<th>MOBILE</th>
<th>AGE</th>
<th>ACTION</th>
</tr>



<c:forEach items="${l1 }" var="e">


<tr>
<td>${e.id }</td>
<td>${e.fullname }</td>
<td>${e.SEmail }</td>
<td>${e.mobi }</td>
<td>${e.age }</td>
<td>
<a href="delete?id=${e.id}"> Delete</a> 
  <a href="update?id=${e.id}"> update</a>
 <a href="download?id=${e.id}"> download</a>
   <a href="downloadAllEmployees"> downloadAllEmployees</a>
  
</td>


</tr>

</c:forEach>


</table>



</body>
