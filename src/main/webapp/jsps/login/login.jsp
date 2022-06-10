<%--
  Created by IntelliJ IDEA.
  User: rohit
  Date: 18/05/22
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login</title>
</head>
<body>
<h2>Login:</h2>
<form action="login" method="post">
<pre>
User Name:<input type="text" name="email"/>
Password:<input type="password" name="password"/>
<input type="submit" value="login"/>

${msg}
</pre>
</form>

</body>
</html>
