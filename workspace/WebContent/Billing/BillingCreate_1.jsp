<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.LinkedList"%>
<%@page import="de.fhe.ai.prg4.controller.ContactListLogic"%>
<%@page import="java.util.LinkedList"%>
<%@page import="de.fhe.ai.prg4.model.Contact"%>
<%@page import="de.fhe.ai.prg4.controller.ContactLogic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rechnung erstellen</title>
</head>
<body>
<jsp:include page="/include/navigation.jsp"></jsp:include>

<jsp:useBean id="contact" class ="de.fhe.ai.prg4.model.Contact" />
<jsp:useBean id="offer" class ="de.fhe.ai.prg4.model.Offer" />
<jsp:useBean id="offerL" class = "de.fhe.ai.prg4.controller.OfferLogic" />

<%
	int id = Integer.parseInt(request.getParameter("param"));
	ContactListLogic contactListLogic = new ContactListLogic();
	ContactLogic contactL = new ContactLogic();
	LinkedList<Contact> contactList = new LinkedList<Contact>();
	contactList = contactListLogic.getContactList();
	offer = offerL.getOffer(id);
%>

<div style='float:left; padding:5% 20%'>
<div id='content' style='margin:auto; width:800px'>

<h1>Rechnung erstellen 1:</h1>
<br><br><br>

<form name="fBill" id="fBill" action="Billing" method="post">
<input type="checkbox" name="newSellerAddress" value="newSellerAddress" onchange="onChanged('seller'); onChanged('absender');"> Neue Absender Addresse<br>
<input type="checkbox" name="newBuyerAddress" value="newBuyerAddress" onchange="onChanged('buyer'); onChanged('empfaenger');"> Neue Empfänger Addresse<br>

<table name="seller" id="seller" style="display: none;">
	<tr><td><b>Absender Form</b></td></tr>
	<tr>
		<td><b>Anrede:</b></td>
		<td>
			<input type="radio" name="aGender" value="m" checked>Herr<br>
			<input type="radio" name="aGender" value="f">Frau
		</td>
	</tr>
    <tr>
    	<td><b>Vorname:</b>	</td>
    	<td><input type="text" name="aFirst_Name*" ></td>
    </tr>
    <tr>
    	<td><b>Nachname:</b>	</td>
    	<td><input type="text" name="aLast_Name*" ></td>
    </tr>
    <tr>
    	<td><b>Straße und Nr.: </b></td>
    	<td><input type="text" name="aStreet_Nr*" ></td>
    </tr>
    <tr>
    	<td><b>PLZ: </b></td>
    	<td><input type="text" name="aZip*" ></td>
    </tr>
    <tr>
    	<td><b>Stadt: </b></td>
    	<td><input type="text" name="aCity*" ></td>
    </tr>
    <tr>
    	<td><b>Land: </b></td>
    	<td><input type="text" name="aCountry*" ></td></tr>
	
</table><br>    

<table name="buyer" id="buyer" style="display: none;">
	<tr><td><b>Empfänger Form</b></td></tr>
	<tr>
		<td><b>Anrede:</b></td>
		<td>
			<input type="radio" name="aGender" value="m" checked>Herr<br>
			<input type="radio" name="aGender" value="f">Frau
		</td>
	</tr>
    <tr>
    	<td><b>Vorname:</b>	</td>
    	<td><input type="text" name="aFirst_Name*" ></td>
    </tr>
    <tr>
    	<td><b>Nachname:</b>	</td>
    	<td><input type="text" name="aLast_Name*" ></td>
    </tr>
    <tr>
    	<td><b>Straße und Nr.: </b></td>
    	<td><input type="text" name="aStreet_Nr*" ></td>
    </tr>
    <tr>
    	<td><b>PLZ: </b></td>
    	<td><input type="text" name="aZip*" ></td>
    </tr>
    <tr>
    	<td><b>Stadt: </b></td>
    	<td><input type="text" name="aCity*" ></td>
    </tr>
    <tr>
    	<td><b>Land: </b></td>
    	<td><input type="text" name="aCountry*" ></td></tr>
	
</table><br>    


<table>

    <tr id="absender" name="absender" style="display: default;">
    	<td><b>Absender: </b></td>
      	<td>
	      	<select name="buyer_id">
				<c:forEach items="<%= contactList %>" var="contact1" varStatus="loop">
	      			<option value="${contact1.getId()}" >
	      				<c:out value="${contact1.getFirst_Name()} ${contact1.getLast_Name()}" />
	      			</option>
	      	  </c:forEach>
	  		</select>
	      	
      	</td>
    </tr>
    <tr id="empfaenger" name="empfaenger" style="display: default;">
    
	    <td ><b>Empfänger: </b></td>
    	<td>
	      	<select name="seller_id">
				<c:forEach items="<%= contactList %>" var="contact2" varStatus="loop">
	      			<option value="${contact2.getId()}" >
	      				<c:out value="${contact2.getFirst_Name()} ${contact2.getLast_Name()}" />
	      			</option>
	      	  </c:forEach>
	  		</select>
      	</td>
    </tr>
    <tr>
    	<td><b>Kaufdatum:</b>	</td>
    	<td><input style="display: none;" type="text" name="brought_At" value="<%=offer.getEnd()%>"></td></tr>
    <tr>
    	<td><b>Lieferdatum:</b>	</td>
    	<td><input type="text" name="shipping_At" value="<%=offer.getEnd()%>"></td></tr>
    <tr>
    	<td><b>Verkaufspreis*:</b>	</td>
    	<td><input type="text" name="total" value="<%=offer.getBuynowprice()%>"></td></tr>
    <tr>
    	<td><b>Versandkosten: </b></td>
    	<td><input type="text" name="shippingCost" placeholder="0.00"></td></tr>
    <tr>
    	<td><b>Artikel Auktion: </b></td>
    	<td ><input disabled="disabled" type="text" value="<%=offer.getArticle_Name()%>"></td>
    	<td style="display: none;"><input type="text" name="offerID" value="<%=offer.getArticle_Id()%>"></td>
    </tr>
	 <tr>
    	<td></td>
    	<td><input type="button"  value="Rechnungs Details" onclick="submit();"></td>
    </tr>
	
	<br />
</table>
<br>    
<hr>
    <a href="/flogit_web/ContactDetails?param=<%=contact.getId()%>">Zurück</a>
    
    <span class="error">${error}</span>

</form>
<div id="errorMsg"></div>
</div></div>

</body>
</html>