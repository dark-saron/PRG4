<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="Javascript/check.js" ></script>
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artikel Bearbeiten</title>
</head>
<body>
<jsp:include page="/include/navigation.jsp"></jsp:include>

<jsp:useBean id="artL" class ="de.fhe.ai.prg4.controller.ArticelLogic" />
<jsp:useBean id="art" class ="de.fhe.ai.prg4.model.Article" />
<jsp:useBean id="result" class ="de.fhe.ai.prg4.model.Article" />

<%
  int id = Integer.parseInt(request.getParameter( "param" ));
  art = artL.getArticle(id);		
%>

<div style='float:left; padding:5% 20%''>
<div id='content' style='margin:auto; width:800px'>

<h1>Artikel bearbeiten:</h1>
<br><div id="Msg">* Pflicht Felder ausfüllen</div><br>

<form id="fArticle" name="fArticle" action="editArticle" method="post" >
<table>
    <tr><td style="diplay:hide;"><b>ID:</b>	</td>
    <td ><input style="display:none;" type="text" name="id" value="<%= art.getId() %>" ><%= art.getId() %></tr>
    <tr><td><b>Name *:</b>	</td>
    <td><input type="text" id="name" name="name" value="<%= art.getName() %>"></td></tr>
    <tr><td><b>Type *: </b></td>
    <td>
    	<select name="type" >
			<option selected="selected" value="<%= art.getType() %>"><%= art.getType() %></option>
			<option value="Buch">Buch</option>
			<option value="CD">CD</option>
			<option value="DVD">DVD</option>
			<option value="Spiel">Spiel</option>
		</select>
     </td>
     </tr>
    <tr>
    	<td><b>Beschreibung: </b></td>
    	<td><input type="text" value="<%= art.getDescription() %>" name="description"></td>
    </tr>
    <tr>
    	<td><b>EAN/ISBN: </b></td>
    	<td><input type="text" name="ean_isbn" value="<%= art.getEan_Isbn() %>"></td>
    </tr>
    <tr>
    	<td><b>Lager *: </b></td><td>
    	<input type="text" name="place" value="<%= art.getPlace() %>"></td></tr>
	<tr>
		<td><b>Photo:</b></td>
		<td><input type="text" name="photo" value="<%= art.getPhoto() %>"></td>
	</tr>

    <tr><td></td><td><input type="button" onclick="if(chkArticleFormular()) document.forms['fArticle'].submit;" value="Artikel speichern"></td></tr>


</table><br>    
    <a href="/flogit_web/ArticleDetails?param=<%= art.getId() %>">Zurück</a>
    
    <span class="error">${error}</span>

</form>
<div id="errorMsg"></div>

</div></div>
</body>
</html>