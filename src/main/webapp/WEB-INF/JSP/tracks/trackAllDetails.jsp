<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<c:if test="${empty param.singleTrack}">
	<spring:url var='url' value='/tracks/{id}'>
		<spring:param name='id' value='${track.id}' />
	</spring:url>
</c:if>
<h2>
	<c:if test="${empty param.singleTrack}">
		<a href='${url}'>
	</c:if>
	${track.name}
	<c:if test="${empty param.singleTrack}">
		</a>
	</c:if>
</h2>
<div>
	<ul>
		<li>${track.activity.toString()}</li>
		<li>${track.kilometer} km</li>		
		<li>${track.description}</li>
		<c:if test="${track.remark.isPresent() && track.remark.get() != ''}">
			<li>${track.remark.get()}</li>
		</c:if>
		<li>${track.status.toString()}</li>
	</ul>
</div>
