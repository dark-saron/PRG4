<%@page import="de.fhe.ai.prg4.model.Address"%>
<%@page import="de.fhe.ai.prg4.view.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kontakt Details</title>
</head>
<body>
<jsp:include page="/include/navigation.jsp"></jsp:include>
		
		<div style='float:left; padding:5% 20%'>
<div id='content' style='margin:auto; width:800px'>
<h1>Kontakt Details</h1>
<br><br><br>

<jsp:useBean id="contactL" class ="de.fhe.ai.prg4.controller.ContactLogic" />
<jsp:useBean id="contact" class ="de.fhe.ai.prg4.model.Contact" />
<jsp:useBean id="address" class ="de.fhe.ai.prg4.model.Address" />
<%
  int id = Integer.parseInt(request.getParameter( "param" ));
  contact = contactL.getContact(id);
  address = contactL.getAddress(contact.getBilling_Address_Id());
%>
<h3>Persönliche Daten:</h1>
<br>
<table id="details" width='500' border='1'>
			<tr>
				<td ><b>Vorname: </b></td>
				<td >	<%= contact.getFirst_Name() %></td>
			</tr>
			<tr>
				<td><b>Nachname: </b></td>
				<td><%= contact.getLast_Name() %></td>
			</tr>
			<tr>
			<td><b>Email: </b></td>
			<td>	<%= contact.getEmail() %></td>
			</tr>
						<tr>
			<td><b>Phone: </b></td>
			<td>	<%= contact.getPhone() %></td>
			</tr>
			<tr>
			<td><b>Mobile:</b></td>
			<td>	<%= contact.getMobile() %></td>
			</tr>
			<tr>			
		</table>
		<hr><h3>Anschrift: </h3>
		<table id="address_details" width='500' border='1'>
			<tr>
				<td ><b>Anrede: </b></td>
				<td >
			    <%
			    	String anrede = "";
    				
		    	if(address.getGender().matches("f"))
		    		anrede = "Frau";
		    	else
		    		anrede = "Herr";
				%>
			    <%= anrede %></td>
				
				</td>
			</tr>
			<tr>
			<td ><b>Titel: </b></td>
			<td >	<%= address.getTitle() %></td>
			</tr>
			<tr>
			<td ><b>Name: </b></td>
			<td >	<%= address.getFirst_Name() %> <%= address.getLast_Name() %></td>
			</tr>
			<tr>
			<td ><b>Straße und Nr.: </b></td>
			<td >	<%= address.getStreet_Nr() %></td>
			</tr>
			<tr>
			<td ><b>Ort: </b></td>
			<td ><%= address.getZip() %> <%= address.getCity() %></td>
			</tr>
			<tr>
			<td><b>Land: </b></td>
			<td>	<%= address.getCountry() %></td>
			</tr>
		</table>
		
		<div style='float:left; padding:5% 0%'>
			<a href="ContactEdit?param=<%=contact.getId() %>">Bearbeiten</a>
			<a href="DeleteContact?param=<%=contact.getId() %>">Löschen</a>
		</div></div></div>
		
</body>
</html>