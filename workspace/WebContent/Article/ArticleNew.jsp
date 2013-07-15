<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="Javascript/check.js" ></script>
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Neuer Artikel</title>
</head>
<body>
<jsp:include page="/include/navigation.jsp"></jsp:include>
<jsp:useBean id="artL" class ="de.fhe.ai.prg4.controller.ArticelLogic" />

<div style='float:left; padding:5% 20%''>
<div id='content' style='margin:auto; width:800px'>
		
<h1>Neuen Artikeln anlegen:</h1>
<br><br>
<div>* Pflichtfeld </div>
<br>
<form id="fArticle" name="fArticle" action="psNA" method="post" onsubmit="">
<table>
    <tr>
    	<td><b>Name *:</b>	</td>
    	<td><input type="text" name="name" placeholder="PHP 5.4 für Dummies"></td>
    </tr>
    <tr>
    	<td><b>Type *: </b></td><td>
	    	<select name="type">
				<option selected="selected" value="Buch">Buch</option>
				<option value="CD">CD</option>
				<option value="DVD">DVD</option>
				<option value="Spiel">Spiel</option>
			</select>
    	</td>
    </tr>
    <tr>
    	<td><b>Beschreibung: </b></td>
    	<td><input type="text" name="description" placeholder="Beschreibung"></td>
    </tr>
    <tr>
    	<td><b>EAN/ISBN: </b></td>
    	<td><input type="text" name="ean_isbn" placeholder="ISBN 12321-12"></td>
    </tr>
    <tr>
    	<td><b>Lager *: </b></td>
    	<td><input type="text" name="place" placeholder="Zimmer"></td>
    </tr>
    <tr>
		<td><b>Photo:</b></td>
		<td><input type="text" name="photo" placeholder="url"></td>
	</tr>


    <tr><td></td><td><input type="button" value="Artikel erstellen" onclick="if(chkArticleFormular()) document.forms.submit();"></td></tr>


</table><br>    
<a href="/flogit_web/ArticleList">Zurück</a>
    
    <span class="error">${error}</span>

</form>
<div id="errorMsg"></div>

</div></div>
</body>
</html>