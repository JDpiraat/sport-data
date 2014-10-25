<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<c:if test="${empty param.singleSportsman}">
	<spring:url var='url' value='/sportsmen/{id}'>
		<spring:param name='id' value='${sportsman.id}' />
	</spring:url>
</c:if>
<h2>
	<c:if test="${empty param.singleSportsman}">
		<a href='${url}'>
	</c:if>
	${sportsman.firstName} ${sportsman.lastName}
	<c:if test="${empty param.singleSportsman}">
		</a>
	</c:if>
</h2>
<div>
	<ul>
		<li>${sportsman.birthday}</li>
		<li><c:forEach items="${sportsman.lengthInMeters}" var="lenght">${lenght.lengthInMeters}
				</c:forEach></li>
		<li><c:forEach items="${sportsman.weightInKg}" var="weight">${weight.weightInKilogram}
				</c:forEach></li>
		<li><c:forEach items="${sportsman.maxHeartbeats}"
				var="heartbeats">${heartbeats.maxHeartbeats}
				</c:forEach></li>
		<li>${sportsman.autoMaxHeartbeats}</li>
	</ul>
</div>
