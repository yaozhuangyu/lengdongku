<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jk" uri="http://www.jkoss.com/mytaglib"%>
<%  String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh_cn">
<head>
<meta charset="UTF-8"/>
<base href="<%=basePath%>" />
<title>冷冻库仓储管理系统</title>
<STYLE type=text/css>
body {
	FONt-SIZE: 12px;
	BACKGROUND: #E8F2FB;
	COLOR: #333;
	MARGIN: 80px;
}

.bt {
	font-size: 24px;
	color: #FFFFFF;
	text-align: center;
	font-weight: bold;
}

.btn {
	BORDER-RIGHT: #0033cc 1px solid;
	BORDER-TOP: #00ccff 1px solid;
	FONT-SIZE: 12px;
	BORDER-LEFT: #00ccff 1px solid;
	CURSOR: hand;
	COLOR: #ffffff;
	BORDER-BOTTOM: #0033cc 1px solid;
	FONT-FAMILY: "宋体";
	BACKGROUND-COLOR: #0099ff;
}

span {
	text-decoration: none;
	color: blue;
}

span:hover {
	text-decoration: underline;
	color: red;
}

span:visited {
	text-decoration: none;
	color: green;
}
</STYLE>
<link rel="stylesheet" type="text/css"
	href="css/jqe/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="css/jqe/themes/icon.css" />

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

<script type="text/javascript">

	function checkLogin() {
		var username = document.myform.lgnName.value;
		var password = document.myform.pwdword.value;
		if (username == '') {
			alert('请输入用户名');
			document.myform.lgnName.focus();
			return false;
		}
		if (password == '') {
			alert('请输入密码');
			document.myform.pwdword.focus();
			return false;
		}
	}
	if (window != top) {
		//frame内嵌问题 （场景是 用户登出时，返回login.jsp出现内嵌）
		top.location.href = location.href;
	}

	$(function() {
		
		//定义一个全局变量
		var phone;
		
		$('#dw').window({
			onBeforeClose : function() {
				//取消时关闭等待框
				setTimeout(function() {
					sending.style.visibility = "hidden";
				}, 250);
			}
		});

		/* $("#dw_add").click(
				function() {
					$.get("oa/fdPwd.do?email=" + $("#email").val() + "&ephone="
							+ $("#ephone").val() + "&x=" + Math.random(),
							function(jsonTxt) {

								alert(jsonTxt);
								$("#email").val("");
								$("#ephone").val("")
								$('#dw').window("close");
							});
				}); */

		$("#findP").click(function() {
			$('#dw').window("open");
			//输入名字，还有手机号
			//判断手机号是否属于该名字
			//正确的话发送验证码  
		});
				
$("#dw_add").click(function(){
			
			var tel = $("#ephone").val(); //获取手机号
			var telReg = !!tel.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/);
			//如果手机号码不能通过验证
			if(telReg == false){
				alert("手机号格式输入错误");
			}else{
				//把局部变量放到全局
				phone=tel;
				$.get("lk/yzm.do?ephone="+tel,function(object){
					$("#tips").html("");
					$("#tips1").html("");
					if(object == "该手机没有对应的用户"){
						$("#tips").html("该手机没有对应的用户");
					}
					else{
						$("#checkyzm").click(function(){
							if($("#yzm").val() == object){
							  $("#dw").window("close");
							  $("#dw1").window("open");
							}
							else{
								$("#tips1").html("验证码输入错误");
							}
						})
					}
				})
			}
			
		});
		
		$("#updpass").click(function(){
			//判断第一次输入的密码和第二次输入的是否一致
			if($("#psdone").val() == $("#psdtwo").val()){
				$.get("lk/updPass.do?phone="+phone+"&password="+$("#psdone").val(),function(object){
					if(object == "更新成功"){
						alert("密码修改成功");
						$("#dw1").window("close");
					}
					else{
						alert("密码修改失败");
						$("#dw1").window("close");
					}
				})
			}
			else{
				alert("两次输入的密码不一致");
			}
			
		});

	});
</script>
</head>
<body>
	<form action="<%=basePath%>lk/login.do" name="myform" method="post"
		onSubmit="return checkLogin()">
		<table cellSpacing=1 cellPadding=5 width=460 align=center
			bgColor=#b9b0a9 border=0>
			<tbody>
				<tr>
					<td vAlign=top bgColor=#ffffff>
						<table cellSpacing=0 cellPadding=0 width="100%" border=0>
							<tbody>
								<tr>
									<td width=460 background=images/login_top.jpg height=54 class="bt">冷冻库仓储管理系统</td>
								</tr>
								<tr>
									<td bgColor=#FFFFFF height=150>
										<table height="100%" cellSpacing=0 cellPadding=0 width="100%"
											border=0>
											<tbody>
												<tr>
													<td align=middle width="40%"><IMG height=90
														src="images/login.gif" width=91></td>
													<td>
														<table cellSpacing=1 cellPadding=2 width="100%"
															align=center border=0>
															<tbody>
																<tr>
																	<td align=right width=60 height=30>用户名：</td>
																	<td height=30><input id="lgnName" name="name" value=""></td>
																</tr>
																<tr>
																	<td align=right height=30>密&nbsp;&nbsp;码：</td>
																	<td height=30><input id="pwdword" type="password"
																		name="password" value=""></td>
																</tr>
																<tr align="center">
																	<td colSpan=2 height=40><input class="btn"
																		type=submit value="登录" name="Submit"> 
																		<input class="btn" type="reset" value="清除" name="reset">
																		<br><br><span id="findP">找回密码</span></td>
																</tr>
																<tr align="center">
																	<td colSpan=2 height=40>${requestScope.msg}</td>
																</tr>
															</tbody>
														</table>
													</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td align=middle bgColor=#9CBFE5 height=25>2017&copy;冷冻库仓储管理系统 All Rights Reserved by ossjk.cn</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<div id="dw" class="easyui-window" title="通过手机号找回密码"
		data-options="modal:true,minimizable:false,closed:true,maximizable:false,iconCls:'icon-save'"
		style="width: 350px; height: 180px; padding: 10px; display: none;">
		手机号：<input id="ephone" type="text"/>    <input type="button" id="dw_add" value="发送验证码 " /><br>
		<span id="tips" style="color:red"></span><br>
		验证码：<input id='yzm' type="text"/> <br>
		<span id="tips1" style="color:red"></span><br>
		<input type="button" id="checkyzm" value="确认 " />
	</div>
	
	<div id="dw1" class="easyui-window" title="输入新密码"
		data-options="modal:true,minimizable:false,closed:true,maximizable:false,iconCls:'icon-save'"
		style="width: 350px; height: 180px; padding: 10px; display: none;">
		新     密     码  ：<input id='psdone' type="password"/> <br><br>
            再 次 确 认 ：<input id='psdtwo' type="password"/><br><br>
          <input type='button' id='updpass' value='提交' />
	</div>
</body>
</html>
