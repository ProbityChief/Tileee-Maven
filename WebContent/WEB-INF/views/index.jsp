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
				<li><a class="fa fa-user-plus" href="Identification"></a></li>
			</ul>
		</nav>
	</section>

	<div id="overall">
		<article id="textbox">
			<p class="inner">
				<em>Tileee</em> s'adresse à toutes les personnes étudiant les langues.<br/><br/>
			Les capacités du cerveau à mémoriser le vocabulaire en l'écrivant et le revoyant régulièrement 
			n'étant plus à prouver, Tileee, reposant sur la méthode des flashcards, vous incitera à remplir 
			votre mot à traduire ainsi que sa traduction parmi les traductions possibles, et vous permettra, 
			le cas échéant, d'écouter cette traduction.<br/><br/>
			Emporter ainsi votre vocabulaire partout avec vous pour 
			évaluer votre maitrise du vocabulaire, améliorer votre compréhension orale et constater vos progrès 
			à n'importe quel moment!
			</p>
			<a id="textButton" style="background: rgba(27, 87, 116, 0.2);" href="Demo">DEMO</a>
		</article>
	</div>
	<footer><%@include file="footer.jsp"%></footer>
</body>
</html>