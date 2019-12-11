<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = en>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Tileee</title>
	<script type="text/javascript" src="index.js"></script>
	<style><%@include file="css/index.css" %></style>
</head>
<body>
	<section id="title">
		<header><a id="site" href="<%=request.getScheme()+"://"
				+ request.getServerName() + ":"
				+ request.getServerPort() 
				+ request.getContextPath()
				+"/"%>">TILEEE</a></header>
		<nav id="menu">
			<ul>
				<li><a href="Entrainement">Entraînement</a></li>
				<li><a href="CreationStacks">Création De Stacks</a></li>
				<li><a href="MonCompte">S'identifier</a></li>
				<li><a href="Inscription">S'inscrire</a></li>
			</ul>
		</nav>
	</section>

	<div id="overall">
		<article id="textbox">
			<p>Tileee s'adresse à toutes les personnes ne se sentant pas à l'aise avec les langues. 
			Les capacités du cerveau à mémoriser le vocabulaire en l'écrivant et le revoyant régulièrement 
			n'étant plus à prouver, Tileee, reposant sur la méthode des flashcards, vous incitera à remplir 
			votre mot à traduire ainsi que sa traduction parmi les traductions possibles, et vous permettra, 
			le cas échéant, d'écouter cette traduction. Emporter ainsi votre vocabulaire partout avec vous pour 
			évaluer votre maitrise du vocabulaire, améliorer votre compréhension orale et constater vos progrès 
			à n'importe quel moment de la journée ou de la nuit!</p>
      <img id="loading" src="pictures/Loading.gif">
		</article>
	</div>

	<footer>
	</footer>
</body>
</html>