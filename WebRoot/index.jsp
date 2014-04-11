<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>电子政务后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="header">
		<div class="dl-title">
			<a href="http://www.builive.com" title="电子政务后台管理系统" target="_blank">
				<span class="lp-title-port">电子政务后台管理系统</span></a>
		</div>
		<div class="dl-log">
			欢迎您，<span class="dl-log-user">username</span><a
				href="###" title="退出系统" class="dl-log-quit">[退出]</a>
		</div>
	</div>
	<div class="content">
		<div class="dl-main-nav">
			<ul id="J_Nav" class="nav-list ks-clear">
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-home">内容</div>
				</li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-home">人员</div>
				</li>
			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten">

		</ul>
	</div>
	<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="./assets/js/bui.js"></script>
	<script type="text/javascript" src="./assets/js/config.js"></script>

	<script>
		BUI.use('common/main', function() {
			var config = [ {
				id : 'menu',
				homePage : 'index',
				menu : [ {
					text : '政务内容管理',
					items : [{
						id : 'index',
						text : '电子政务首页',
						href : 'curl/news_list'
					},{
						id : 'newsList',
						text : '新闻列表',
						href : 'curl/news_list'
					},{
						id : 'addNews',
						text : '添加新闻',
						href : 'curl/news_input'
					},{
						id : 'pictureNewsList',
						text : '图片列表',
						href : 'curl/pictureNews_list'
					},{
						id : 'videoList',
						text : '视频列表',
						href : 'curl/video_list'
					}  ]
				} ]
			}, {
				id : 'form',
				menu : [ {
					text : '通讯录管理',
					items : [ {
						id : 'people',
						text : '人员管理',
						href : 'curl/people_list'
					}, {
						id : 'department',
						text : '部门管理',
						href : 'curl/department_list'
					}, {
						id : 'organization',
						text : '机构管理',
						href : 'curl/organization_list'
					} ]
				} ]
			} ];
			new PageUtil.MainPage({
				modulesConfig : config
			});
		});
	</script>
</body>
</html>
