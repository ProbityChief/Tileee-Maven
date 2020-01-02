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
				<tr>
					<td colspan="2">
						<form method="post" action="Parametres?action=supprimercompte">
  <input type="checkbox" name="supprimer"><label for="scales">Supprimer le compte (attention, une fois coché, il vous sera impossible de revenir en arrière)</label>
	</form>
				</tr>
			</table>
		</article>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>