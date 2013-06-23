<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artikel List</title>
</head>
<body>

<div id='navi'>
	<div id='content' style='margin:auto; width:600px'>
	<span style='float:left; padding-right:5%'><h2><a href='/flogit_web/ArticleList'>Artikel Liste</a></h2></span>
    <span style='float:left;padding-right:5%'><h2><a href='/flogit_web/OfferList'>Angebots Liste</a></h2></span>
    <span style='float:left;padding-right:5%'><h2><a href='/flogit_web/ContactList'>Kontakt Liste</a></h2></span>
    </div></div>
		
		<div style='float:left; padding:5% 20%''>
<div id='content' style='margin:auto; width:800px'>
<h1>Artikel Liste</h1>
<br><br><br>
<table width='600' border=1>
	<tr>
		<th scope='col'><b>ID</b></th>
		<th scope='col'><b>Name</b></th>
		<th scope='col'><b>Type</b></th>
		<th scope='col'><b>Details</b></th>
	</tr>
  <c:forEach items="${artList}" var="art" varStatus="loop">
    <tr>
      <td><c:out value="${art.getId()}" /></td>
      <td><c:out value="${art.getName()}" /></td>
      <td><c:out value="${art.getType()}" /></td>
      <td><a href='/flogit_web/ArticleDetails?param=${art.getId()}'>Show Details
        </a></td>
    </tr>
  </c:forEach>
</table>

</div>
<a href='/flogit_web/NewArticle'>Erstelle Artikel</a></div></div>
</body>
</html>