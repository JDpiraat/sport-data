<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='security'
	uri='http://www.springframework.org/security/tags'%>
<nav>
	<ul>
		<li><a href="<c:url value='/'/>">Home</a></li>
		<li><a href="<c:url value='/login'/>">Login</a></li>
		<li>
			<form method='post' action='<c:url value="/logout"/>' id='logoutform'>
				<input type='submit' value='Logout' id='logoutbutton'>
				<security:csrfInput />
			</form>
		<li><a href="<c:url value='/sportsmen'/>">Sportsmen</a></li>
		<li><a href="<c:url value='/sportsmen/new'/>">New sportsman</a></li>
		<li><a href="<c:url value='/tracks'/>">Tracks</a></li>
		<li><a href="<c:url value='/tracks/new'/>">New track</a></li>
		<li><a href="<c:url value='/sports-sessions'/>">Sports
				sessions</a></li>
		<li><a href="<c:url value='/sports-sessions/new'/>">New
				sports session</a></li>


	</ul>
</nav>
