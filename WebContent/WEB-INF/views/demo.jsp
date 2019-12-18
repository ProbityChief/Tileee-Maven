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
	<body style=";">
	<section id="title">
		<nav id="menu">
			<ul>
				<li><a class="fa fa-user-plus" href="Identification"></a></li>
				<li id="quit"><a class="fa fa-reply" href="/tileee"></a></li>
			</ul>
		</nav>
	</section>

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