<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = en>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome-animation/0.2.1/font-awesome-animation.css">
        <script src="https://kit.fontawesome.com/f64643ede5.js" crossorigin="anonymous"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Tileee</title>
		<script type="text/javascript" src="index.js"></script>
		<script src="train.js" type="text/javascript"></script>
		<style><%@include file="css/index.css" %></style>
	</head>
	<body style=";">
	<section id="title">
		<nav id="menu">
			<ul>
				<li><a class="fa fa-user" href="Identification"></a></li>
				<li onmouseover="document.getElementById('overall').style.filter='blur(3px)'" onmouseout="document.getElementById('overall').style.filter='none'"><a class="fa fa-power-off" href="#"></a></li>
			</ul>
		</nav>
	</section>

	<div id="overall">
		        <div class="flippingcard">
            		<div class="card-single">
                		<div class="face-front">
                   			<p>mot</p>
                    		<input type="text" id="input" autocomplete="off">
                		</div>
                		<div class="face-back">
                    		<p>word</p>
                		</div>
            		</div>
            		<button id="flip" class="fas fa-check-square fa-6x"></button>
        		</div>
		</div>
		<footer><%@include file="footer.jsp"%></footer>
	</body>
</html>