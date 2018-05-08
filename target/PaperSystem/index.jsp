<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录界面</title>
</head>
<body>
<center>
    <h1 style="color:black">请登录</h1>
    <form name="form1" method="post">
        <table border="0">
            <tr>
                <td>学号/工号：</td>
                <td><input type="text" name="id" placeholder="请输入学号/工号"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password" placeholder="请输入密码">
                </td>
            </tr>
        </table>
        <div class="radio">
            <label>
                <input name="rdo" type="radio" value="1" onclick="document.form1.action='/student/login'"/>学生
            </label>
            <label>
                <input name="rdo" type="radio" value="1" onclick="document.form1.action='/tutor/login'"/>导师
            </label>
        </div>
        <br>
        <input type="submit" value="登录" style="color:black">
    </form>
    <form action="/register/studentRegister">
        <input type="submit" value="学生注册" style="color:black">
    </form>
    <form action="/register/tutorRegister">
        <input type="submit" value="导师注册" style="color:black">
    </form>
</center>
</body>
</html>