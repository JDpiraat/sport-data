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
<h1>New sportsman</h1>
<c:url value='/sportsmen' var='url'/>
<form:form action="${url}" commandName='sportsmanForm' method='post'>
<form:label path='firstname'>First name:</form:label>
<form:input path='firstname' autofocus='true' required='true'/>
<form:errors path='firstname'/>
<form:label path='lastname'>Last name:</form:label>
<form:input path='lastname' required='true'/>
<form:errors path='lastname'/>
<form:label path='birthday'>Birthday:</form:label>
<form:input type="date" path='birthday' required='true'/>
<form:errors path='birthday'/>
<form:label path='lengthinmeters'>Length in meters:</form:label>
<form:input path='lengthinmeters' required='true'/>
<form:errors path='lengthinmeters'/>
<form:label path='weightinkg'>Weight in kg:</form:label>
<form:input path='weightinkg' required='true'/>
<form:errors path='weightinkg'/>
<input type='submit' value='create'>
</form:form>
</div>
</body>
</html>