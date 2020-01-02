<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = en>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Tileee</title>
	<script src="https://kit.fontawesome.com/f64643ede5.js" crossorigin="anonymous"></script>
	<script type="text/javascript"><%@include file="js/index.js" %></script>
	<style><%@include file="css/index.css" %></style>
</head>
<body style=";">
	<section id="title">
		<nav id="menu">
			<ul>
				<li><a class="fa fa-user-plus" href="Identification?action=2"></a></li>
			</ul>
		</nav>
	</section>

	<div id="overall">
		<article id="textbox">
				<c:if test="${message ne null}"><p>${message}</p><br/></c:if><br/>
		</article>
	</div>
	<footer><%@include file="footer.jsp"%></footer>
</body>
</html>