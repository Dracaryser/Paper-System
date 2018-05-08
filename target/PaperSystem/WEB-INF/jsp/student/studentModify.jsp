<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>信息修改</title>
</head>
<body>
<center>
    <h1 style="color:black">信息修改</h1>
    <form action="/student/${student.sid}/smodify" method="post">
        <table border="0">
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password" value="${student.password}"/></td>
            </tr>
            <tr>
                <td>email：</td>
                <td><input type="text" name="mail" value="${student.mail}"/></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="submit" value="保存"/> <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>