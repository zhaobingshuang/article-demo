<%--
  Created by IntelliJ IDEA.
  User: zhaobs
  Date: 2020/9/4
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
asdfasf
<c:forEach items="${users}" var="user">
    <c:out value="${user.username}" /><br/>
    <c:out value="${user.age}" /><br/>
</c:forEach>
</body>
</html>
