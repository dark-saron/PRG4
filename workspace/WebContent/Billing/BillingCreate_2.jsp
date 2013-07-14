<%@ page import="java.math.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<script type="text/javascript" src="Javascript/check.js" ></script>
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body link=blue vlink=purple style='tab-interval:35.4pt'>
<jsp:include page="/include/navigation.jsp"></jsp:include>


<jsp:useBean id="addresse" class ="de.fhe.ai.prg4.model.Address" />
<jsp:useBean id="contactL" class ="de.fhe.ai.prg4.controller.ContactLogic" />
<jsp:useBean id="offer" class ="de.fhe.ai.prg4.model.Offer" />
<jsp:useBean id="billing" class ="de.fhe.ai.prg4.model.Bill" />
<jsp:useBean id="offerL" class = "de.fhe.ai.prg4.controller.OfferLogic" />
<jsp:useBean id="billL" class = "de.fhe.ai.prg4.controller.BillLogic" />

<%
  int offerId = Integer.parseInt(request.getParameter( "param" ));
  billing = billL.getBill( billL.GetBillID(offerId));
  
%>

<c:set var="seller_address" scope="session" value="<%= contactL.getAddress(billing.getSeller_Id()) %>"></c:set>   
<c:set var="buyer_address" scope="session" value="<%= contactL.getAddress(billing.getContact_Id()) %>"></c:set>   
<c:set var="offerDetails" scope="session" value="<%= offerL.getOffer(billing.getOffer_Id()) %>"></c:set>

<div style='float:left; padding:5% 20%'>
<div id='content' style='margin:auto; width:800px'>	
<div class=WordSection1>

<table class=MsoNormalTable border=0 cellpadding=0 width="100%">
  <tr >
  <td >
  <table class=MsoNormalTable2 border=0 cellspacing=0 cellpadding=0 width="100%">
   <tr >
    <td>
    <p class=MsoNormal><span>
	
	${seller_address.getFirst_Name() } ${seller_address.getLast_Name() }<br>   
	${seller_address.getStreet_Nr() }<br>
    ${seller_address.getZip() } ${seller_address.getCity() }<br>
    ${seller_address.getCountry() }<br>
    <p>&nbsp;</p>
    </td>
    <td width="132" valign=top ><p class=MsoNormal><span>
	
    ${buyer_address.getFirst_Name() } ${buyer_address.getLast_Name() }<br>   
	${buyer_address.getStreet_Nr() }<br>
    ${buyer_address.getZip() } ${buyer_address.getCity() }<br>
    ${buyer_address.getCountry() }<br>

      </span></p></td>
    <td width=109 valign=top style='width:.75pt;padding:0cm 0cm 0cm 0cm'>
    <p class=MsoNormal>&nbsp;</p>
    </td>
   </tr>
  </table>
  <p class=MsoNormal><o:p>&nbsp;</o:p></p>
  <table class=MsoNormalTable3 border=1 cellpadding=0 width="100%">
   <tr >
    <td width="50%" >&nbsp;</td>
    <td width="50%" >&nbsp;</td>
    </tr>
   <tr id="row1">
    <td ><p>Lieferschein</p></td>
    <td >
    	<p>
    		<span >
    			<strong>
    				<span >Bestelldatum:</span>
    			</strong> <%=billing.getBought_At()  %><br>
      		<strong>
      			<span >Lieferdatum:</span>
      		</strong> <%= billing.getShipped_At() %><br>
      </span></p></td>
    </tr>
  </table>
 </td>
 </tr>
</table>

<p class=MsoNormal2><span ><o:p>&nbsp;</o:p></span></p>

<table class=MsoNormalTable4 border=1 cellspacing=0 cellpadding=0 width="100%">
 <tr class=firstALast>
  <td class="noBorder noPadding">
  <table class=MsoNormalTable5 border=0 cellspacing=0 cellpadding=0 width="100%">
   <tr>
    <td class="t4row1">
    <p class=MsoNormal align=center style='text-align:center'><strong><span>External ID </span></strong></p>
    </td>
    <td class="t4row2">
    <p class=MsoNormal><strong><span>Artikelbezeichnung</span></strong></p>
    </td>
    <td class="t4row3" >
      <p class=MsoNormal><strong><span>Menge </span></strong></p>
    </td>
    <td class="t4row4">
      <p class="aRight MsoNormal"><strong><span>Gesamtpreis</span></strong><span> </span></p>
    </td>
   </tr>
  </table>
  <p class=MsoNormal><span style='display:none;mso-hide:all'><o:p>&nbsp;</o:p></span></p>
  <table class=MsoNormalTable5 border=0 cellspacing=0 cellpadding=0 width="100%">
   <tr class=firstALast>
    <td class=t4row1>
    <p class="MsoNormal aCenter" ><span>${offerDetails.getExternalId() }</span></p>
    </td>
    <td class=t4row2>
 	   <p class=MsoNormal><strong><span>${offerDetails.getArticle_Name() }</span></strong></p>
    </td>
    <td class=t4row3>
      <p class=MsoNormal><span>1</span></p>
    </td>
    <td class="t4row4">
      <p class="MsoNormal aRight"><span><%= billing.getTotal()  %> EUR</span></p>
    </td>
   </tr>
  </table>
  <p class=MsoNormal><span style='display:none;mso-hide:all'><o:p>&nbsp;</o:p></span></p></td>
 </tr>
</table>

<p class="MsoNormal aRight" ><span>Zwischensumme: <%= billing.getTotal()  %> EUR</span><span class=font10><o:p></o:p></span></p>

<p class="MsoNormal aRight"><span>Versandkosten: <%= billing.getShipping_Cost() %> EUR</span><span class=font10>
  <o:p></o:p></span><span class=font10>
  <o:p></o:p>
  </span></p>

<p class="MsoNormal aRight" ><b><span>Summe</span></b><span>:<b>  

<%= billL.CalculateSum(billing.getTotal() , billing.getShipping_Cost()) %> EUR</b></span></p><p class="MsoNormal aRight"><span class=font10><o:p></o:p></span></p>
<p><span>Vielen Dank f&uuml;r Ihre Bestellung!</span></p>

</div>
</div></div>
</body>

</html>
