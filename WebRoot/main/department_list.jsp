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
<title>部门列表</title>
<link rel="stylesheet" href="assets/css/bui-min.css" type="text/css"></link>
<link rel="stylesheet" href="assets/css/dpl-min.css" type="text/css"></link>
<link rel="stylesheet" href="assets/css/page-min.css" type="text/css" />
</head>
<body>
	<div class="container">
		<table cellspacing="0" class="table table-bordered">
			<thead>
				<tr>
					<th colspan="6">
						<ul class="toolbar">
							<li><a href="curl/department_input" class="button button-success">添加</a></li>
						</ul>
					</th>
				</tr>
				<tr>
					<th>#</th>
					<th>名称</th>
					<th>所属机构</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<s:iterator value="list">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="organization.city.provice.name" /><s:property value="organization.city.name" /><s:property value="organization.name" /></td>
					<td><s:property value="remarks" /></td>
					<td>
						<a href="curl/department_delete?id=<s:property value="id" />" class="button button-danger"><i class="icon-white icon-trash"></i>删除</a> 
						<a href="curl/department_input?id=<s:property value="id" />" class="button button-warning">更改</a> 
						<a href="curl/department_introduce?id=<s:property value="id" />" class="button">查看详情</a>
					</td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
		
	</div>
</body>
</html>