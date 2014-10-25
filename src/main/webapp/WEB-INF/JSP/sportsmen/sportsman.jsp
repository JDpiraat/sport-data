<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='j' uri='http://johan40.be/tags'%>
<!DOCTYPE html>
<html>
<j:head title="sportsman" />
<body>
	<j:menu />
	<div class="maincontent">
		<h1>Sportsman</h1>
		<jsp:include page="sportsmanAllDetails.jsp">
			<jsp:param name="singleSportsman" value="true"/>
		</jsp:include>		
	</div>
</body>
</html>