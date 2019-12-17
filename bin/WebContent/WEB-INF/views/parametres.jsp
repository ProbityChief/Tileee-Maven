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
			<table>
				<tr>
					<td>
						<form method="post" action="Parametres?action=modifpass">
							<input type="text" placeholder="Saisissez votre nouveau mot de passe" name="newpass"><br /> 
							<input type="text" placeholder="Confirmer votre nouveau mot de passe" name="confirmationnewpass">
					</td>
					<td><input type="submit" value="Modifier votre mot de passe"></td>
				</tr>
				<tr>
					<td>
						<form method="post" action="Parametres?action=modiftheme">
							<select name="theme">
								<option value="">Tileee</option>
								<option value="transport">Flashcards</option>
								<option value="maison">Le Bahaus</option>
							</select>
					<td><input type="submit" value="Modifier le thème">
						</form></td>
				</tr>
			</table>
		</article>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>