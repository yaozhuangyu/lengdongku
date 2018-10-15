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

<script type="text/javascript">
	//进入jq
	$(function() {

		//初始化jq-easyUI对话框
		$("#dlg,dlg2").window({
			onBeforeClose : function() {
				setTimeout(function() {
					sending.style.visibility = "hidden";
				}, 200);
			}
		});

		//监听
		$(".btnAll").click(
				function() {

					if ($(this).html() == "【新增】") {
						$("#dlg").window("open");
					} else if ($(this).html() == "【删除】") {
						//ajax
						var btn = $(this);
						if (confirm("确认删除?")) {
							$.get("delrepay.do?ID=" + $(this).prop("lang"),
									function(rtnMsg) {
										alert(rtnMsg);
										//删除当前行
										if ("删除成功" == rtnMsg) {
											//td        //tr
											$(btn).parent().parent().remove();
										}
									});
						}
					} else  if( $(this).html()=="【编辑】" ){
						 $.get("onerepay.do?reid="+$(this).prop("lang"),function(json){
							if(json){
								 $("#dlg2 input[name='REGID']").val(json.redid);
								 $("#dlg2 input[name='CUSTOMERID']").val(json.customerid);
								 $("#dlg2 input[name='BEGINTIME']").val(json.begintime);
								 $("#dlg2 input[name='ENDTIME']").val(json.endtime);
								 $("#dlg2 input[name='STOPTIME']").val(json.stoptime);
								 $("#dlg2 input[name='STATE']").val(json.state);
								 $("#dlg2 input[name='REMARK']").val(json.remark);
								 $("#dlg2 input[name='REPAYHOURS']").val(json.repayhours);
								 $("#dlg2 input[name='ID']").val(json.id);
								 
								 $("#dlg2").window("open");
							 }else{
								 alert("被编辑的停车场不存在.");
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
						<td colspan="9" class="optiontitle">补时
							<form action="serrepay.do" method="post" >
                                   <table>
                                   <tr>
                                           <td>
										客戶编号
										<input id="CUSTOMERID"
											name="CUSTOMERID" value="" />
											</td>
											<td>
										<input type="submit" name="submit"
											value="搜索" />
											</td>
									</tr>
			                          </table>
							</form>

						</td>
					</tr>

					<tr align="center">

						<td align="center" bgcolor="#ebf0f7">单号</td>
						<td align="center" bgcolor="#ebf0f7">客戶编号</td>
						<td align="center" bgcolor="#ebf0f7">开始时间</td>
						<td align="center" bgcolor="#ebf0f7">结束时间</td>
						<td align="center" bgcolor="#ebf0f7">停止时间</td>
						<td align="center" bgcolor="#ebf0f7">状态</td>
						<td align="center" bgcolor="#ebf0f7">备注</td>
						<td align="center" bgcolor="#ebf0f7">补时</td>
						<td align="center" bgcolor="#ebf0f7">操作 <span class="btnAll">【新增】</span>
						</td>
					</tr>
					<c:forEach items="${akk}" var="onecold">
						<tr align="center" bgcolor="#FFFFFF">
							<td align="center">${onecold.REGID}</td>
							<td align="center">${onecold.CUSTOMERID}</td>
							<td align="center"><fmt:formatDate value="${onecold.BEGINTIME}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td align="center"><fmt:formatDate value="${onecold.ENDTIME}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td align="center"><fmt:formatDate value="${onecold.STOPTIME}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<c:if test="${onecold.STATE==0}">
								<td align="center">未补时</td>
							</c:if>
							<c:if test="${onecold.STATE==1}">
								<td align="center">已补时</td>
							</c:if>
							<td align="center">${onecold.REMARK}</td>
							<td align="center">${onecold.REPAYHOURS}</td>
							<td align="center">
									<span class="btnAll" lang="${onecold.ID}">【编辑】</span>
								  | <span class="btnAll" lang="${onecold.ID}">【删除】</span>
						 
							</td>
						</tr>
					</c:forEach>
				</table></td>
		</tr>
		<tr>
		   <td align="center" style="color: red">${msg}</td>
		</tr>
	
	</table>
	<div id="dlg" class="easyui-dialog" title="添加补时" data-options="iconCls:'icon-save',closed:true,modal:true" style="display:none;width:400px;height:300px;padding:10px;top:30px">
	   <form action="addrepay.do">
	    <table>
	       <tr><td>单号</td><td><input name="REGID"/></td></tr>
	       <tr><td>客戶编号</td><td><input name="CUSTOMERID"/></td></tr>
	       <tr><td>开始时间</td><td><input name="BEGINTIME" /></td></tr>
	       <tr><td>结束时间</td><td><input name="ENDTIME"/></td></tr>
	       <tr><td>停止时间</td><td><input name="STOPTIME" /></td></tr>
	       <tr><td>状态</td><td><input name="STATE"/></td></tr>
	       <tr><td>备注</td><td><input name="REMARK"/></td></tr>
	       <tr><td>补时</td><td><input name="REPAYHOURS"/></td></tr>
	        <tr><td colspan="2">  <input type="submit" value="添加"/>  </td></tr>
	    </table>
	    </form>
	</div>
	<div id="dlg2" class="easyui-dialog" title="修改补时" data-options="iconCls:'icon-save',closed:true,modal:true" style="display:none;width:400px;height:300px;padding:10px;top:30px">
	   <form action="updrepay.do">
	    <table>
	       <tr><td>单号</td><td><input name="REGID"/></td></tr><input name="ID" type="hidden"  /></td></tr>
	       <tr><td>客戶编号</td><td><input name="CUSTOMERID"/></td></tr>
	       <tr><td>开始时间</td><td><input name="BEGINTIME" /></td></tr>
	       <tr><td>结束时间</td><td><input name="ENDTIME" /></td></tr>
	       <tr><td>停止时间</td><td><input name="STOPTIME" /></td></tr>
	       <tr><td>状态</td><td><input name="STATE"/></td></tr>
	       <tr><td>备注</td><td><input name="REMARK"/></td></tr>
	       <tr><td>补时</td><td><input name="REPAYHOURS"/></td></tr>
	        <tr><td colspan="2">  <input type="submit" value="修改"/>  </td></tr>
	    </table>
	    </form>
	</div>


</body>
</html>