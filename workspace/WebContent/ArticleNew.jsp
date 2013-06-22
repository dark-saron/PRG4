<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Neuer Artikel</title>
</head>
<body>
<form action="Article" method="post">
<table>
    <tr><td><b>Name:</b>	</td><td><input type="text" name="name"></td></tr>
    <tr><td><b>Type(Dropdown): </b></td><td><input type="text" name="type"></td></tr>
    <tr><td><b>Beschreibung: </b></td><td><input type="text" name="description"></td></tr>
    <tr><td><b>ISBN: </b></td><td><input type="text" name="ISBN"></td></tr>
    <tr><td><b>Artikel erstellen: </b></td><td><input type="submit" value="article"></td></tr>
</table><br>    
    
    <span class="error">${error}</span>

</form>
</body>
</html>