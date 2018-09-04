<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>上传论文</title>
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
<center>
    <h1 style="color:black">上传论文</h1>
    <form action="/file/${student.sid}/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" /> <br/><br/>
        <input type="submit" value="上传" />
        <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回">
    </form>
    <form action="/paper/${student.sid}/sendEmail" method="post]">
        <h2 style="color:black">发送提醒邮件给导师</h2>
        <input type="submit" value="发送" />
    </form>
</center>
</body>
</html>
