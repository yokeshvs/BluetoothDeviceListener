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
<center><h3>Device Logger</h3></center>
<br />
<hr />
<br />
<br />
	<center>
		Hi there!<br />

		<form action="RetrieveLoggerFiles" method="get" name="loggerForm">
			<label>Get the list of logger files</label> <input type="submit"
				value="Get Files" />
		</form>
	</center>

</body>
</html>