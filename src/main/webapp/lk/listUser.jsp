<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/four.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="../css/jqe/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../css/jqe/themes/icon.css" />

<script type="text/javascript" src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>

<script type="text/javascript" >

   //进入jq
   $(function(){
	   
	   //初始化jq-easyUI对话框
	   $("#dlg,dlg2").window({onBeforeClose:function(){
		   setTimeout(function(){
			   sending.style.visibility="hidden";
		   },200);
	   }});
	   
	   //监听
	   $(".btnAll").click(function(){
		   
		   if( $(this).html()=="【新增】" ){
			   $("#dlg").window("open");
		   }else  if( $(this).html()=="【删除】" ){
			  //ajax
			  var btn = $(this);
			  if(confirm("确认删除?")){
				  $.get("delUser.do?userid="+$(this).prop("lang"),function(rtnMsg){
					  alert(rtnMsg);
					  //删除当前行
					  if("删除成功"==rtnMsg){
						        //td        //tr
						  $(btn).parent().parent().remove();
					  }
				  });
			  }
		   }else  if( $(this).html()=="【编辑】" ){
				 $.get("oneUser.do?userid="+$(this).prop("lang"),function(json){
					 if(json){
						 console.log(json);
						 $("#dlg2 input[name='NAME']").val(json.name);
						 $("#dlg2 input[name='ACCOUNT']").val(json.account);
						 $("#dlg2 input[name='IDENTITILY']").val(json.identitily);
						 $("#dlg2 input[name='TELEPHONE']").val(json.telephone);
						 $("#dlg2 input[name='ADDRESS']").val(json.address);
						 $("#dlg2 input[name='EDUCATION']").val(json.education);
						 $("#dlg2 input[name='ID']").val(json.id);
						 
						 $("#dlg2").window("open");
					 }else{
						 alert("被编辑的用户不存在.");
					 }
				 });	
	      }
		   
	   });
	   
	   
   });

</script>

 
</head>
<body>
	<!-- 包含等待框 -->
	<jsp:include page="../waittable.jsp" flush="true" />
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td bgcolor="#FFFFFF"><table width="96%" border="0"
					align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
					<tr align="left" bgcolor="#F2FDFF">
						<td colspan="7" class="optiontitle">系统用户信息</td>
					</tr>
					<tr align="center">
						<td align="center" bgcolor="#ebf0f7">名字</td>
						<td align="center" bgcolor="#ebf0f7">账户</td>
						<td align="center" bgcolor="#ebf0f7">身份</td>
						<td align="center" bgcolor="#ebf0f7">联系方式</td>
						<td align="center" bgcolor="#ebf0f7">地址</td>
						<td align="center" bgcolor="#ebf0f7">教育程度</td>
						<td align="center" bgcolor="#ebf0f7">操作 <span class="btnAll">【新增】</span>
						</td>
					</tr>
					<c:forEach items="${uers}" var="oneUsr">
						<tr align="center" bgcolor="#FFFFFF">
							<td align="center">${oneUsr.NAME}</td>
							<td align="center">${oneUsr.ACCOUNT}</td>
							<td align="center">${oneUsr.IDENTITILY}</td>
							<td align="center">${oneUsr.TELEPHONE}</td>
							<td align="center">${oneUsr.ADDRESS}</td>
							<c:choose>
						    	<c:when test="${oneUsr.EDUCATION==1}">
									<td align="center">高中</td>
								</c:when>
								<c:when test="${oneUsr.EDUCATION==2}">
									<td align="center">大专</td>
								</c:when>
								<c:when test="${oneUsr.EDUCATION==3}">
									<td align="center">本科</td>
								</c:when>
								<c:when test="${oneUsr.EDUCATION==4}">
									<td align="center">硕士</td>
								</c:when>
								<c:otherwise>
					                <td align="center">博士</td>
						          </c:otherwise>
						    </c:choose>
							<td align="center">
									  <span class="btnAll" lang="${oneUsr.ID}">【编辑】</span>
								    | <span class="btnAll" lang="${oneUsr.ID}">【删除】</span>
							</td>
						</tr>
					</c:forEach>
				</table></td>
		</tr>
		<tr>
			<td align="center" style="color: red">${msg}</td>
		</tr>
	</table>
	
	<div id="dlg" class="easyui-dialog" title="添加用户信息" data-options="iconCls:'icon-save',closed:true,modal:true" style="display:none;width:400px;height:300px;padding:10px;top:30px">
	   <form action="addUser.do">
	    <table>
	       <tr><td>名字</td><td><input name="NAME"/></td></tr>
	       <tr><td>账户</td><td><input name="ACCOUNT"/></td></tr>
	       <tr><td>身份</td><td><input name="IDENTITILY"/></td></tr>
	       <tr><td>联系方式</td><td><input name="TELEPHONE"/></td></tr>
	       <tr><td>地址</td><td><input name="ADDRESS"/></td></tr>
	       <tr><td>教育程度</td><td><input name="EDUCATION"/></td></tr>
	        <tr><td colspan="2">  <input type="submit" value="添加"/>  </td></tr>
	    </table>
	    </form>
	</div>
    <div id="dlg2" class="easyui-dialog" title="编辑用户信息" data-options="iconCls:'icon-save',closed:true,modal:true" style="display:none;width:400px;height:300px;padding:10px;top:30px">
	   <form action="updtUser.do">
	    <table>
	       <tr><td>名字</td><td><input name="NAME"/><input name="ID" type="hidden"  /></td></tr>
	       <tr><td>账户</td><td><input name="ACCOUNT"/></td></tr>
	       <tr><td>身份</td><td><input name="IDENTITILY"/></td></tr>
	       <tr><td>联系方式</td><td><input name="TELEPHONE"/></td></tr>
	       <tr><td>地址</td><td><input name="ADDRESS"/></td></tr>
	       <tr><td>教育程度</td><td><input name="EDUCATION"/></td></tr>
	        <tr><td colspan="2">  <input type="submit" value="修改"/>  </td></tr>
	    </table>
	    </form>
	</div>
	
	
	
</body>
</html>