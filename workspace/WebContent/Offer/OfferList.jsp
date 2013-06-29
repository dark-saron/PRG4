<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Angebots Liste</title>
</head>
<body>



<jsp:include page="/include/navigation.jsp"></jsp:include>
		
<div style="float:left; padding:5% 20%">
<div id='content' style='margin:auto; width:800px'>
		
<h1>Angebots Liste</h1>
<br><br><br>
<table width='600' border=1>
	<tr>
		<th scope='col'><b>Angebots ID</b></th>
		<th scope='col'><b>Artikel Name</b></th>
		<th scope='col'><b>Status</b></th>
		<th scope='col'><b>Details</b></th>
	</tr>
  <c:forEach items="${offerList}" var="offer" varStatus="loop">
    <tr>
      <td><c:out value="${offer.getId()}" /></td>
      <td><c:out value="${offer.getArticle_Name()}" /></td>
      <td>
      <c:choose>
      	<c:when test="${offer.getStatus() == 1 }">Offen</c:when>
      	<c:when test="${offer.getStatus() == 2 }">Gekauft</c:when>
      	<c:otherwise>Abglaufen</c:otherwise>
	</c:choose>
      </td>
      <td><a href='/flogit_web/OfferDetails?param=${offer.getId()}'>Show Details</a></td>
    </tr>
  </c:forEach>
</table>


<a href='/flogit_web/NewOffer'>Erstelle Angebot</a></div></div>
</body>
</html>