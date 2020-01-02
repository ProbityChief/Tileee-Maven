<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = en>
	<head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome-animation/0.2.1/font-awesome-animation.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Tileee</title>
	<script src="https://kit.fontawesome.com/f64643ede5.js" crossorigin="anonymous"></script>
	<script type="text/javascript"><%@include file="js/train.js" %></script>
	<script type="text/javascript"><%@include file="js/index.js" %></script>
		<style type="text/css"><%@include file="css/index.css" %></style>
	</head>
	<body style=";">
	<c:choose>
	<c:when test="${sessionScope.user ne null}"><%@include file="header.jsp" %></c:when>
	<c:otherwise>
	<section id="title">
		<nav id="menu">
			<ul>
				<li class="fa fa-user-plus" onclick="window.location.replace('Identification')" title="Login"></li>
				<li id="quit" class="fa fa-reply" onclick="window.location.replace('/tileee')" title="Retour"></li>
			</ul>
		</nav>
	</section>
	</c:otherwise>
	</c:choose>
	<c:forEach items="${mot}" var="var">
	    <input type="hidden" class="mot" value="${var}" />
	</c:forEach>
	<c:forEach items="${traduction}" var="vor">
		<input type="hidden" class="traduction" value="${vor}" />
	</c:forEach>

	<div id="overall">
		        <div class="flippingcard">
            		<div class="card-single">
                		<div class="face-front">
                   			<p></p>
                    		<input type="text" id="input" autocomplete="off">
                		</div>
                		<div class="face-back">
                    		<p></p>
                		</div>
            		</div>
            		<button id="flip" class="fas fa-check-square"></button>
        		</div>
		</div>
		<footer><%@include file="footer.jsp"%></footer>
	</body>
</html>