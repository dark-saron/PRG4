<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kontakt Bearbeiten</title>
</head>
<body>
<jsp:include page="/include/navigation.jsp"></jsp:include>

<jsp:useBean id="contactL" class ="de.fhe.ai.prg4.controller.ContactLogic" />
<jsp:useBean id="contact" class ="de.fhe.ai.prg4.model.Contact" />
<jsp:useBean id="address" class ="de.fhe.ai.prg4.model.Address" />

<%
  int id = Integer.parseInt(request.getParameter( "param" ));
  contact = contactL.getContact(id);
  address = contactL.getAddress(contact.getBilling_Address_Id());
%>

<div style='float:left; padding:5% 20%''>
<div id='content' style='margin:auto; width:800px'>

<h1>Kontakt bearbeiten:</h1>
<br><br><br>

<form action="editContact" method="post">
<h3>Persönliche Daten:</h1>

<table>
    <tr><td><b>ID:</b>	</td><td><input style="display: none;" type="text" name="id" value="<%= contact.getId() %>"><%= contact.getId() %></td></tr>
    <tr><td><b>Titel:</b>	</td><td><input type="text" name="cTitle" value="<%= contact.getTitle() %>"></td></tr>
    <tr><td><b>Vorname:</b>	</td><td><input type="text" name="cFirst_Name" value="<%= contact.getFirst_Name() %>"></td></tr>
    <tr><td><b>Nachname:</b>	</td><td><input type="text" name="cLast_Name" value="<%= contact.getLast_Name() %>"></td></tr>
    <tr><td><b>Email: </b></td><td><input type="text" name="cEmail" value="<%= contact.getEmail() %>"></td></tr>
    <tr><td><b>Telefon: </b></td><td><input type="text" name="cPhone" value="<%= contact.getPhone() %>"></td></tr>
    <tr>
    	<td><b>Mobile: </b></td>
    	<td><input type="text" name="cMobile" value="<%= contact.getMobile() %>"></td>
    </tr>
	<br />
</table>
<br>    

<h3>(Rechnungs Anschrift) Anschrift: </h3>

<hr>

<table>
	<tr style="display: none;">
    	<td><b>ID:</b>	</td>
    	<td><input type="text" name="aID" value="<%= address.getId() %>"></td>
    </tr>
	<tr>
		<td><b>Anrede:</b></td>
		<td>
			<input type="radio" name="aGender" value="m" checked>Herr<br>
			<input type="radio" name="aGender" value="f">Frau
		</td>
	</tr>
    <tr>
    	<td><b>Vorname:</b>	</td>
    	<td><input type="text" name="aFirst_Name" value="<%= address.getFirst_Name() %>"></td>
    </tr>
    <tr>
    	<td><b>Nachname:</b>	</td>
    	<td><input type="text" name="aLast_Name" value="<%= address.getLast_Name() %>"></td>
    </tr>
    <tr>
    	<td><b>Straße und Nr.: </b></td>
    	<td><input type="text" name="aStreet_Nr" value="<%= address.getStreet_Nr() %>"></td>
    </tr>
    <tr>
    	<td><b>PLZ: </b></td>
    	<td><input type="text" name="aZip" value="<%= address.getZip() %>"></td>
    </tr>
    <tr>
    	<td><b>Stadt: </b></td>
    	<td><input type="text" name="aCity" value="<%= address.getCity() %>"></td>
    </tr>
    <tr>
    	<td><b>Land: </b></td>
    	<td><input type="text" name="aCountry" value="<%= address.getCountry() %>"></td></tr>
	<br />
	<tr><td></td><td><input type="submit" value="Kontakt speichern"></td></tr>

</table><br>    
    <a href="/flogit_web/ContactDetails?param=<%= contact.getId() %>">Zurück</a>
    
    <span class="error">${error}</span>

</form>
</body>
</html>