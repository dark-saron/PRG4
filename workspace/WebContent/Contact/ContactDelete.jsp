<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kontakt Löschen</title>
</head>
<body>
<jsp:include page="/include/navigation.jsp"></jsp:include>

<div style='float:left; padding:5% 20%''>
<div id='content' style='margin:auto; width:800px'>


<jsp:useBean id="contactL" class ="de.fhe.ai.prg4.controller.ContactLogic" />
<jsp:useBean id="contact" class ="de.fhe.ai.prg4.model.Contact" />

<%
  int id = Integer.parseInt(request.getParameter( "param" ));
	
  contact = contactL.getContact(id);		
%>
		
<h1>Kontakt Löschen:</h1>
<br><br><br>
<form action="ContactDelete" method="post">
<table>
	<tr ><td><b>ID:</b>	</td>
    	<!-- <td><div><%= contact.getId() %></div></td>
		<td style="display:none"><input type="text" name="id" value="<%= contact.getId() %>" ></td> -->
	</tr>
    <tr style="display:hide">
    	<td><b>Full Name:</b>	</td>
    	<td><div><%= contact.getFirst_Name() %> <%= contact.getLast_Name() %></div>
    	</td>
    </tr>
    <tr><td></td><td><input type="submit" value="Kontakt Löschen"></td></tr>
</table>
</form>
<a href="/flogit_web/ContactDetails?param=<%= contact.getId() %>">Zurück zu Kontakt Details</a>


</body>
</html>