<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/21
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户</title>
</head>
<body>
<h1>所有用户：</h1>
<table border="1px">
    <c:forEach items="${alluser}" var="alluser">
        <tr>
            <td>
                ${alluser}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
