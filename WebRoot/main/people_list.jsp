<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>人员列表</title>
<link rel="stylesheet" href="assets/css/bui-min.css" type="text/css"></link>
<link rel="stylesheet" href="assets/css/dpl-min.css" type="text/css"></link>
<link rel="stylesheet" href="assets/css/page-min.css" type="text/css" />
</head>
<body>
	<div class="container">
		<table cellspacing="0" class="table table-bordered">
			<thead>
				<tr>
					<th colspan="4">
						<ul class="toolbar">
							<li><a href="curl/people_input" class="button button-success">添加人员</a></li>
						</ul>
					</th>
				</tr>
				<tr>
					<th>#</th>
					<th>姓名</th>
					<th>所在部门</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="pageModel.objects">
				<tr>
					<td> </td>
					<td><s:property value="name"/></td>
					<td><s:property value="department.name"/></td>
					<td>
						<a href="curl/people_delete?id=<s:property value="id"/>" class="button button-danger"><i class="icon-white icon-trash"></i>删除</a> 
						<a href="curl/people_input?id=<s:property value="id"/>" class="button button-warning">更改</a> 
						<a href="curl/people_introduce?id=<s:property value="id"/>" class="button">查看详情</a>
					</td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
		<div>
			<div class="pagination pull-right">
				<ul>
					<li class="disabled"><a href="#">« 上一页</a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">下一页 »</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>