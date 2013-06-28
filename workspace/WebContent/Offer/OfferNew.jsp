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

<div id='navi'>
	<div id='content' style='margin:auto; width:600px'>
	<span style='float:left; padding-right:5%'><h2><a href='/flogit_web/ArticleList'>Artikel Liste</a></h2></span>
    <span style='float:left;padding-right:5%'><h2><a href='/flogit_web/OfferList'>Angebots Liste</a></h2></span>
    <span style='float:left;padding-right:5%'><h2><a href='/flogit_web/ContactList'>Kontakt Liste</a></h2></span>
    </div>
</div>
<div style='float:left; padding:5% 20%'>

<div id='content' style='margin:auto; width:800px'>
<h1>Neues Angebot anlegen:</h1>
<br><br><br>
<form action="psNO" method="post">
<c:set var="aID" scope="session" value="<%= id %>"/>

<table>
    <tr>
    	<td><b>Artikel:</b>	</td>
		<c:choose>
		<c:when test="${aID  == -1}">
		
    	<td>
    	<select name="article" >
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
			<input type="text" name="article_Name" style="display:none" value="<%= art1.getName() %>">
			<div><%= art1.getName() %></div>
		</td>
        
        </c:otherwise>
	    	
    	
    	</c:choose>
    </tr>
    <tr><td><b>Start Preis:</b>	</td><td><input type="text" name="startsaleprice"></td></tr>
    <tr><td><b>End Preis:</b>	</td><td><input type="text" name="buynowprice"></td></tr>
    <tr><td><b>Start Datum: </b></td><td><input type="text" name="start" class="datepicker"></td></tr>
    <tr><td><b>End Datum: </b></td><td><input type="text" name="end" class="datepicker"></td></tr>
    <tr><td><b>Auctions Hause: </b></td><td><input type="text" name="auctionhouse"></td></tr>
    <tr><td><b>External Url: </b></td><td><input type="text" name="url"></td></tr>	
    <tr><td></td><td><input type="submit" value="Angebot erstellen"></td></tr>
	

</table><br>    
    <span class="error">${error}</span>

</form>
</div></div>
</body>
</html>