<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-color: #ecf4ff;
}

.dtree {
	font-family: Verdana, Geneva, Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #0000ff;
	white-space: nowrap;
}

.dtree img {
	border: 0px;
	vertical-align: middle;
}

.dtree a {
	color: #333;
	text-decoration: none;
}

.dtree a.node, .dtree a.nodeSel {
	white-space: nowrap;
	padding: 1px 2px 1px 2px;
}

.dtree a.node:hover, .dtree a.nodeSel:hover {
	color: #0000ff;
}

.dtree a.nodeSel {
	background-color: #AED0F4;
}

.dtree .clip {
	overflow: hidden;
}
-->
</style>
<link href="css/four.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/dtree.js"></script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<table width="96%" border="0" cellpadding="10" cellspacing="0"
		align="center">
		<tr>
			<td valign="top">
				<div class="menu">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><script type="text/javascript">

								  d = new dTree('d');
								  d.config.target = "main";
								  
								  d.add(0, -1, '仓储管理系统');
								  
								  /*d.add(1, 0, '冷冻库管理', '');
								  d.add(2, 0, '用户管理', '');
								  d.add(11, 1, '冷冻库列表', 'lk/lscab.do');
								  d.add(12, 1, '打冷登记表', 'lk/lsCool.do');
								  d.add(13, 1, '卡位列表', 'lk/lsLoc.do');
								  d.add(21, 2, '用户列表', 'lk/lsUser.do');
								
								  document.write(d);*/
								  $(function(){
									  $.get("lk/genTree.do",function(jsonArray){
										  if(jsonArray){
											  $.each(jsonArray,function(i,v){
												  if(v.uri){
													  d.add(i, v.prtNo, v.text, v.uri);
												  }else{
													  d.add(i, v.prtNo, v.text, '');
												  }
												  
											  });
											  document.write(d);
										  }
										  
									  });
								  });
								  
								  
							</script></td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>