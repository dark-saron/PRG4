<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artikel Löschen</title>
</head>
<body>
<jsp:include page="/include/navigation.jsp"></jsp:include>

<div style='float:left; padding:5% 20%''>
<div id='content' style='margin:auto; width:800px'>


<jsp:useBean id="artL" class ="de.fhe.ai.prg4.controller.ArticelLogic" />
<jsp:useBean id="art" class ="de.fhe.ai.prg4.model.Article" />

<%
  int id = Integer.parseInt(request.getParameter( "param" ));
  art = artL.getArticle(id);		
%>
		
<h1>Artikeln Löschen:</h1>
<br><br><br>
<form action="ArticleDelete" method="post">
<table>
	<tr ><td><b>ID:</b>	</td>
    	<td><div><%= art.getId() %></div></td>
		<td style="display:none"><input type="text" name="id" value="<%= art.getId() %>" ></td>
	</tr>
    <tr style="display:hide">
    	<td><b>Name:</b>	</td>
    	<td><div><%= art.getName() %></div>
    	</td>
    </tr>
    <tr><td></td><td><input type="submit" value="Artikel Löschen"></td></tr>
</table>
</form>
<a href="/flogit_web/ArticleDetails?param=<%= art.getId() %>">Zurück</a>


</body>
</html>