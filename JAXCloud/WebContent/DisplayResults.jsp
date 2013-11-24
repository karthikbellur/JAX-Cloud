<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Execution Summary</title>
</head>

<body>
<table cellspacing="15">
<tr>
<td><font size="5px"><b>Execution Summary</b></font></td>						
<td><a href="MyAcc.jsp">Back</a></td>
<td><a href="logout.action">Logout</a></td>
</tr>
</table>
<br/>
<fieldset style="width:500px;height:auto;">				
<table cellspacing="15">
<tr>
<td>Selected OS : </td>
<td><b><s:property value="output.os"/></b></td>
</tr>
<tr>
<td>Uploaded C Source File : </td>
<td><b><s:property value="output.inputFile"/></b></td>
</tr>
<tr>
<td>Time Taken to execute on desired platform( Compile + Execute ) : </td>
<td><b><s:property value="output.estimatedTime"/> s</b></td>
</tr>
<tr>
<td>Machine ID : </td>
<td><b><s:property value="output.machineId"/></b></td>
</tr>
<tr>
<td>Memory Allocated to Machine : </td>
<td><b><s:property value="output.memoryAllocated"/> MB</b></td>
</tr>
<tr>
<td><a href="<s:property value="output.outputFilename"/>">Output of execution</a></td>
</tr>
</table>
</fieldset>

</body>

</html>