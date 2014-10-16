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
		<c:url value='/tracks' var='url'/>
<form:form action="${url}" commandName='track' method='post'>
<form:label path='name'>Name:</form:label>
<form:input path='name' autofocus='true' required='true'/>
<form:errors path='name'/>

<input type='submit' value='create'>
</form:form>
	</div>
</body>
</html>

private String ;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Activity activity;
	private double kilometer;
	private String description;
	private String remark;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Status status;	