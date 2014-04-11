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
<title>新闻列表</title>
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
							<li><a href="curl/news_input" class="button button-success">添加</a></li>
						</ul>
					</th>
				</tr>
				<tr>
					<th width="15"></th>
					<th>#</th>
					<th>标题</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="pageModel.objects">
				<tr>
					<td><input type="checkbox"></td>
					<td><s:property value="id"/></td>
					<td><s:property value="title"/></td>
					<td>
						<a href="curl/news_delete?id=<s:property value="id"/>" class="button button-danger"><i class="icon-white icon-trash"></i>删除</a> 
						<a href="curl/news_input?id=<s:property value="id"/>" class="button button-warning">更改</a>
						<a href="curl/news_setMain?id=<s:property value="id"/>" class="button button-warning">设为头条</a>
						<s:if test="main">"<s:property value="category.name"/>"模块头条新闻</s:if> 
					</td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
		<div>
			<div class="pagination pull-right">
				<ul>
          <li<s:if test="pageNum==1"> class="disabled"</s:if>><a href="<s:property value="pageModel.url" /><s:property value="pageNum-1" />">« 上一页</a></li>
          <s:iterator value="pageModel.pageNumList" status="st" >
          <s:if test="#st.index+1==pageNum">
          	<li class="active"><a href="<s:property value="pageModel.url" /><s:property value="#st.index+1" />"><s:property value="#st.index+1" /></a></li>
          </s:if>
          <s:if test="#st.index+1!=pageNum">
          	<li><a href="<s:property value="pageModel.url" /><s:property value="#st.index+1" />"><s:property value="#st.index+1" /></a></li>
          </s:if>
          </s:iterator>
          <li <s:if test="pageNum==pageModel.countPage" >class="disabled"</s:if>><a href="<s:property value="pageModel.url" /><s:property value="pageNum+1" />">下一页 »</a></li>
        </ul>
			</div>
		</div>
	</div>
</body>
</html>