<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
		<table cellspacing="0" class="table table-bordered">
			<thead>
				<tr>
					<th colspan="5">
						<ul class="toolbar">
							<li><label class="checkbox"><input type="checkbox"><a href="#">全选</a> </label></li>
							<li><button class="button button-danger">
									<i class="icon-white icon-trash"></i>批量删除
								</button></li>
							<li><a href="curl/grade_input?parentId=<s:property value="parentId"/>" class="button button-success">添加当前级别</a></li>
							<li><a href="curl/grade_list?parentId=<s:property value="list.getIndex(0).parentId"/>" class="button button-success">返回上一级</a></li>
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
				<s:iterator value="list">
				<tr>
					<td><input type="checkbox"></td>
					<td><s:property value="id"/></td>
					<td><a href="curl/grade_list?parentId=<s:property value="id"/>"><s:property value="name"/></a></td>
					<td><s:property value="remarks"/></td>
					<td>
						<a href="curl/grade_delete?id=<s:property value="id"/>" class="button button-danger"><i class="icon-white icon-trash"></i>删除</a> 
						<a href="curl/grade_input?id=<s:property value="id"/>" class="button button-warning">更改</a> 
						<a href="curl/grade_introduce?id=<s:property value="id"/>" class="button">查看详情</a>
						<a href="curl/grade_input?parentId=<s:property value="id"/>" class="button button-success">添加子级别</a>
					</td>
				</tr>
				</s:iterator>
			</tbody>
		</table>