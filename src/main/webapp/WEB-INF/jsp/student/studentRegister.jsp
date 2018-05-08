<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>学生注册</title>
</head>
<body>
<center>
    <h1 style="color:black">学生注册</h1>
    <form action="/register/student" method="post">
        <table border="0">
            <tr>
                <td>学号：</td>
                <td><input type="text" name="sid"/></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="sname"/></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><input type="radio" name="sex" value="男"/>男
                    <input type="radio" name="sex" value="女">女</td>
            </tr>
            <tr>
                <td>年龄：</td>
                <td><input type="text" name="age"/></td>
            </tr>
            <tr>
                <td>专业：</td>
                <td><input type="text" name="major"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>导师：</td>
                <td><input type="text" name="tname"/></td>
            </tr>
            <tr>
                <td>email：</td>
                <td><input type="text" name="mail"/></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="submit" value="注册"/> <a href="/index.jsp">返回</a></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>