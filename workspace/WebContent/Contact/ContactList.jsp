<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kontakt List</title>
</head>
<body>
<jsp:include page="/include/navigation.jsp"></jsp:include>
		
<div style='float:left; padding:5% 20%''>
<div id='content' style='margin:auto; width:800px'>
<h1>Kontakt Liste</h1>
<br><br><br>
<table width='600' border=1>
	<tr>
		<th scope='col'><b>ID</b></th>
		<th scope='col'><b>Name</b></th>
		<th scope='col'><b>Details</b></th>		
	</tr>
  <c:forEach items="${contactList}" var="contact" varStatus="loop">
    <tr>
      <td><c:out value="${contact.getId()}" /></td>
      <td><c:out value="${contact.getFirst_Name()} ${contact.getLast_Name()}" /></td>
      <td><a href='/flogit_web/ContactDetails?param=${contact.getId()}'>Show Details
        </a></td>
    </tr>
  </c:forEach>
</table>

</div>
<a href='/flogit_web/NewContact'>Erstelle Kontakt</a></div></div>
</body>
</html>