<%@page import="de.fhe.ai.prg4.view.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="CSS/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artikel Details</title>
</head>
<body>
<jsp:include page="/include/navigation.jsp"></jsp:include>
		
		<div style='float:left; padding:5% 20%'>
<div id='content' style='margin:auto; width:800px'>
<h1>Artikel Details</h1>
<br><br><br>

<jsp:useBean id="artL" class ="de.fhe.ai.prg4.controller.ArticelLogic" />
<jsp:useBean id="art" class ="de.fhe.ai.prg4.model.Article" />

<%
  int id = Integer.parseInt(request.getParameter( "param" ));
  art = artL.getArticle(id);		
%>

<table id="details" width='500' border='1'>
			<tr>
			<td ><b>ID:</b></td>
			<td >	<%= art.getId() %></td>
			</tr>
			<tr>
			<td><b>Name:</b></td>
			<td>	<%= art.getName() %></td>
			</tr>
			<tr>
			<td><b>	Type:</b></td>
			<td>	<%= art.getType() %></td>
			</tr>
						<tr>
			<td><b>EAN / ISBN:</b></td>
			<td>	<%= art.getEan_Isbn() %></td>
			</tr>
			<tr>
			<td><b>Lager:</b></td>
			<td>	<%= art.getPlace() %></td>
			</tr>
			<tr>
			<td><b>Photo:</b></td>
			<td>	<%= art.getPhoto() %></td>
			</tr>
			<tr>
			<td><b>Beschreibung:</b></td>
			<td>	<%= art.getDescription() %></td>
			</tr>
			
		
		</table>
		<div style='float:left; padding:5% 0%'>
			<a href="ArticleEdit?param=<%=art.getId() %>">Bearbeiten</a>
			<a href="DeleteArticle?param=<%=art.getId() %>">Löschen</a>
			<a href='/flogit_web/NewOffer?art=<%=art.getId() %>'>Angebot erstellen</a>
		</div></div></div>
		
</body>
</html>