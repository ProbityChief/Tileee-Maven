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
<%@include file="header.jsp" %>

	<div id="overall">
		<article id="textbox">
		<p>
		<c:if test="${validation == 2}">
		<p> Votre carte à bien été ajoutée, vous pouvez en ajouter une nouvelle :)</p>
		</c:if>
		<form method="post" action="CreationStacks?action=2">
		<select name="langueinitiale" id="lg-initiale">
    <option value="">Veuillez indiquer la langue du mot à traduire</option>
    <option value="français">Français</option>
    <option value="anglais">Anglais</option>
</select>
<select name="langueatraduire" id="lg-atraduire">
    <option value="">Veuillez indiquer la langue du mot traduit</option>
    <option value="français">Français</option>
    <option value="anglais">Anglais</option>
</select><br />
      <input type="text" placeholder="Entrer le mot à traduire" name="motinitial">
      <input type="text" placeholder="Entrer le mot traduit" name="mottraduit"><br />
      Ajouter un nouveau tag ou selectionner un ou plusieurs tags (5 maximums):
            <input type="text" placeholder="Entrer un nouveau tag" name="tagaajouter"><br />
      		<select name="langueinitiale" id="lg-initiale">
    <option value="">tags</option>
    <option value="transport">Transport</option>
    <option value="maison">Maison</option>
    <input type="submit" value="Envoyer carte">
</select>
</form><p>
		</article>
	</div>

<%@include file="footer.jsp" %>
</body>
</html>