<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/23
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<head>
    <title>请登录</title>
</head>
<body class="container-fluid">
<h2>管理员登录</h2>

<form class="form-horizontal"  action="login.do">
    <div class="form-group">
        <label class="col-sm-2 control-label">Admin Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" placeholder="Adminname" name="adminname" style="width: 300px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" placeholder="Password" name="adminpassword" style="width: 300px;">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Admin Sign in</button>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <a type="button" class="btn btn-default" onclick="location.href='userlogin.jsp'">User Sign in</a>
        </div>
    </div>
</form>

</body>
</html>
