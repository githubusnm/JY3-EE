<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/22
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改</title>
</head>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>
<body>
<h1>更改信息</h1>
<form action="update.do" method="post">
    序号：<input type="text" name="student_id"><br>
    新用户名：<input type="text" name="student_name"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
