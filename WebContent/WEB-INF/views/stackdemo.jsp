<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = en>
	<head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome-animation/0.2.1/font-awesome-animation.css">
        <script src="https://kit.fontawesome.com/f64643ede5.js" crossorigin="anonymous"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Tileee</title>
		<script type="text/javascript"><%@include file="js/train.js" %></script>
		<script type="text/javascript"><%@include file="js/index.js" %></script>
		<style type="text/css"><%@include file="css/index.css" %></style>
	</head>
	<body>
		<section id="title">
			<nav id="menu">
				<ul>
					<li id="quit" class="fa fa-reply" onclick="window.location.replace('/tileee')" title="Retour"></li>
				</ul>
			</nav>
		</section>
		
		<div id="overall" style="flex-direction: column; justify-content: center; align-items: center;">
			<form id="textbox" action="Demo" method="post">
				<div style="display: flex; flex-direction: row;">
			    	<input type="text" placeholder="Mot" class="form-control" name="mot" required="required" style="margin: 12px;" autocomplete="off"/>
			    	<input type="text" placeholder="Traduction" class="form-control" name="traduction" required="required" style="margin: 12px;" autocomplete="off"/>
		    	</div>
			</form>
			<div style="display: flex; flex-direction: row; width: 400px;">
				<button onclick="addInputs()" class="fa fa-plus-square otherbutton"></button>
				<button type="submit" class="fa fa-check-square otherbutton" form="textbox"></button>
			</div>
		</div>
		<footer><%@include file="footer.jsp"%></footer>
		<script>
			addInputs = () => {
				let div = document.createElement('div');
				let addspace = document.querySelector('#textbox');
				div.innerHTML = '<div style="display: flex; flex-direction: row;"><input type="text" placeholder="Mot" class="form-control" name="mot" required="required" style="margin: 12px;"  autocomplete="off"/><input type="text" placeholder="Traduction" class="form-control" name="traduction" required="required" style="margin: 12px;"  autocomplete="off"/></div>';
				addspace.appendChild(div);
			};
		</script>
	</body>
</html>