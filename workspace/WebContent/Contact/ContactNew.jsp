<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Neuer Kontakt</title>
</head>
<body>
<jsp:include page="/include/navigation.jsp"></jsp:include>

		<div style='float:left; padding:5% 20%''>
<div id='content' style='margin:auto; width:800px'>
		
<h1>Neuen Kontakt anlegen:</h1>
<br><br><br>
<form action="psNK" method="post">
<h3>Persönliche Daten:</h1>
<br>
<table>
    <tr><td><b>Titel:</b>	</td><td><input type="text" name="cTitle" placeholer="Dr."></td></tr>
    <tr><td><b>Vorname:</b>	</td><td><input type="text" name="cFirst_Name" placeholer="Max"></td></tr>
    <tr><td><b>Nachname:</b>	</td><td><input type="text" name="cLast_Name" placeholer="Mustermann"></td></tr>
    <tr><td><b>Email: </b></td><td><input type="text" name="cEmail" placeholer="muster@email.de"></td></tr>
    <tr><td><b>Telefon: </b></td><td><input type="text" name="cPhone" placeholer="01234-12343"></td></tr>
    <tr><td><b>Mobile: </b></td><td><input type="text" name="cMobile" placeholer="01234-1234"></td></tr>
	<br />
</table><br>    
<hr>
<h3>Anschrift: </h3>
<table>
    
	<tr>
		<td><b>Anrede:</b></td>
		<td>
			<input type="radio" name="aGender" value="m" checked>Herr<br>
			<input type="radio" name="aGender" value="f">Frau
		</td>
	</tr>
	<tr><td><b>Titel:</b>	</td><td><input type="text" name="aTitle" placeholer="Dr."></td></tr>
    <tr><td><b>Vorname:</b>	</td><td><input type="text" name="aFirst_Name" placeholer="Max"></td></tr>
    <tr><td><b>Nachname:</b>	</td><td><input type="text" name="aLast_Name" placeholer="Mustermann"></td></tr>
    <tr><td><b>Straße und Nr.: </b></td><td><input type="text" name="aStreet_Nr" placeholer="Luther Str. 7"></td></tr>
    <tr><td><b>PLZ: </b></td><td><input type="text" name="aZip" placeholer="01234"></td></tr>
    <tr><td><b>Stadt: </b></td><td><input type="text" name="aCity" placeholer="Erfurt"></td></tr>
    <tr><td><b>Land: </b></td><td><input type="text" name="aCountry" placeholer="Deutschland"></td></tr>
	<br />
	<br />


</table><br>    
<tr><td><b>Kontakt erstellen: </b></td><td><input type="submit" value="contact"></td></tr>


    
    <span class="error">${error}</span>

</form>
<br>
<a href="/flogit_web/ContactList">Zurück</a>

</body>
</html>