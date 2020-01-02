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
	<div id="overall">
		<article id="textbox"><br/>
		<c:if test="${message ne null}"><p>${message}</p><br/></c:if>
		<form action="ReinitialisationMDP" method="post">
		<input class="form-control" type="text" name="nouveaumdp" placeholder="Entrez votre nouveau mot de passe"><br/>
		<input class="form-control" type="text" name="confirmationnouveaumdp" placeholder="Confirmez votre nouveau mot de passe"><br/>
		<input type="hidden" name="user2" value="${user}">
		<input type="submit" name="nouveaumdp"><br/>
		</form>
		<p> </p>
		</article>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>