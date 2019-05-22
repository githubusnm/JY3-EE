<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/22
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>
<body>

<table border="1px">
    <thead>
    <th>序号</th>
    <th>用户名</th>
    </thead>
    <c:forEach items="${user}" var="user">
        <tr>

                <%--<form action="update.jsp" method="get">--%>
                <%--<td><input type="text" readonly="readonly" value="${user.student_id}" name="student_id"></td>--%>
                <%--<td>${user.student_name}</td>--%>
                <%--<td>--%>
                <%--<button type="submit">更改</button>--%>
                <%--</td>--%>
                <%--</form>--%>
                <%--<td>--%>
                <%--<button onclick="location.href='delete.do'">删除</button>--%>
                <%--</td>--%>
            <form action="delete.do" method="get">
                <td><input type="text" readonly="readonly" value="${user.student_id}" name="student_id"></td>
                <td>${user.student_name}</td>
                <td>
                    <a id="btn1" href="update.jsp" name="student_id">更改</a>
                </td>
                <td>
                    <button id="btn2" type="submit">删除</button>
                </td>
            </form>


        </tr>
    </c:forEach>
</table>

</body>
</html>
