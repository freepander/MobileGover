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
<title>图片子项列表</title>
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
					<th>图片</th>
					<th>描述</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="pictureNews.items">
				<tr>
					<td><img src="upload/picturenews/<s:property value="img"/>" style="height:100px;"></td>
					<td><s:property value="description"/></td>
					<td><a href="curl/pictureNews_deleteItem?id=<s:property value="pictureNews.id"/>&itemId=<s:property value="id"/>" class="button">删除</a></td>
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
		<form method="post" action="curl/pictureNews_addItem" class="form-horizontal span24">
			<input type="hidden" name="id" value="<s:property value="pictureNews.id"/>" >
			<div class="row">
				<div class="control-group span16">
					<label class="control-label"><s>*</s>图片：</label>
					<div class="controls">
						<input type="text" name="img" id="logo" value="<s:property value="news.img"/>">
						<input type="button" value="点击选择图片" onclick="path.click()">
						<input type="file" name="file" style="display:none;" id="path" onchange="f_upload(this)">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="control-group span8">
					<label class="control-label"><s>*</s>描述：</label>
					<div class="controls">
						<textarea rows="10" cols="10" name="description"></textarea>
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
		    		data:{fileName:timestamp+'.'+s_name2,folderName:"picturenews"},
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