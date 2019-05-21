<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/17
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="Hello.do" method="get">
      用户名：<input type="text" name="username"><br>
      密码：<input type="password" name="password"><br>
      <input type="submit" value="提交">
      <input type="button" value="登录" onclick="location.href='login.jsp'">
      <input type="button" value="查询所有用户" onclick="location.href='select.do'">
  </form>
  </body>
</html>
