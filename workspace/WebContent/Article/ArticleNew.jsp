<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Neuer Artikel</title>
</head>
<body>
<div id='navi'>
	<div id='content' style='margin:auto; width:600px'>
	<span style='float:left; padding-right:5%'><h2><a href='/flogit_web/ArticleList'>Artikel Liste</a></h2></span>
    <span style='float:left;padding-right:5%'><h2><a href='/flogit_web/OfferList'>Angebots Liste</a></h2></span>
    <span style='float:left;padding-right:5%'><h2><a href='/flogit_web/ContactList'>Kontakt Liste</a></h2></span>
    </div></div>
		
<h1>Neuen Artikeln anlegen:</h1>
<br><br><br>
<form action="psNA" method="post">
<table>
    <tr><td><b>Name:</b>	</td><td><input type="text" name="name"></td></tr>
    <tr><td><b>Type: </b></td><td>
    	<select name="type">
			<option value="Buch">Buch</option>
			<option value="CD">CD</option>
			<option value="DVD">DVD</option>
			<option value="Spiel">Spiel</option>
		</select>
     </td></tr>
    <tr><td><b>Beschreibung: </b></td><td><input type="text" name="description"></td></tr>
    <tr><td><b>EAN/ISBN: </b></td><td><input type="text" name="ean_isbn"></td></tr>
    <tr><td><b>External ID: </b></td><td><input type="text" name="externalID"></td></tr>
    <tr><td><b>Lager: </b></td><td><input type="text" name="place"></td></tr>


    <tr><td><b>Artikel erstellen: </b></td><td><input type="submit" value="article"></td></tr>


</table><br>    
    
    <span class="error">${error}</span>

</form>
</body>
</html>