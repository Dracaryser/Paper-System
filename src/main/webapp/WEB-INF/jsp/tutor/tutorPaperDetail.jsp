<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>论文下载</title>
</head>
<body>
<center>
    <h1 style="color:black">论文下载</h1>
    <form action="/file/${student.sid}/down" method="get">
        <tr>
            <td>下载该学生的论文</td>
            <td><input type="submit" value="下载"></td>
        </tr>
    </form>

    <form action="/paper/${student.sid}/tSendEmail" method="post">
        <tr>
            <h2 style="color:black">修改意见</h2>
            <td><textarea name="comment" cols="60" rows="20"></textarea></td>
            <td><input type="submit" value="发送"></td>
            <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回">
        </tr>
    </form>
</center>
</body>
</html>
