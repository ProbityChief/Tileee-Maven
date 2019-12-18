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
	<style><%@include file="css/index.css" %>
			<c:if test="${choix == 1}">
				.inscription {
					background: transparent;
				}
				.login {
					background: #1b5774;
				}
			</c:if>
			<c:if test="${choix == 2}">
				.inscription {
					background: #1b5774;
				}
				.login {
					background: transparent;
				}
			</c:if></style>
</head>
<body>
	<section id="title">
		<nav id="menu">
			<ul>
				<li id="quit"><a class ="fa fa-reply" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"%>"></a></li>
			</ul>
		</nav>
	</section>
	<% request.setAttribute("1", "action"); %>
	<div id="overall">
		<article id="textbox">
			<div style="display: flex; flex-direction: row; height: 75px">
				<p class="inscription" style="display: inherit; flex-grow: 1; margin: 0; align-items: center; justify-content: center;"><a href="Identification?action=1">Inscription</a></p>
				<p class="login" style="display: inherit; flex-grow: 1; margin: 0; align-items: center; justify-content: center;"><a href="Identification?action=2">Login</a></p>
			</div>
			<c:if test="${choix == 1}">
				<form method="post" action="?choix=1&validation=inscription" charset="utf-8" class="inner">
				<input type="text" name="name" placeholder="Login" class="form-control" required="required"><br/><br/>
               	<input type="email" name="email" placeholder="Email" class="form-control" required="required"><br/><br/>
	            <input id="firstPassword" type="password" name="password" placeholder="Mot de passe" class="form-control" required="required"><br/><br/>
	            <input id="secondPassword" type="password" name="password1" placeholder="Confirmer" class="form-control" required="required"><br/><br/>
	            <c:if test="${ !empty nameError}">${nameError}<br/></c:if>
	       		<c:if test="${ !empty emailError}">${emailError}<br/></c:if>
        		<c:if test="${ !empty passError}">${passError}<br/></c:if>
	            <button id="submit" type="submit"><i class="fa fa-check" style="color: #1b5774; transition: color 0.25s" onmouseover="this.style.color='#dddddd'" onmouseout="this.style.color='#1b5774'"></i></button>
			</form>
			</c:if>
			<c:if test="${choix == 2}">
	        <form method="post" action="?choix=2&validation=login" charset="utf-8" class="inner">
				<input type="text" name="name" placeholder="Login" class="form-control" required="required"><br/><br/>
	            <input id="firstPassword" type="password" name="password" placeholder="Mot de passe" class="form-control" required="required"><br/><br/>
	            <button id="submit" type="submit"><i class="fa fa-check" style="color: #1b5774; transition: color 0.25s" onmouseover="this.style.color='#dddddd'" onmouseout="this.style.color='#1b5774'"></i></button><br />
				<a href="MotDePasseOublie">Mot de passe oublié?</a>
				<c:if test="${error == 1}">
				Impossible de trouver le login, rééssayez
				</c:if>		
			</form>
			</c:if>
			<c:if test="${choix == 3}"><p>Bonjour</p>
			</c:if>
			<c:if test="${choix == 4}"><p>Page de chargement de Térence</p>
			</c:if>
   		</article>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>