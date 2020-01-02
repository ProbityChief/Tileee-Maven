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
	<script type="text/javascript" src="js/index.js"></script>
	<style><%@include file="css/index.css" %></style>
</head>
<body style=";">
<%@include file="header.jsp" %>

	<div id="overall">
		<article id="textbox">
			<p class="inner">
			Bienvenue ${sessionScope.user.login}
			</p>
		</article>
	</div>
	
<%@include file="footer.jsp" %>
</body>
</html>