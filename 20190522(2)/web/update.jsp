<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/22
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; GBK" pageEncoding="GBK" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<%request.setCharacterEncoding("utf-8");%>
<%response.setCharacterEncoding("utf-8");%>
<%response.setContentType("text/html;charset=utf-8");%>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>更改</title>
</head>
<body class="container-fluid">
<h1 class="lead">更改信息</h1>
<form action="update.do" method="post" style="width: 200px;">
    <div class="form-group">
        <input type="hidden" value="${user.id}" name="id">
        <label>用户id：</label>
        <input type="text" class="form-control" readonly="readonly" name="student_id"
               value="${user.student_id}"><br>
        <label>用户名：</label>
        <input type="text" class="form-control" name="student_name" value="${user.student_name}"><br>
        <label>密码：</label>
        <input type="text" class="form-control" name="student_password"
               value="${user.student_password}"><br>
        <input type="submit" class="btn btn-default" value="提交">
    </div>
</form>
</body>
</html>
