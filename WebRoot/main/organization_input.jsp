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
<title>机构编辑</title>
<link rel="stylesheet" href="assets/css/bui-min.css" type="text/css"></link>
<link rel="stylesheet" href="assets/css/dpl-min.css" type="text/css"></link>
<link rel="stylesheet" href="assets/css/page-min.css" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<form action="curl/organization_<s:if test="id==0" >add</s:if><s:if test="id!=0">update</s:if>" class="form-horizontal span24">
				<input type="hidden" name="id" value="<s:property value="organization.id" />">
				<div class="row">
					<div class="control-group span16">
						<label class="control-label"><s>*</s>机构名称：</label>
						<div class="controls">
							<input name="name" value="<s:property value="organization.name"/>" type="text" class="input-normal control-text">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span16">
						<label class="control-label"><s>*</s>机排序值：</label>
						<div class="controls">
							<input name="orderNumber" value="<s:property value="organization.orderNumber"/>" type="text" class="input-normal control-text">
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="control-group span15">
						<label class="control-label">备注：</label>
						<div class="controls control-row4">
							<textarea name="remarks" class="input-large"><s:property value="organization.remarks"/></textarea>
						</div>
					</div>
				</div>
				<div class="row form-actions actions-bar">
					<div class="span13 offset3 ">
						<button type="submit" class="button button-primary">保存</button>
						<button type="reset" class="button">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>