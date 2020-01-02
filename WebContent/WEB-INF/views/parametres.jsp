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
<body>
	<section id="title">
		<nav id="menu">
			<ul>
				<li id="quit" class="fa fa-reply" onclick="window.location.replace('PageAcceuil')" title="Retour"></li>
			</ul>
		</nav>
	</section>
	<div id="overall">
		<article id="textbox">
				<!-- form method="post" action="Parametres?action=modiftheme" class="inner">
					<select name="theme" class="form-control">
						<option value="">Tileee</option>
						<option value="transport">Flashcards</option>
						<option value="maison">Le Bahaus</option>
					</select>
					<input type="submit" value="Modifier le thème" class="form-control">
				</form>
				<hr/-->
				<form method="get" action="" class="inner" style="padding: 30px; display: flex; justify-content: center; align-items: center">
					 Mon Compte
					<input type="submit" id="suppression" name="action" value="Supprimer" class="form-control" style="color: #ed4337; font-size: 1em; cursor: pointer;" disabled>
					<input type="checkbox" class="checkbox" >
					<input type="checkbox" id="test1" onclick="if(document.querySelector('#test1').checked === true) document.querySelector('#suppression').disabled = false; else document.querySelector('#suppression').disabled = true;"><label for="test1" aria-describedby="label"></label><br>
				</form>
		</article>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>