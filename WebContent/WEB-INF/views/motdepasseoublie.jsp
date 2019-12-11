<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = en>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Tileee</title>
	<script type="text/javascript" src="index.js"></script>
	<style><%@include file="css/index.css" %></style>
</head>
<body style=";">
	<section id="title">
		<nav id="menu">
			<ul>
				<li><a class="fa fa-user" href="Identification"></a></li>
				<li onmouseover="document.getElementById('overall').style.filter='blur(3px)'" onmouseout="document.getElementById('overall').style.filter='none'"><a class="fa fa-power-off" href="#"></a></li>
			</ul>
		</nav>
	</section>

	<div id="overall">
		<article id="textbox">
				<p>Indiquer votre adresse e-mail:<br /></p>
		<input type="text" name="email" placeholder="Entrer votre adresse e-mail">
		</article>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>