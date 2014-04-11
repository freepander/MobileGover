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
<title>图片列表</title>
<link rel="stylesheet" href="assets/css/bui-min.css" type="text/css"></link>
<link rel="stylesheet" href="assets/css/dpl-min.css" type="text/css"></link>
<link rel="stylesheet" href="assets/css/page-min.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.9.min.js"></script>
</head>
<body>
	<div class="container">
	<div>
		<table cellspacing="0" class="table table-bordered">
			<thead>
				<tr>
					<th>名称</th>
					<th>图片数量</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="pageModel.objects">
				<tr>
					<td><s:property value="title"/></td>
					<td><s:property value="number"/></td>
					<td><a href="curl/pictureNews_itemList?id=<s:property value="id"/>" class="button">查看详情</a><a href="curl/pictureNews_delete?id=<s:property value="id"/>" class="button">删除</a></td>
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
		<div style="clear:both;">
		<h2>添加</h2>
		<hr>
		<form method="post" action="curl/pictureNews_add" class="form-horizontal span24">
			<div class="row">
				<div class="control-group span8">
					<label class="control-label"><s>*</s>标题：</label>
					<div class="controls">
						<input name="title" type="text" class="input-normal control-text">
					</div>
				</div>
			</div>
			<div class="row form-actions actions-bar">
				<div class="span13 offset3 ">
					<button type="submit" class="button button-primary">保存</button>
				</div>
			</div>
		</form>
		</div>
	</div>
	
	</div>
	
</body>
</html>