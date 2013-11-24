<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script src="jquery.js"></script>
<script>
	function executeCommand() {				
		$.getJSON("executeShellCmd.action?command.commandName=" + terminal.value + "&"
				+ "command.platform=" + platform.value, function(json) {
			document.getElementById("terminal").value = terminal.value + json.output + "\$";							
		});
	};

	function clearTerminal() {
		document.getElementById("terminal").value = "";
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Virtual Terminal</title>
</head>
<body>
<table cellspacing="15">
	<tr>
		<td><font size="6px"><b>Virtual Terminal</b></font></td>		
		<td><a href="MyAcc.jsp">Back</a></td>
		<td><a href="logout.action">Logout</a></td>
	</tr>
</table>
<br />
<form action="" method="POST">
<fieldset style="width: 450px;">
<table cellspacing="20">
	<tr>
		<td>Select required platform</td>
		<td><select id="platform" name="platform">
			<option>Ubuntu</option>
			<option>Microsoft Windows XP</option>
			<option>Open Solaris</option>
		</select></td>
		<td></td>
		<td><button onclick="clearTerminal()">Clear Terminal</button></td>
	</tr>
	<tr>
		<td>Type in your command here</td>
		<td><textarea id="terminal" name="terminal" cols="100" rows="20"
			onkeypress="if(event.keyCode==13)executeCommand()">$</textarea></td>
	</tr>
</table>
</fieldset>
</form>
<s:actionmessage />
<s:actionerror />
</body>
</html>