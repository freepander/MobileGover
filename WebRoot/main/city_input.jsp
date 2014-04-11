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
		<div class="row">
			<form action="curl/city_<s:if test="id==0" >add</s:if><s:if test="id!=0">update</s:if>" class="form-horizontal span24">
			<input type="hidden" name="id" value="<s:property value="city.id"/>">
				<div class="row">
					<div class="control-group span16">
						<label class="control-label"><s>*</s>市名称：</label>
						<div class="controls">
							<input name="name" value="<s:property value="city.name"/>" type="text" class="input-normal control-text">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span16">
						<label class="control-label"><s>*</s>所在省：</label>
						<div class="controls">
							<select name="provinceId">
								<option value="<s:property value="city.provice.id"/>"><s:property value="city.provice.name"/></option>
							<s:iterator value="provinceList">
								<option value="<s:property value="id"/>"><s:property value="name"/></option>
							</s:iterator>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span15">
						<label class="control-label">备注：</label>
						<div class="controls control-row4">
							<textarea name="remarks" class="input-large"><s:property value="city.remarks"/></textarea>
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