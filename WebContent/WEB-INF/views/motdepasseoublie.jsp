<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = en>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome-animation/0.2.1/font-awesome-animation.css">
    <script src="https://kit.fontawesome.com/f64643ede5.js" crossorigin="anonymous"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Tileee</title>
	<script type="text/javascript"><%@include file="js/train.js" %></script>
	<script type="text/javascript"><%@include file="js/index.js" %></script>
	<style><%@include file="css/index.css" %></style>
</head>
<body style=";">
	<section id="title">
		<nav id="menu">
			<ul>
				<li id="quit" class="fa fa-reply" onclick="window.location.replace('Identification?action=2')"></li>
			</ul>
		</nav>
	</section>

	<div id="overall">
		<article id="textbox"><br/>
		<form action="MotDePasseOublie" method="post">
		<input class="form-control" type="text" name="email" placeholder="Entrer votre adresse e-mail"><br/>
		<input type="submit">
		</form>
		<c:if test="${userMessage ne null}"><p>${userMessage}</p></c:if>
		</article>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>