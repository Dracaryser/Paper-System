<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>学生详情</title>
<%@include file="../common/head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>学生信息</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>年龄</th>
							<th>专业</th>
							<th>邮箱</th>
							<th>导师</th>
							<th>论文状态</th>
							<th><a href="/student/${student.sid}/modify">修改个人信息</a></th>
							<th><a href="/student/logout">退出登录</a> </th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>${student.sid}</td>
								<td>${student.sname}</td>
								<td>${student.sex}</td>
								<td>${student.age}</td>
								<td>${student.major}</td>
								<td>${student.mail}</td>
								<td>${student.tutor.tname}</td>
								<td><a href="/paper/${student.sid}/detail">${student.paper.state}</a> </td>
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
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>