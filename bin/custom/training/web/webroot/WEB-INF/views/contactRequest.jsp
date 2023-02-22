<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22.02.2023
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Request</title>
</head>
<body>
<form method="post">
    Sender:
    <input type="text" name="newSender" value="${contactRequest.sender}"/>
    <br/>
    Message:
    <textarea name="newMessage">${contactRequest.message}</textarea>
    <br/>
    <input type="submit" value="Send"/>
</form>
</body>
</html>