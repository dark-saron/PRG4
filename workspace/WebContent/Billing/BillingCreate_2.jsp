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
<jsp:useBean id="offerL" class = "de.fhe.ai.prg4.controller.OfferLogic" />
<jsp:useBean id="billL" class = "de.fhe.ai.prg4.controller.BillLogic" />


<div style='float:left; padding:5% 20%'>
<div id='content' style='margin:auto; width:800px'>		

<div class=WordSection1>

<table class=MsoNormalTable border=0 cellpadding=0 width="100%"
 style='width:100.0%;mso-cellspacing:1.5pt;mso-yfti-tbllook:1184'>
  <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
  <td style='padding:.75pt .75pt .75pt .75pt'>
  <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
   style='width:100.0%;mso-cellspacing:0cm;mso-yfti-tbllook:1184;mso-padding-alt:
   0cm 0cm 0cm 0cm'>
   <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
    <td width="235" valign=top style='padding:0cm 0cm 0cm 0cm'>
    <p class=MsoNormal><span style='font-size:7.5pt;font-family:"Verdana","sans-serif"'>
	<c:set var="seller_address" scope="session" value="${contactL.getAddress(billDetails.getSeller_Id()) }"></c:set>   
	${seller_address.getFirst_Name() } ${seller_address.getLast_Name() }<br>   
	${seller_address.getStreet_Nr() }<br>
    ${seller_address.getZip() } ${seller_address.getCity() }<br>
    ${seller_address.getCountry() }<br>
    <p>&nbsp;</p>
    </td>
    <td width="132" valign=top style='padding:0cm 0cm 0cm 0cm'><p><span style="font-size:7.5pt;font-family:&quot;Verdana&quot;,&quot;sans-serif&quot;">
	<c:set var="buyer_address" scope="session" value="${contactL.getAddress(billDetails.getContact_Id()) }"></c:set>   
    ${buyer_address.getFirst_Name() } ${seller_address.getLast_Name() }<br>   
	${buyer_address.getStreet_Nr() }<br>
    ${buyer_address.getZip() } ${seller_address.getCity() }<br>
    ${buyer_address.getCountry() }<br>

      </span></p></td>
    <td width=109 valign=top style='width:.75pt;padding:0cm 0cm 0cm 0cm'>
    <p class=MsoNormal>&nbsp;</p>
    </td>
   </tr>
  </table>
  <p class=MsoNormal><o:p>&nbsp;</o:p></p>
  <table class=MsoNormalTable border=1 cellpadding=0 width="100%"
   style='width:100.0%;mso-cellspacing:1.5pt;border-top:solid windowtext 1.0pt;
   border-left:none;border-bottom:solid windowtext 1.0pt;border-right:none;
   mso-border-top-alt:solid windowtext .75pt;mso-border-bottom-alt:solid windowtext .75pt;
   mso-yfti-tbllook:1184'>
   <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
    <td width="50%" style='width:50.0%;border:none;background:#F1F1F1;
    padding:.75pt .75pt .75pt .75pt'>&nbsp;</td>
    <td width="50%" style='width:50.0%;border:none;background:#F1F1F1;
    padding:.75pt .75pt .75pt .75pt'>&nbsp;</td>
    </tr>
   <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
    <td style='border:none;padding:.75pt .75pt .75pt .75pt'><p>Lieferschein</p></td>
    <td style='border:none;padding:.75pt .75pt .75pt .75pt'>
    	<p>
    		<span style='font-size:7.5pt;font-family:"Verdana","sans-serif"'>
    			<strong>
    				<span style='font-family:"Verdana","sans-serif"'>Bestelldatum:</span>
    			</strong> ${billDetails.getBought_At() }<br>
      		<strong>
      			<span style='font-family:"Verdana","sans-serif"'>Lieferdatum:</span>
      		</strong> ${billDetails.getShipped_At() }<br>
      </span></p></td>
    </tr>
  </table>
 </td>
 </tr>
</table>

<p class=MsoNormal><span style='font-size:10.0pt;font-family:"Calibri","sans-serif";
mso-ascii-theme-font:minor-latin;mso-hansi-theme-font:minor-latin;mso-bidi-font-family:
"Times New Roman";mso-bidi-theme-font:minor-bidi;display:none;mso-hide:all'><o:p>&nbsp;</o:p></span></p>

<table class=MsoNormalTable border=1 cellspacing=0 cellpadding=0 width="100%"
 style='width:100.0%;mso-cellspacing:0cm;border:none;border-bottom:solid windowtext 1.0pt;
 mso-border-bottom-alt:solid windowtext .75pt;mso-yfti-tbllook:1184;mso-padding-alt:
 0cm 0cm 0cm 0cm'>
 <tr style='mso-yfti-irow:1;mso-yfti-lastrow:yes'>
  <td style='border:none;padding:0cm 0cm 0cm 0cm'>
  <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
   style='width:100.0%;mso-cellspacing:0cm;background:#F1F1F1;mso-yfti-tbllook:
   1184;mso-padding-alt:2.25pt 2.25pt 2.25pt 2.25pt'>
   <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
    <td width="10%" style='width:10.0%;border-top:none;border-left:none;
    border-bottom:solid white 1.5pt;border-right:solid white 1.5pt;padding:
    2.25pt 2.25pt 2.25pt 2.25pt'>
    <p class=MsoNormal align=center style='text-align:center'><strong><span
    style='font-size: 7.5pt; font-family: &quot;Arial&quot;, &quot;sans-serif&quot;'>Artikelnummer </span></strong></p>
    </td>
    <td width="50%" style='width:50.0%;border-top:none;border-left:none;
    border-bottom:solid white 1.5pt;border-right:solid white 1.5pt;padding:
    2.25pt 2.25pt 2.25pt 2.25pt'>
    <p class=MsoNormal><strong><span style='font-size: 7.5pt; font-family: &quot;Arial&quot;, &quot;sans-serif&quot;'>Artikelbezeichnung
    </span></strong></p>
    </td>
    <td width="15%" style='width:15.0%;border-top:none;border-left:none;
    border-bottom:solid white 1.5pt;border-right:solid white 1.5pt;padding:
    2.25pt 2.25pt 2.25pt 2.25pt'>
      <p class=MsoNormal><strong><span style='font-size: 7.5pt; font-family: &quot;Arial&quot;, &quot;sans-serif&quot;'>Menge </span></strong></p>
    </td>
    <td width="13%" style='width:13.0%;border-top:none;border-left:none;
    border-bottom:solid white 1.5pt;border-right:solid white 1.5pt;padding:
    2.25pt 2.25pt 2.25pt 2.25pt'>
      <p class=MsoNormal align=right style='text-align:right'><strong><span
    style='font-size:7.5pt;font-family:"Arial","sans-serif"'>Gesamtpreis</span></strong><span
    style='font-size:7.5pt;font-family:"Arial","sans-serif"'> </span></p>
    </td>
   </tr>
  </table>
  <p class=MsoNormal><span style='display:none;mso-hide:all'><o:p>&nbsp;</o:p></span></p>
  <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width="100%"
   style='width:100.0%;mso-cellspacing:0cm;background:#F1F1F1;mso-yfti-tbllook:
   1184;mso-padding-alt:2.25pt 2.25pt 2.25pt 2.25pt'>
   <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;mso-yfti-lastrow:yes'>
    <td style='width:10.0%;border-top:none;border-left:none;
    border-bottom:solid white 1.5pt;border-right:solid white 1.5pt;padding:
    2.25pt 2.25pt 2.25pt 2.25pt'>
    <p class=MsoNormal align=center style='text-align:center'><span
    style='font-size:7.5pt;font-family:"Arial","sans-serif"'>1</span></p>
    </td>
    <td width="5%" style='width:5.0%;border-top:none;border-left:none;
    border-bottom:solid white 1.5pt;border-right:solid white 1.5pt;padding:
    2.25pt 2.25pt 2.25pt 2.25pt'>
    <p class=MsoNormal align=center style='text-align:center'><span
    style='font-size:7.5pt;font-family:"Arial","sans-serif"'>x</span></p>
    </td>
    <td width="50%" style='width:50.0%;border-top:none;border-left:none;
    border-bottom:solid white 1.5pt;border-right:solid white 1.5pt;padding:
    2.25pt 2.25pt 2.25pt 2.25pt'>
    <p class=MsoNormal><strong><span style='font-size:7.5pt;font-family:"Arial","sans-serif"'>${offerL.getOffer(billDetails.getOffer_Id()).getArticle_Name() }</span></strong></p>
    </td>
    <td width="15%" style='width:15.0%;border-top:none;border-left:none;
    border-bottom:solid white 1.5pt;border-right:solid white 1.5pt;padding:
    2.25pt 2.25pt 2.25pt 2.25pt'>
      <p class=MsoNormal><span style='font-size:7.5pt;font-family:"Arial","sans-serif"'>Placeholder für External ID </span></p>
    </td>
    <td width="13%" style='width:13.0%;border-top:none;border-left:none;
    border-bottom:solid white 1.5pt;border-right:solid white 1.5pt;padding:
    2.25pt 2.25pt 2.25pt 2.25pt'>
      <p class=MsoNormal align=right style='text-align:right'><span
    style='font-size:7.5pt;font-family:"Arial","sans-serif"'>${billDetails.getTotal() } EUR</span></p>
    </td>
   </tr>
  </table>
  <p class=MsoNormal><span style='display:none;mso-hide:all'><o:p>&nbsp;</o:p></span></p></td>
 </tr>
</table>

<p class=MsoNormal align=right style='text-align:right'><span style='font-size:
7.5pt;font-family:"Arial","sans-serif"'>Zwischensumme: ${billDetails.getTotal() } EUR</span><span
style='font-size:10.0pt;font-family:"Calibri","sans-serif";mso-ascii-theme-font:
minor-latin;mso-hansi-theme-font:minor-latin;mso-bidi-font-family:"Times New Roman";
mso-bidi-theme-font:minor-bidi'><o:p></o:p></span></p>

<p class=MsoNormal align=right style='text-align:right'><span style='font-size:
7.5pt;font-family:"Arial","sans-serif"'>Versandkosten: ${billDetails.getShipping_Cost() } EUR</span><span style='font-size:10.0pt;font-family:"Calibri","sans-serif";
mso-ascii-theme-font:minor-latin;mso-hansi-theme-font:minor-latin;mso-bidi-font-family:
"Times New Roman";mso-bidi-theme-font:minor-bidi'>
  <o:p></o:p></span><span
style='font-size:10.0pt;font-family:"Calibri","sans-serif";mso-ascii-theme-font:
minor-latin;mso-hansi-theme-font:minor-latin;mso-bidi-font-family:"Times New Roman";
mso-bidi-theme-font:minor-bidi'>
  <o:p></o:p>
  </span></p>

<p class=MsoNormal align=right style='text-align:right'><b><span
style='font-size:7.5pt;font-family:"Arial","sans-serif"'>Summe</span></b><span
style='font-size:7.5pt;font-family:"Arial","sans-serif"'>:<b>  

${billL.CalculateSum(billDetails.getTotal() , billDetails.getShipping_Cost())} EUR</b></span></p><p class=MsoNormal align=right style='text-align:right'><span
style='font-size:10.0pt;font-family:"Calibri","sans-serif";mso-ascii-theme-font:
minor-latin;mso-hansi-theme-font:minor-latin;mso-bidi-font-family:"Times New Roman";
mso-bidi-theme-font:minor-bidi'><o:p></o:p></span></p>
<p><span style="font-size:7.5pt;font-family:
  &quot;Verdana&quot;,&quot;sans-serif&quot;">Vielen Dank f&uuml;r Ihre Bestellung!</span></p>

</div>
</div></div>
</body>

</html>
