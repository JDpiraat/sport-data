<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://johan40.be/tags'%>
<%@taglib prefix='security'
	uri='http://www.springframework.org/security/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Login' />
</head>
<body>
	<v:menu />
	<h1>Login</h1>
	<form method='post'>
		<label>Username:<input name='username' autofocus></label> <label>Password:<input
			name='password' type='password'></label>
		<security:csrfInput />
		<input type='submit' value='Login'>
		<c:if test='${param.error != null}'>
			<div class='fout'>Wrong username or password.</div>
		</c:if>
	</form>
</body>
</html>