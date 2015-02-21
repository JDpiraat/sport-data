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
<form:errors path='firstname' element='div' cssClass='fout'/>
<form:input path='firstname' autofocus='true' required='true'/>
<form:label path='lastname'>Last name:</form:label>
<form:errors path='lastname' element='div' cssClass='fout'/>
<form:input path='lastname' required='true'/>
<form:label path='birthday'>Birthday:</form:label>
<form:errors path='birthday' element='div' cssClass='fout'/>
<form:input type="date" path='birthday' required='true'/>
<form:label path='lengthinmeters'>Length in meters:</form:label>
<form:errors path='lengthinmeters' element='div' cssClass='fout'/>
<form:input path='lengthinmeters' required='true'/>
<form:label path='weightinkg'>Weight in kg:</form:label>
<form:errors path='weightinkg' element='div' cssClass='fout'/>
<form:input path='weightinkg' required='true'/>
<form:label path='maxHeartbeats'>Maximum heartbeats a minute (220-age standard):</form:label>
<form:errors path='maxHeartbeats' element='div' cssClass='fout'/>
<form:input path='maxHeartbeats' />
<input type='submit' value='create'>
</form:form>
</div>
</body>
</html>