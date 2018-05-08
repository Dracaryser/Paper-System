<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>学生论文详情</title>
</head>
<body>
<center>
    <h1 style="color:black">学生论文详情</h1>
    <form action="/paper/${student.paper.pid}/tutorUpdate" method="post">
        <table border="0">
            <tr>
                <td>论文题目：</td>
                <td><input type="text" name="pname" value="${student.paper.pname}"/>
                </td>
            </tr>
            <tr>
                <td>论文内容：</td>
                <td><textarea class="form-control" name="pcontent" rows="50"
                              cols="80">${student.paper.pcontent}</textarea>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="submit" value="保存">
                    <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回">
                    <a href="/paper/${student.sid}/tSendEmail">提交</a>
                </td>
            </tr>
            <tr>
                <td>
                    <h4>提醒：先保存再提交！</h4>
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
