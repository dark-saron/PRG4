<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="Javascript/check.js" ></script>
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
	$(function() {
		 var pickerOpts = {
				 dateFormat:"yy-mm-dd"
	    };  
		$( ".datepicker" ).datepicker(pickerOpts);
	});
</script>		


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artikel Bearbeiten</title>
</head>
<body>
<jsp:include page="/include/navigation.jsp"></jsp:include>

<jsp:useBean id="offerL" class ="de.fhe.ai.prg4.controller.OfferLogic" />
<jsp:useBean id="offer" class ="de.fhe.ai.prg4.model.Offer" />
<jsp:useBean id="db" class ="de.fhe.ai.prg4.io_database.DBManager" />

<%
  int id = Integer.parseInt(request.getParameter( "param" ));
  offer = offerL.getOffer(id);
%>


<div style='float:left; padding:5% 20%;'>
	<div id='content' style='margin:auto; width:800px;'>
		<h1>Angebot bearbeiten:</h1>
		<br><br><br>
		<div>* Pflichtfeld </div>
		
		<form id="fOffer" name="fOffer" action="editOffer" method="post">
			<table>
		    <tr><td><b>Angebots ID:</b>	</td>
		    <td ><input style="display:none;" type="text" name="id" value="<%= offer.getId() %>" ><%= offer.getId() %></tr>
		    <tr><td><b>Artikel Name:</b>	</td>
		    <td>
					<input type="text" name="article_Id" style="display:none" value="<%= offer.getArticle_Id() %>">
					<input type="text" name="article_Name" style="display:none" value="<%= offer.getArticle_Name() %>">
					<div><%= offer.getArticle_Name() %></div>
				</td>
		    <!-- TODO: Status string von DB abrufen lassen--> 
		    <tr><td><b>Status*: </b></td>
		    <td>
		    <%
		    	String statusName = "";
		    	switch(offer.getStatus())
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
		    	}
		    
		    %>
		    	<select name="status" >
					<option selected="selected" value="<%= offer.getStatus() %>"><%= statusName %></option>
					<option value="1">Offen</option>
					<option value="2">Gekauft</option>
					<option value="3">Abgelaufen</option>
				</select>
		     </td>
		     </tr>
		     
		     
		     <tr>
		     	<td><b>Start Preis *:</b>	</td>
		     	<td><input type="text" name="startsaleprice" value="<%= offer.getStartsaleprice() %>" placeholder="placeholder="0.00"></td>
		    </tr>
		    <tr>
		    	<td><b>Buy Now Preis *:</b>	</td>
		    	<td><input type="text" name="buynowprice" value="<%= offer.getBuynowprice() %>" placeholder="0.00"></td>
		    </tr>
		    <tr>
		    	<td><b>Start Datum: </b></td>
		    	<td><input type="text" name="start" class="datepicker" value="<%= offer.getStart() %>" placeholder="2013-01-01"></td>
		    </tr>
		    <tr>
		    	<td><b>End Datum: </b></td>
		    	<td><input type="text" name="end" class="datepicker" value="<%= offer.getEnd() %>" placeholder="2013-01-01"></td>
		    </tr>
		    <tr>
		    	<td><b>Auctions Hause *: </b></td>
		    	<td><input type="text" name="auctionhouse" value="<%= offer.getAuctionhouse() %>" placeholder="ebay"></td>
		    </tr>
		    <tr>
    			<td><b> External ID *: </b></td>
    			<td><input type="text" name="externalID" value="<%= offer.getExternalId() %>"></td>
   			 </tr>
   			 <tr>
   			 	<td colspan="2"><i>External ID: Angebots ID vergeben vom Auktionshaus</i></td>
   			 </tr>
		    <tr>
		    	<td><b>External Url *: </b></td>
		    	<td><input type="text" name="url" value="<%= offer.getUrl() %>" placeholder="ebay.de/234Ad"></td>
		    </tr>	
		     
		     
		         <tr><td></td><td><input type="button" onclick="if(chkOfferFormular()) document.forms['fOffer'].submit();" value="Angebot speichern"></td></tr>
		
		</table><br>    
		    
		    <span class="error">${error}</span>
		
		</form>
<br>
<div id="errorMsg"></div>
<br>

<a href="/flogit_web/OfferDetails?param=<%= offer.getId() %>">Zurück zur Detail Seite</a>

</div></div>

</body>
</html>