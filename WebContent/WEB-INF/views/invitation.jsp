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
	<script type="text/javascript"><%@include file="js/invitation.js" %></script>
	<script type="text/javascript"><%@include file="js/index.js" %></script>
	<style><%@include file="css/index.css" %></style>
 	<style><c:if test="${choix == 1}">
 				.presentation {
 					background: transparent;
 				}
 				.partager, .genererurl {
 					background: #1b5774;
 				}
 			</c:if>
 			<c:if test="${choix == 2}">
 				.presentation, .genererurl {
 					background: #1b5774;
 				}
 				.partager {
 					background: transparent;
 				}
 			</c:if>
 			<c:if test="${choix == 3}"> 
 				.presentation, .partager { 
 					background: #1b5774;
 				}
 				.genererurl { 
 					background: transparent; 
 				} 
			</c:if>
</style>
</head>
<body style=";">
<!-- 	<div id="overall"> -->
<!-- 		<article id="textbox"> -->
<!-- 			<div style="display: flex; flex-direction: row; height: 75px"> -->
<!-- 				<p class="invit" style="display: inherit; flex-grow: 1; margin: 0; align-items: center; justify-content: center;"><a href="Invitation?action=1">Invitations reçues</a></p> -->
<!-- 				<p class="contact" style="display: inherit; flex-grow: 1; margin: 0; align-items: center; justify-content: center;"><a href="Invitation?action=2">Créer liste contact</a></p> -->
<!-- 				<p class="envoyerinvit" style="display: inherit; flex-grow: 1; margin: 0; align-items: center; justify-content: center;"><a href="Invitation?action=3">Envoyer invitation</a></p> -->
<!-- 			</div> -->
<%-- 			<c:if test="${choix == 1}"> --%>
<%-- 					<c:choose> --%>
<%-- 				<c:when test="${listInvitation ne null}"> --%>
<!-- 					<table> -->
<%-- 			<c:forEach items="${listInvitation}" var="lol" varStatus="loop">	 --%>
<%-- 				<tr><td>${lol.giver} vous invite à jouer sur sa stack ${lol.tag}</td> --%>
<%-- 				<td><a href="/ajoutstack/${loop.count}">Ajouter la stack ${lol.tag} à mes stacks</a></td></tr> --%>
<%-- 			</c:forEach> --%>
<!-- 				</table> -->
<%-- 			</c:when> --%>
<%-- 			<c:otherwise> --%>
<!-- 				<p>Aucun ami ne vous a actuellement envoyé de stacks à essayer</p> -->
<%-- 			</c:otherwise> --%>
<%-- 			</c:choose> --%>
<%-- 			</c:if> --%>
<%-- 			<c:if test="${choix == 2}"> --%>
<!-- 			<table> -->
<!-- 		        <form method="post" action="Invitation?action=2" charset="utf-8" class="inner"> -->
<!-- 		        		        <tr><h3>Créer une liste de contact</h3></tr> -->
<!-- 		        <tr><td><label>Veuillez indiquer le nom de la nouvelle liste de contact : </label></td> -->
<!-- 		        <td><input type="text" name="listName"></td></tr> -->
<!-- 		        <tr style="text-align:center"><td colspan="2"><button type="submit">Créer la nouvelle liste</button></td></tr> -->
<!-- 		        </form> -->
<!-- 		        </table> -->
<!-- 		        <table> -->
<!-- 		        <form method="post" action="Invitation?ction=2" charset="utf-8" class="inner"> -->
<!-- 		        <tr><h3>Ajouter un contact à une liste </h3></tr> -->
<!-- 		        <tr><td><label>Veuillez indiquer le nom du contact à ajouter : </label></td> -->
<!-- 		        <td><input type="text" name="listName"></td></tr> -->
<!-- 		        <tr><td><label>Veuillez indiquer la liste dans lequel l'ajouter : </label></td> -->
<!-- 		        <td><select>Liste de contacts -->
<!-- 		        <option>Liste1</option> -->
<!-- 		        </select></td></tr> -->
<!-- 		        <tr style="text-align:center"><td colspan="2"><button type="submit">Ajouter le contact à la liste</button></td></tr> -->
<!-- 		        </form> -->
<!-- 		    </table> -->
<%-- 			</c:if> --%>
<%-- 			<c:if test="${choix == 3}"> --%>
<!-- 			<table> -->
<!-- 				<form method="post" action="Invitation?ction=3" charset="utf-8" class="inner"> -->
<!-- 		        <tr><h3>Envoyer une stack à des amis </h3></tr> -->
<!-- 		        <tr><td><label>Veuillez indiquer le nom de la stack à envoyer : </label></td> -->
<!-- 		        <td><select>Liste de stacks -->
<!-- 		        <option>Stack1</option> -->
<!-- 		        </select></td></tr> -->
<!-- 		        <tr><td><label>Veuillez indiquer la liste de contacts à qui l'envoyer : </label></td> -->
<!-- 		        <td><select>Liste de contacts -->
<!-- 		        <option>Liste1</option> -->
<!-- 		        </select></td></tr> -->
<!-- 		        <tr style="text-align:center"><td colspan="2"><button type="submit">Envoyer la stack à la liste</button></td></tr> -->
<!-- 		        </form> -->
<!-- 		        </table> -->
<%-- 			</c:if> --%>
<!--    		</article> -->
<!-- 	</div> -->
<%@include file="header.jsp" %>

	<div id="overall">
		<article id="textbox">
			<div style="display: flex; flex-direction: row; height: 75px">
				<p class="presentation" style="display: inherit; flex-grow: 1; margin: 0; align-items: center; justify-content: center;"><a href="Invitation?action=1">Invitations Tileee</a></p>
				<p class="partager" style="display: inherit; flex-grow: 1; margin: 0; align-items: center; justify-content: center;"><a href="Invitation?action=2">Partager ses stacks</a></p>
				<p class="genererurl" style="display: inherit; flex-grow: 1; margin: 0; align-items: center; justify-content: center;"><a href="Invitation?action=3">Rajouter des stacks</a></p>
			</div>
			<p class="inner">
					<c:if test="${choix == 1}">
			Ce menu vous permet de partager des stacks avec vos amis. Vous pouvez pour chacune de vos
			stack générer un lien à leurs envoyer dans le menu "Partager ses stacks", et vous 
			pouvez ajouté les stacks de vos amis en entrant leurs liens envoyés dans le menu 
			"Ajouter des Stacks".
			</c:if>
			<c:if test="${choix == 2}">
					<c:choose>
				<c:when test="${lTag ne null}">
			<select id="selecttag" name="tag" id="tag">
      			<c:forEach items="${lTag}" var="lol">
      			<option value="${lol.rand}">${lol.tag_name}</option>
      			</c:forEach>
      		</select>
      		<button onclick="obtenirrand()">Obtenir le numero de partage</button>
      		<textarea id="randtag" rows="1" cols="60"></textarea>
			</c:when>
			<c:otherwise>
				Vous n'avez actuellement aucune stack à partager avec vos amis
			</c:otherwise>
			</c:choose>
			</c:if>
			<c:if test="${choix == 3}">
			<c:if test="${tagName ne null}">
			 	<p>La stack ${tagName} à bien été ajoutée à votre liste.</p>
			</c:if>
			<table>
				<form method="post" action="?action=3" charset="utf-8" class="inner">
		        <tr><label>Veuillez indiquer le lien donné par votre ami pour récuperer la stack : </label></tr>
		        <tr><textarea name="rand" maxlength="60"></textarea></tr>
		        <tr style="text-align:center"><td colspan="2"><button type="submit">
		        Récupérer la stack</button></td></tr>
		        </form>
		        </table>
			</c:if>
			</p>
   		</article>
	</div>
<%@include file="footer.jsp" %>
</body>
</html>