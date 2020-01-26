<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html >
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
			<li><a href="shoppingCart"><spring:message code="shopping.buy"/></a></li>
			<li><a href="showShoppingCart"><spring:message code="shopping.myCart"/></a>
			<li><a href="http://miw.uniovi.es"><spring:message code="about"/></a></li>
			<li><a href="mailto:dd@email.com"><spring:message code="contact"/></a></li>
		</ul>
	</nav>
	<section>
		<article id="a01">
			<label class="mytitle"><spring:message code="options.choose"/>:</label><br /> 
			<a href="showBooks"><spring:message code="options.catalog"/></a><br /> 
			<a href="showSpecialOffer"><spring:message code="options.offers"/></a><br />  
			<a href="/Amazin/logout"><spring:message code="logout"/></a><br />  
			<spring:message code="visits"/>: <c:out value="${loginCounter.logins}"/>
		</article>
	</section>
	<footer>
		<strong><spring:message code="footer1"/></strong><br />
		<em><spring:message code="footer2"/></em>
	</footer>
</body>
