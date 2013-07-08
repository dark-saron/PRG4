<%@page import="de.fhe.ai.prg4.controller.ArticelListLogic"%>
<%@page import="de.fhe.ai.prg4.view.ArticleList"%>
<%@page import="java.util.LinkedList"%>
<%@page import="de.fhe.ai.prg4.model.Article"%>
<%@page import="de.fhe.ai.prg4.controller.ArticelLogic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<title>Neues Angebot</title>
</head>
<body>

<%
int id;
ArticelLogic artL = new ArticelLogic();
ArticelListLogic artListL = new ArticelListLogic();
Article art1 = new Article();
LinkedList<Article> artList = new LinkedList<Article>();

	if(request.getParameter( "art" )==null)
	{
		id = -1;
		artList = artListL.getArticleList();
	}
	else
	{
		id = Integer.parseInt(request.getParameter( "art" ));
		art1 = artL.getArticle(id);
	}
%>

<jsp:include page="/include/navigation.jsp"></jsp:include>

<div style='float:left; padding:5% 20%'>

<div id='content' style='margin:auto; width:800px'>
<h1>Neues Angebot anlegen:</h1>
<br><br><br>
<form id="fOffer" name="fOffer" action="psNO" method="post">
<c:set var="aID" scope="session" value="<%= id %>"/>

<table>
    <tr>
    	<td><b>Artikel:</b>	</td>
		<c:choose>
		<c:when test="${aID  == -1}">
			<td>
    			<select name="article_Id" >
    		  		<c:forEach items="<%= artList %>" var="art" varStatus="loop">
      					<option value="${art.getId()}">
      						<c:out value="${art.getName()}" />
      					</option>
        			</c:forEach>
        		</select>
        	</td>
        </c:when>
        <c:otherwise>
        	<td>
				<input type="text" name="article_Id" style="display:none" value="<%= art1.getId() %>">
				<div><%= art1.getName() %></div>
			</td>
        </c:otherwise>
    	</c:choose>
    </tr>
    <tr>
    	<td><b>Start Preis:</b>	</td>
    	<td><input type="text" name="startsaleprice" placeholder="0.00"></td>
    </tr>
    <tr>
    	<td><b>Buy Now Preis:</b>	</td>
    	<td><input type="text" name="buynowprice" placeholder="0.00"></td>
    </tr>
    <tr>
    	<td><b>Start Datum: </b></td>
    	<td><input type="text" name="start" class="datepicker" placeholder="2013-01-01"></td>
    </tr>
    <tr>
    	<td><b>End Datum: </b></td>
    	<td><input type="text" name="end" class="datepicker" placeholder="2013-01-01"></td>
    </tr>
    <tr>
    	<td><b>Auctions Hause: </b></td>
    	<td><input type="text" name="auctionhouse" placeholder="ebay"></td>
    </tr>
    <tr>
    	<td><b>External Url: </b></td>
    	<td><input type="text" name="url" placeholder="ebay.de/234Ad"></td>
    </tr>	
    <tr>
    	<td></td>
    	<td><input type="button" onclick="if(chkOfferFormular()) document.forms.submit();" value="Angebot erstellen"></td>
    </tr>
	

</table><br>    
    <span class="error">${error}</span>
	<a href="/flogit_web/OfferList">Zurück zur Angebots Liste</a>
</form>
<div id="errorMsg"></div>
</div></div>

</body>
</html>