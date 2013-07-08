<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Angebots Details</title>
</head>
<body>

<jsp:useBean id="offerL" class ="de.fhe.ai.prg4.controller.OfferLogic" />
<jsp:useBean id="offer" class ="de.fhe.ai.prg4.model.Offer" />


<%
  int id = Integer.parseInt(request.getParameter( "param" ));
  offer = offerL.getOffer(id);		
%>

<jsp:include page="/include/navigation.jsp"></jsp:include>

<div style='float:left; padding:5% 20%'>
	<div id='content' style='margin:auto; width:800px'>		
		<h1>Angebots Details:</h1>
		<br><br><br>
<form action="editOffer" method="post">
<table>
    <tr>
    	<td><b>ID:</b>	</td>
    	<td><input style="display:none;" type="text" name="id" value="<%= offer.getId() %>" ><%= offer.getId() %></td>
    </tr>
    <tr><td><b>Artikel Name:</b>	</td>
    <td>
			<div><%= offer.getArticle_Name() %></div>
		</td>
    
    <tr><td><b>Status: </b></td>
    <td>
    <%
		    	String statusName = "";
    			int id_status = offer.getStatus();
		    	switch(id_status)
		    	{
		    	case 1:
		    		statusName = "Offen";
					break;
		    	case 2:
		    		statusName = "Gekauft";
					break;
		    	case 3:
		    		statusName = "Abgelaufen";
		    		break;
		    	};    
	%>
    <%= statusName %></td>
    </tr>
     
     
     <tr>
     	<td><b>Start Preis:</b>	</td>
     	<td><%= offer.getStartsaleprice() %></td>
    </tr>
    <tr>
    	<td><b>Buy Now Preis:</b>	</td>
    	<td><%= offer.getBuynowprice() %></td>
    </tr>
    <tr>
    	<td><b>Start Datum: </b></td>
    	<td><%= offer.getStart() %></td>
    </tr>
    <tr>
    	<td><b>End Datum: </b></td>
    	<td><%= offer.getEnd() %></td>
    </tr>
    <tr>
    	<td><b>Auctions Hause: </b></td>
    	<td><%= offer.getAuctionhouse() %></td>
    </tr>
    <tr>
    	<td><b>External Url: </b></td>
    	<td><%= offer.getUrl() %></td>
    </tr>
    <c:set var="existBill" scope="session" value="<%= offerL.existBill(offer.getId()) %>"></c:set>
    <c:set var="ofStatus" scope="session" value="<%=  offer.getStatus() %>"></c:set>
	<c:if test="${ofStatus == '2'}">

    <c:choose>
    <c:when test="${!existBill}">
    	<tr>
    		<td></td>
    		<td><a href="BillCreate1?param=<%= offer.getId()%>">Rechnung erstellen (In Progress)</a></td>
    	</tr>
    </c:when>
    <c:otherwise>
    	<tr>
    	<td></td>
    	<td><a href="BillDetails?param=<%= offer.getId()%>">Rechnung Ansehen (In Progress)</a></td>
    	</tr>	
    </c:otherwise>
    </c:choose>
    	</c:if>	
</table><br> 

		<div style='float:left; padding:5% 0%'>
			<a href="OfferEdit?param=<%=offer.getId() %>">Bearbeiten</a>
			<a href="DeleteOffer?param=<%=offer.getId() %>">Löschen</a>
			<a href="OfferList">Zurück zur Angebots Liste</a>		
		</div></div></div>   

</body>
</html>