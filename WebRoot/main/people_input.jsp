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
<title>人员编辑</title>
<link rel="stylesheet" href="assets/css/bui-min.css" type="text/css"></link>
<link rel="stylesheet" href="assets/css/dpl-min.css" type="text/css"></link>
<link rel="stylesheet" href="assets/css/page-min.css" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<form action="curl/people_<s:if test="id==0" >add</s:if><s:if test="id!=0">update</s:if>" class="form-horizontal span24">
				<div class="row">
					<div class="control-group span16">
						<label class="control-label"><s>*</s>姓名：</label>
						<div class="controls">
							<input name="name" value="<s:property value="people.name"/>" type="text" class="input-normal control-text">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span16">
						<label class="control-label"><s>*</s>性别：</label>
						<div class="controls">
							<input type="radio" name="sex" value="true" checked> 男<input type="radio" value="false" name="sex"> 女
						</div> 
					</div>
				</div>
				<div class="row">
					<div class="control-group span16">
						<label class="control-label"><s>*</s>所属部门：</label>
						<div class="controls">
							<select name="departmentId">
								<option value="<s:property value="people.department.id"/>"><s:property value="people.department.name"/></option>
								<s:iterator value="list">
								<option value="<s:property value="id"/>"><s:property value="name"/></option>	
								</s:iterator>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span16">
						<label class="control-label"><s>*</s>头像：</label>
						<div class="controls">
							<input type="text" name="logo" id="logo" value="<s:property value="people.logo"/>">
							<input type="button" value="点击选择图片" onclick="path.click()">
							<input type="file" name="file" style="display:none;" id="path" onchange="f_upload(this)">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span16">
						<label class="control-label"><s>*</s>职务：</label>
						<div class="controls">
							<input name="post" value="<s:property value="people.post"/>" type="text" class="input-normal control-text">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span16">
						<label class="control-label"><s>*</s>办公室电话：</label>
						<div class="controls">
							<input name="officeTelphone" value="<s:property value="people.officeTelphone"/>" type="text" class="input-normal control-text">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span16">
						<label class="control-label"><s>*</s>电话：</label>
						<div class="controls">
							<input name="telphone" value="<s:property value="people.telphone"/>" type="text" class="input-normal control-text">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span16">
						<label class="control-label"><s>*</s>住宅电话：</label>
						<div class="controls">
							<input name="residential" value="<s:property value="people.residential"/>" type="text" class="input-normal control-text">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span16">
						<label class="control-label"><s>*</s>地址：</label>
						<div class="controls">
							<input name="address" value="<s:property value="people.address"/>" type="text" class="input-normal control-text">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="control-group span15">
						<label class="control-label">备注：</label>
						<div class="controls control-row4">
							<textarea name="remarks" class="input-large" type="text"><s:property value="people.remarks"/></textarea>
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
	<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="assets/js/ajaxfileupload.js"></script>
	<script>
	function f_upload(a){
		var timestamp=new Date().getTime()
    	var s_name=$(a).val();
    	var s_names=s_name.split(".");
    	var s_name2=s_names[s_names.length-1];
    	$('#logo').val(timestamp+'.'+s_name2);
    	$.ajaxFileUpload({
    		url:'curl/file_upload',
    		secureuri:false,
    		fileElementId:'path',
    		data:{fileName:timestamp+'.'+s_name2,folderName:"people"},
    		beforeSend:function(){},
    		success: function(){
    			alert("上传成功"); 
    		}
    	});
    	return false;
    }
	</script>
</body>
</html>