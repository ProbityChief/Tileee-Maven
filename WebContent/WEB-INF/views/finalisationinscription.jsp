<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<section id="title">
		<nav id="menu">
			<ul>
				<li><a class="fa fa-user" href="Identification"></a></li>
				<li onmouseover="document.getElementById('overall').style.filter='blur(3px)'" onmouseout="document.getElementById('overall').style.filter='none'"><a class="fa fa-power-off" href="#"></a></li>
			</ul>
		</nav>
	</section>

	<div id="overall">
		<article id="textbox">
			<p class="inner">
				${userMessage}
			</p>
			<button id="textButton" style="background: rgba(27, 87, 116, 0.2);">DEMO</button>
		</article>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>