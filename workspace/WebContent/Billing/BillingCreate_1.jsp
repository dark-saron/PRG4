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
<div>* Pflichtfeld </div>

<form name="fBill" id="fBill" action="Billing" method="post">
<input type="checkbox" name="newSellerAddress" value="newSellerAddress" onchange="onChanged('seller'); if(<%= contactListLogic.getContactCount() > 0 %>) onChanged('absender');"> Neue Absender Addresse<br>

<table id="seller" style="display: none;">
	<tr><td><b>Absender Form</b></td></tr>
	<tr>
		<td><b>Anrede *:</b></td>
		<td>
			<input type="radio" name="aGender" value="m" checked>Herr<br>
			<input type="radio" name="aGender" value="f">Frau
		</td>
	</tr>
    <tr>
    	<td><b>Vorname *:</b>	</td>
    	<td><input type="text" name="aFirst_Name" ></td>
    </tr>
    <tr>
    	<td><b>Nachname *:</b>	</td>
    	<td><input type="text" name="aLast_Name" ></td>
    </tr>
    <tr>
    	<td><b>Straße und Nr. *: </b></td>
    	<td><input type="text" name="aStreet_Nr" ></td>
    </tr>
    <tr>
    	<td><b>PLZ *: </b></td>
    	<td><input type="text" name="aZip" ></td>
    </tr>
    <tr>
    	<td><b>Stadt *: </b></td>
    	<td><input type="text" name="aCity" ></td>
    </tr>
    <tr>
    	<td><b>Land *: </b></td>
    	<td><input type="text" name="aCountry" ></td></tr>
	
</table><br>    

<input type="checkbox" name="newBuyerAddress" value="newBuyerAddress" onchange="onChanged('buyer'); if(<%= contactListLogic.getContactCount() > 0 %>) onChanged('empfaenger');"> Neue Empfänger Addresse<br>

<table id="buyer" style="display: none;">
	<tr><td><b>Empfänger Form</b></td></tr>
	<tr>
		<td><b>Anrede *:</b></td>
		<td>
			<input type="radio" name="bGender" value="m" checked>Herr<br>
			<input type="radio" name="bGender" value="f">Frau
		</td>
	</tr>
    <tr>
    	<td><b>Vorname *:</b>	</td>
    	<td><input type="text" name="bFirst_Name" ></td>
    </tr>
    <tr>
    	<td><b>Nachname *:</b>	</td>
    	<td><input type="text" name="bLast_Name" ></td>
    </tr>
    <tr>
    	<td><b>Straße und Nr. *: </b></td>
    	<td><input type="text" name="bStreet_Nr" ></td>
    </tr>
    <tr>
    	<td><b>PLZ *: </b></td>
    	<td><input type="text" name="bZip" ></td>
    </tr>
    <tr>
    	<td><b>Stadt *: </b></td>
    	<td><input type="text" name="bCity" ></td>
    </tr>
    <tr>
    	<td><b>Land *: </b></td>
    	<td><input type="text" name="bCountry" ></td></tr>
	
</table><br>    

<table>
<c:if test="<%= contactListLogic.getContactCount() > 0 %>">
    <tr id="absender" name="empfaenger style="display: default;">
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
</c:if>
<c:if test="<%= contactListLogic.getContactCount() > 0 %>">
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
</c:if>
    <tr>
    	<td><b>Kaufdatum *:</b>	</td>
    	<td><input type="text" name="brought_At" value="<%= offer.getEnd()%>"></td></tr>
    <tr>
    	<td><b>Lieferdatum:</b>	</td>
    	<td><input type="text" name="shipping_At" value="<%=offer.getEnd()%>"></td></tr>
    <tr>
    	<td><b>Verkaufspreis *:</b>	</td>
    	<td><input type="text" name="total" value="<%=offer.getBuynowprice()%>"></td></tr>
    <tr>
    	<td><b>Versandkosten *: </b></td>
    	<td><input type="text" name="shippingCost" placeholder="0.00"></td></tr>
    <tr>
    	<td><b>External ID: </b></td>
    	<td style="display: none;"><input type="text" name="externalID" value="<%=offer.getExternalId()%>"></td>
    	<td ><%=offer.getExternalId()%></td>
    </tr>
    <tr>
    	<td><b>Artikel Auktion: </b></td>
    	<td ><input disabled="disabled" type="text" value="<%=offer.getArticle_Name()%>"></td>
    </tr>
	 <tr>
    	<td></td>
    	<td style="display: none;"><input type="text" name="offerID" value="<%=offer.getId()%>"></td>
    	<td><input type="button"  value="Rechnungs Anlegen" onclick="if(chkBillFormular()) document.forms.submit();"></td>
    </tr>
	
	<br />
</table>
<br>    

    
    <span class="error">${error}</span>

</form>
<div id="errorMsg"></div>
<br>
<hr>
    <a href="/flogit_web/OfferDetails?param=<%=offer.getId()%>">Zurück</a>
</div></div>

</body>
</html>