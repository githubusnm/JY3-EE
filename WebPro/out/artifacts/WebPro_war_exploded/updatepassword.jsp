<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/20
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改密码</title>
    <style>
        span {
            display: none;
            color: red;
        }
    </style>
</head>
<body>
<h1>更改密码</h1>
<form action="check.do" method="post" onsubmit="return func()">
    用户名：<input type="text" name="username"><br>
    原密码：<input type="password" name="password"><br>
    新密码：<input type="password" id="password"><br>
    确认密码：<input type="password" id="check" name="newpassword" onblur="show()"><span>两次密码输入不一致</span><br>
    <input type="submit" value="提交">
</form>
<script>
    function func(){
        var ps1 = document.getElementById("password").value;
        var ps2 = document.getElementById("check").value;
        if (ps1 == ps2){
            return true;
        } else {
            return false;
        }
    }
    function show() {
        var ps1 = document.getElementById("password").value;
        var ps2 = document.getElementById("check").value;
        if (ps1 != ps2) {
            document.getElementsByTagName("span")[0].style.display = "block";
        } else {
            document.getElementsByTagName("span")[0].style.display = "none";
        }
    }
</script>
</body>
</html>
