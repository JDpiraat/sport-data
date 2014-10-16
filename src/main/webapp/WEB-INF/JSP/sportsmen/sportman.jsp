<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='j' uri='http://johan40.be/tags'%>
<!DOCTYPE html>
<html>
<j:head title="new sportsman" />
<body>
	<j:menu />
	<div class="maincontent">
		<h1>Sportsman</h1>
		<h2>${sportsman.firstName} ${sportsman.lastname}</h2>
		<div>
			<ul>
				<li>sportsman.birthday</li>
<!-- 				<li>sportsman.lengthInMeter</li>				 -->
<!-- 				<li>sportsman.weightInKg</li>					 -->
<!-- 				<li>sportsman.maxHeartBeats</li>				 -->
				<li>sportsman.autoHeartbeats</li>				
			</ul>
		</div>
	</div>
</body>
</html>