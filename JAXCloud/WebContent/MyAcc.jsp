<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Account</title>
</head>
<body>
Welcome <b><s:property value="#session['user'].uid" /></b>	
&nbsp;&nbsp;&nbsp;<a href="logout.action">Logout</a>
<br/><br/>
<fieldset style="width:400px;height:auto;">						
<table cellspacing="20">
<tr><td><a href="executeInputCodeView.action">Compile/Execute Input C code on selected platform</a></td></tr>
<tr><td><a href="executeShellCmdView.action">Execute Shell commands on selected platform</a></td></tr>
<tr><td><a href="">Obtain a dedicated machine on selected platform</a></td></tr>
<tr><td><a href="">Deploy your J2EE application on selected platform</a></td></tr>
</table>
</fieldset>
</body>
</html>