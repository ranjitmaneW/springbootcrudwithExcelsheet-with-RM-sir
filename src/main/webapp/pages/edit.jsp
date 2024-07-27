<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Edit</h1>

<form action="updatedata" method="post">

<input type="hidden" name="id"    value="${updatekey.id}"/>

<input type="text" name="fullname"   value="${updatekey.fullname}" />

<input type="email" name="SEmail"    value="${updatekey.SEmail}"/>

<input type="text" name="mobi"   value="${updatekey.mobi}" />

<input type="number" name="age"      value="${updatekey.age }"/>

<input type="submit" value="submit"/>



</form>

</body>
</html>