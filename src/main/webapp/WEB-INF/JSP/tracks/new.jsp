<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='j' uri='http://johan40.be/tags'%>
<!DOCTYPE html>
<html>
<j:head title="new track" />
<body>
	<j:menu />
	<div class="maincontent">
		<h1>New track</h1>
		<c:url value='/tracks' var='url' />
		<form:form action="${url}" commandName='trackForm' method='post'>
			<form:label path='name'>Name:</form:label>
			<form:input path='name' autofocus='true' required='true' />
			<form:errors path='name' />
			<form:label path='activity'>Activity:</form:label>
			<form:select path='activity'  items="${activityList}" required='true' />
			<form:errors path='activity' />
			<form:label path='kilometer'>Kilometers:</form:label>
			<form:input path='kilometer'  required='true' />
			<form:errors path='kilometer' />
			<form:label path='description'>Description:</form:label>
			<form:input path='description'  required='true' />
			<form:errors path='description' />
			<form:label path='remark'>Remark:</form:label>
			<form:input path='remark' />
			<form:errors path='remark' />
			<form:label path='status'>Status:</form:label>
			<form:select path='status' items="${statusList}" required='true' />
			<form:errors path='status' />
			<input type='submit' value='create'>
		</form:form>
	</div>
</body>
</html>