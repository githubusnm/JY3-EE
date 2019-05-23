<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/22
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8");%>
<%response.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=utf-8");%>
<html>
<head>
    <title>$Title$</title>
</head>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>
<body class="container-fluid">
<table class="table table-condensed" border="1px">
    <thead>
    <th>id</th>
    <th>用户id</th>
    <th>用户名</th>
    <th>用户密码</th>
    </thead>
    <%--<c:forEach items="${user}" var="user">--%>
    <%--<tr>--%>
    <%--&lt;%&ndash;<form action="update.jsp" method="get">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td><input type="text" readonly="readonly" value="${user.student_id}" name="student_id"></td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td>${user.student_name}</td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<button type="submit">更改</button>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</form>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<td>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<button onclick="location.href='delete.do'">删除</button>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</td>&ndash;%&gt;--%>

    <%--<form action="delete.do" method="get">--%>
    <%--<td><input type="text" readonly="readonly" value="${user.student_id}" name="student_id"></td>--%>
    <%--<td>${user.student_name}</td>--%>
    <%--<td>--%>
    <%--<button type="submit">删除</button>--%>
    <%--</td>--%>
    <%--</form>--%>
    <%--<td>--%>
    <%--<form action="update.jsp">--%>
    <%--<input type="hidden" value="${user.student_id}" name="student_id">--%>
    <%--<input type="hidden" value="${user.student_name}" name="student_name">--%>
    <%--<button type="submit">更改</button>--%>
    <%--</form>--%>
    <%--</td>--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>

    <c:forEach items="${user}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.student_id}</td>
            <td>${user.student_name}</td>
            <td>${user.student_password}</td>
            <td>
                <a class="btn btn-warning" href="updateview.do?id=${user.id}&student_id=${user.student_id}&student_name=${user.student_name}&student_password=${user.student_password}">更改</a>
            </td>
            <td>
                <a class="btn btn-danger" href="delete.do?id=${user.id}">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
