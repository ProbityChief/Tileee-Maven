<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/f64643ede5.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="/js/index.js"></script>
</head>
<body>
<c:if test="${sessionScope.name != null}">
	<section id="title">
		<nav id="menu">
			<ul>
				<li><a class="fa fa-layer-group" href="Entrainement"></a></li>
				<li><a class="fa fa-tag" href="CreationStacks"></a></li>
				<li><a class="fa fa-user-friends" href="Invitation"><img src="pictures/Groupe2.svg"></a></li>
				<li><a class="fa fa-cog" href="Parametres"></a></li>
				<li><a class="fa fa-power-off" href="<%= request.getScheme() + "://"
													+ request.getServerName() + ":"
													+ request.getServerPort() +
													request.getContextPath()%>"></a></li>
			</ul>
		</nav>
	</section>
</c:if>
</body>
</html>