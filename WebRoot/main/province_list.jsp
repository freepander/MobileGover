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
<title>省列表</title>
<link rel="stylesheet" href="assets/css/bui-min.css" type="text/css"></link>
<link rel="stylesheet" href="assets/css/dpl-min.css" type="text/css"></link>
<link rel="stylesheet" href="assets/css/page-min.css" type="text/css" />
</head>
<body>
	<div class="container">
		<table cellspacing="0" class="table table-bordered">
			<thead>
				<tr>
					<th colspan="5">
						<ul class="toolbar">
							<li><label class="checkbox"><input type="checkbox"><a href="#">全选</a> </label></li>
							<li><button class="button button-danger">
									<i class="icon-white icon-trash"></i>批量删除
								</button></li>
							<li><a href="curl/province_input" class="button button-success">添加</a></li>
						</ul>
					</th>
				</tr>
				<tr>
					<th width="15"></th>
					<th>#</th>
					<th>名称</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="pageModel.objects">
				<tr>
					<td><input type="checkbox"></td>
					<td><s:property value="id"/></td>
					<td><s:property value="name"/></td>
					<td><s:property value="remarks"/></td>
					<td>
						<a href="curl/province_delete?id=<s:property value="id"/>" class="button button-danger"><i class="icon-white icon-trash"></i>删除</a> 
						<a href="curl/province_input?id=<s:property value="id"/>" class="button button-warning">更改</a> 
						<a href="curl/province_introduce?id=<s:property value="id"/>" class="button">查看详情</a>
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