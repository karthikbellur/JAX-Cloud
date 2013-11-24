<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JAX Cloud Home</title>
</head>
<body>
<h2>JAX Cloud Web Console</h2>
<form action="myacc.action" method="post">
<fieldset style="width:300px;height:auto;">
<table cellspacing="15" align="left">

<tr>
<td>User ID</td> 
<td><input type="text" name="user.uid"/></td>
</tr>

<tr>
<td>Password</td> 
<td><input type="text" name="user.pwd"/></td>
</tr>

<tr align="right"><td></td><td>		
<input type="Submit" value="Submit"/>		
</td></tr>

</table>
</fieldset>
</form>

</body>
</html>