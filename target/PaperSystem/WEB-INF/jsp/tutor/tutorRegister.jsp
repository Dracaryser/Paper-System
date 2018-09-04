<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>导师注册</title>
</head>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/CheckTutor.js" charset="UTF-8"></script>
<body>
<center>
    <h1 style="color:black">导师注册</h1>
    <form action="/register/tutor" method="post">
        <table border="0">
            <tr>
                <td>工号：</td>
                <td><input type="text" name="tid" id="tid"/>
                <span id="checkTU"></span></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="tname"/></td>
            </tr>
            <tr>
                <td>职称：</td>
                <td><input type="text" name="prof"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"/></td>
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