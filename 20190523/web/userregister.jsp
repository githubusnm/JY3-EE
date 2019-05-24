<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/24
  Time: 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <title>用户注册</title>
</head>
<body class="container-fluid">
<h2>用户注册</h2>
<form class="form-horizontal" action="userregister.do" method="post" onsubmit="return check()">
    <div class="form-group">
        <label class="col-sm-2 control-label">User Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" placeholder="Username" name="username" id="username" style="width: 300px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" placeholder="Password" name="userpassword" id="userpassword" style="width: 300px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">验证码</label>
        <div class="col-sm-10">
            <span id="code"></span>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">User Register</button>
        </div>
    </div>
</form>
<script src="js/jquery.js"></script>
<script src="js/register.js"></script>
</body>
</html>
