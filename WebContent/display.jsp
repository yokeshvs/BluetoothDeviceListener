<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>BluetoothDeviceListener Console</title>
</head>
<body>
	<br />
	<br />
	<center>
		Hi there! <br /> <br /> To update the list of files, click below
		<form action="">
			<input type="button"
				onclick="window.location.href=window.location.href" value="Refresh" />
		</form>

		<hr />
		<h2>Logger files</h2>
		<br />
		<div>
			<%
				@SuppressWarnings("unchecked")
				ArrayList<String> files = (ArrayList<String>) request.getAttribute("files");
				for (String file : files) {
			%>
			<a href="DeviceListener?file=<%=file%>" target="_blank"><%=file%></a><br />
			<%
				}
			%>
		</div>
	</center>
</body>
</html>