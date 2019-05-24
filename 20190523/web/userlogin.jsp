<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/23
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<html>
<head>
    <title>用户登录/注册</title>
</head>
<body class="container-fluid">
<h2>用户登录</h2>

<form class="form-horizontal" action="userlogin.do" method="post">
    <div class="form-group">
        <label class="col-sm-2 control-label">User Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" placeholder="Username" name="username" style="width: 300px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" placeholder="Password" name="userpassword" style="width: 300px;">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">User Sign in</button>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <a type="button" class="btn btn-default" onclick="location.href='userregister.jsp'">User Register</a>
        </div>
    </div>
</form>

</body>
</html>
