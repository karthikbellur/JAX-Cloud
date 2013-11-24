<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input Code Execution</title>
<script type="text/javascript">
function verify()
{
	if(file.value=="")
	{
		alert("Please Upload C Source Code and Retry!");	
		return false;
	}
	document.getElementById("submit").setAttribute("disabled", "disabled");
	return true;
}
</script>
</head>
<body>
<form action="executeCommand.action" method="POST" enctype="multipart/form-data" onsubmit="return verify()">
<table cellspacing="15">
<tr>
<td><font size="5px"><b>Input C Code Execution On Selected Platform</b></font></td>						
<td><a href="MyAcc.jsp">Back</a></td>
<td><a href="logout.action">Logout</a></td>
</tr>
</table>
<br/>
<fieldset style="width:450px;auto;">				
<table cellspacing="20">
<tr>
<td>
Select required platform
</td>
<td>
<select name="input.os">
<option>Ubuntu</option>
<option>Microsoft Windows XP</option>
<option>Open Solaris</option>
</select>	
</td>
</tr>
<tr><td>Upload C source file</td>
<td><s:file id="file" name="input.upload"/></td>
</tr>
<tr align="center">
<td></td>
<td>
<input id="submit" type="Submit" value="Execute Now"/>
</td></tr>
</table>  
</fieldset>
</form>
<s:actionmessage/>
<s:actionerror/>	
</body>
</html>