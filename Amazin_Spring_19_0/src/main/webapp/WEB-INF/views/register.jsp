<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
			<li><a href="#"><spring:message code="start"/></a></li>
			<li><a href="http://miw.uniovi.es"><spring:message code="about"/></a></li>
			<li><a href="mailto:dd@email.com"><spring:message code="contact"/></a></li>
		</ul>
	</nav>
	<section>
		<article>
			<label class="mytitle"><spring:message code="register.title"/>:</label><br />
			
			<form:form modelAttribute="userData">
				<form:errors path="" />
				<br />
				<spring:message code="register.username"/>: <form:input path="username" />
				<form:errors path="username" />
				<br />
				<spring:message code="register.password"/>: <form:password path="password" />
				<form:errors path="password" />
				<br />
				<spring:message code="register.repassword"/>: <form:password path="repassword" />
				<form:errors path="repassword" />
				<br />
				<spring:message code="register.email"/>: <form:input path="email" />
				<form:errors path="email" />
				<br />
				<input type="submit" />
			</form:form>
			<p style="color: red;">
				<c:out value="${message}" />
			</p>
		</article>
	</section>
	<footer>
		<strong><spring:message code="footer1"/></strong><br />
		<em><spring:message code="footer2"/></em>
	</footer>
</body>