<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Angebot Löschen</title>
</head>
<body>
<jsp:include page="/include/navigation.jsp"></jsp:include>

    
<div style='float:left; padding:5% 20%'>

<div id='content' style='margin:auto; width:800px'>

<jsp:useBean id="offerL" class ="de.fhe.ai.prg4.controller.OfferLogic" />
<jsp:useBean id="offer" class ="de.fhe.ai.prg4.model.Offer" />

<%
  int id = Integer.parseInt(request.getParameter( "param" ));
  offer = offerL.getOffer(id);		
%>
		
<h1>Angebot Löschen:</h1>
<br><br><br>
<form action="OfferDelete" method="post">
<table>
	<tr ><td><b>ID:</b>	</td>
    	<td><div><%= offer.getId() %></div></td>
		<td style="display:none"><input type="text" name="id" value="<%= offer.getId() %>" ></td>
	</tr>
    <tr style="display:hide">
    	<td><b>Name:</b>	</td>
    	<td><div><%= offer.getArticle_Name() %></div>
    	</td>
    </tr>
    <tr><td><br><br><input type="submit" value="Angebot Löschen"></td></tr>
</table>
</form>
<br>
<a href="/flogit_web/OfferDetails?param=<%= offer.getId() %>">Zurück zur Detail Seite</a>

</div></div>
</body>
</html>