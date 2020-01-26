<!DOCTYPE html >
<%@ page contentType="text/html; charset=iso-8859-1"
	pageEncoding="iso-8859-1" language="java"
	import="java.util.*, com.miw.model.Book,com.miw.presentation.book.*"
	errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page isELIgnored="false"%>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<head>
<title>Amazin</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<header>
		<h1 class="header">Amazin.com</h1>
		<h2 class="centered">
			<spring:message code="welcome"/>
		</h2>
	</header>
	<nav>
		<ul>
			<li><a href="/Amazin"><spring:message code="start"/></a></li>
			<li><a href="newBook"><spring:message code="newBook.add"/></a></li>
			<li><a href="shoppingCart"><spring:message code="shopping.buy"/></a></li>
			<li><a href="showShoppingCart"><spring:message code="shopping.myCart"/></a>
			<li><a href="http://miw.uniovi.es"><spring:message code="about"/></a></li>
			<li><a href="mailto:dd@email.com"><spring:message code="contact"/></a></li>
		</ul>
	</nav>
	<section>
		<article>
			<form name="addToShoppingCart" action="addToShoppingCart" method="post">
				<table>
					<caption><spring:message code="shopping.title"/>:</caption>
					<thead>
						<tr>
							<th><spring:message code="shopping.select"/></th>
							<th><spring:message code="book.title"/></th>
							<th><spring:message code="book.author"/></th>
							<th><spring:message code="book.description"/></th>
							<th><spring:message code="book.price"/></th>
						</tr>
					</thead>
	
					<tbody>
						<c:forEach var='book' items="${booklist}">
							<tr>
								<td><input type="checkbox" name="${book.id}"/></td>
								<td><c:out value="${book.title}" /></td>
								<td><c:out value="${book.author}" /></td>
								<td><c:out value="${book.description}" /></td>
								<td><c:out value="${book.price}" /> &euro;</td>
							</tr>						
						</c:forEach>
					</tbody>
				</table>
				
				<input type="submit" value="<spring:message code="shopping.add"/>"/>
			</form>
		</article>
	</section>
	<footer>
		<strong><spring:message code="footer1"/></strong><br />
		<em><spring:message code="footer2"/></em>
	</footer>
</body>