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
    <title>Register User</title>
</head>
<body>
<h2>User Registration:</h2>
<form action="registerUser" method="post">
<pre>
First Name: <input type="text" name="firstName"/>
Last Name:  <input type="text" name="lastName"/>
User Name: <input type="text" name="email"/>
Password: <input type="password" name="password"/>
Confirm Password: <input type="password" name="confirmPassword"/>
<input type="submit" value="register"/>
</pre>
</form>

</body>
</html>
