<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='j' uri='http://johan40.be/tags'%>
<!DOCTYPE html>
<html>
<j:head title="track" />
<body>
	<j:menu />
	<div class="maincontent">
		<h1>Track</h1>
		<jsp:include page="trackAllDetails.jsp">
			<jsp:param name="singleTrack" value="true"/>
		</jsp:include>	
	</div>
</body>
</html>