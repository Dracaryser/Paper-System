<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录界面</title>
</head>
<%
    String errorInfo = (String)request.getAttribute("errormessage");         // 获取错误属性
    if(errorInfo != null) {
%>
<script type="text/javascript" language="javascript">
    alert("<%=errorInfo%>");                                            // 弹出错误信息

    window.history.go(-1);
</script>
<%
    }
%>
<body>
    <div class="container">
        <h1 class="page-header">登录</h1>
        <form name="form1" method="post">
            <div class="row">
                <div class="form-group col-sm-7">
                    <label for="id">学号/工号</label>
                    <input type="text" class="form-control" id="id" name="id" placeholder="请输入学号/工号">
                </div></div>
            <div class="row">
                <div class="form-group col-sm-7">
                    <label for="password">密码</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                </div></div>
            <div class="radio">
            <label>
                <input name="rdo" type="radio" value="1" onclick="document.form1.action='/student/login'"/>学生
            </label>
            <label>
                <input name="rdo" type="radio" value="1" onclick="document.form1.action='/tutor/login'"/>导师
            </label>
            </div>            <div class="row"><input type="submit" class="btn btn-info btn-lg col-sm-3" value="登录">
            </div><br>
            <div class="row"><a class="btn btn-danger btn-lg col-sm-3" href="/register/studentRegister">学生注册</a>
            </div><br>
            <div class="row"><a class="btn btn-danger btn-lg col-sm-3" href="/register/tutorRegister">导师注册</a></div>
    </form>

</body>
</html>

