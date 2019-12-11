<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Tileee</title>
<script type="text/javascript" src="WebContent/WEB-INF/views/js/index.js"></script>
<style>
<%@include file="css/index.css" %>
</style>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.m
in.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-
theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYg
mgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
crossorigin="anonymous"></script>
</head>
<body>
	<section id="title">
		<header>
			<a id="site"
				href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>">TILEEE</a>
		</header>
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
		<table border="0" cellspacing="0" cellpadding="0">
	<form method="post" class="form-group-lg" action="?action=addUser" accept-charset="utf-8" charset="utf-8">
		<tr>
			<td class="no_border">Nom</td>
			<td class="no_border">
				<input type="hidden" name="action" value="addUser"/>
				<input class="form-control" border="0" size="60" value="<c:out value='${forename}' />"  type="text" placeholder="Login" name="forename" id="forename" >
				<br />
				<span><c:out value="${forenameMessage}" /></span>
			</td>
		</tr>

		<tr>
			<td colspan="2">
				&nbsp;
			</td>
		</tr>
      <tr>  
      	<td class="no_border">
        	Email
        </td>
        <td class="no_border">      
           <input value="<c:out value='${email}' />" size="40"  id="email" type="email" name="email" placeholder="Votre adresse e-mail" style="background:#ffffff" class="form-control">
           <c:if test="${not empty messageEmail}"><span><c:out value="${messageEmail}" /></span><br /></c:if><br />
        </td>
	</tr>

            
    <tr>
    	<td class="no_border">
    		Mot de passe
    	</td>
    	<td class="no_border">
           <input value="<c:out value='${password}' />" size="30" id="password" type="password" name="password" placeholder="Mot de passe" style="background:#ffffff" class="form-control">
           <br />
           <span><c:out value="${messagePassword}" /></span>
        </td>
   </tr>    


   	<tr>
   		<td class="no_border">
   			Confirmation du mot de passe&nbsp;
   		</td>
   		<td class="no_border">         
                <input value="<c:out value='${password}' />" size="30" id="password1" type="password" name="password1" placeholder="Confirmation du mot de passe" style="background:#ffffff" class="form-control">
                <br /><span><c:out value="${messagePassword1}" /></span>
        </td>
   </tr>


   <tr>
   		<td class="no_border">
   			Numéro de téléphone
   		</td>  
   		<td class="no_border">
			<input type="tel" size="15" maxlength="10" value="<c:out value='${phoneNumber}' />"  id="phoneNumber" type="tel" name="password1" placeholder="Tél.- Facultatif" style="background:#ffffff" class="form-control">
        </td>
	</tr>

	<tr>
			<td colspan="2">
				&nbsp;
			</td>
		</tr>

	<tr>
		<td>
        </td>
		<td class="no_border">	
            <button id="submit" type="submit"  class="form-control btn btn-primary">S'inscrire</button>
        </td>
        
    </tr>

        	</form>
        </table>
			<!--<p>Entrez votre identifiant: </p><input type="text" placeholder="Saisissez votre identifiant" name="id">
			<p>Choississez votre mot de passe: </p><input type="text" placeholder="Saisissez votre mot de passe"
				name="password"> 
			<p>Confirmer votre mot de passe: </p><input type="text" placeholder="Confirmer votre mot de passe" name="password">
			<button name="login">S'inscrire</button>-->
		</article>
	</div>

	<footer> </footer>
	<%@include file="footer.jsp" %>
</body>
</html>