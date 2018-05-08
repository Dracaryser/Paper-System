<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>导师详情</title>
<%@include file="../common/head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>导师信息</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>工号</th>
							<th>姓名</th>
							<th>职称</th>
							<th>邮箱</th>
							<th>密码</th>
							<th>学生</th>
							<th><a href="/tutor/${tutor.tid}/modify">修改个人信息</a></th>
							<th><a href="/tutor/logout">退出登录</a> </th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>${tutor.tid}</td>
								<td>${tutor.tname}</td>
								<td>${tutor.prof}</td>
								<td>${tutor.mail}</td>
								<td>${tutor.password}</td>
								<c:forEach items="${tutor.students}" var="s">
									<td><a href="/paper/${s.sid}/tdetail">${s.sname}</a></td>
								</c:forEach>
							</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>